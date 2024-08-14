package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.movie.dto.FileDTO;
import com.movie.dto.MovieDTO;
import com.movie.service.MovieService;
import com.movie.service.MovieServiceImpl;

@Controller
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	private MovieService ms = new MovieServiceImpl();

	// 영화 리스트 보여주기
	@RequestMapping(value = { "", "/", "/list" })
	public ModelAndView showAllMovies() throws Exception {
		ModelAndView mav = new ModelAndView("/movie/list");
		List<MovieDTO> movieList = ms.getAllMovies();
		mav.addObject("list", movieList);
		return mav;
	}

	// 영화 정보 화면 보여주기
	@GetMapping("/post")
	public String showPostMovie() {
		return "movie/post";
	}

	// 영화 정보 작성
	@PostMapping("/post")
	public String addMovie(MovieDTO movieDTO,
			@RequestParam(value = "files", required = false) List<MultipartFile> files) throws Exception {
		ms.postMovie(movieDTO);
		return "redirect:/movie";
	}

	// 영화 정보 상세보기
	@GetMapping("/detail/{id}")
	public ModelAndView showMovie(MovieDTO movie) throws Exception {
		ModelAndView mav = new ModelAndView("/movie/detail");
		MovieDTO movieDTO = ms.getMovieById();
		mav.addObject("movie", movieDTO);
		return mav;
	}

	// 영화 정보 삭제
	@DeleteMapping("/delete")
	public String deleteMovie(@RequestParam("id") int id) throws Exception {
		ms.deleteMovie(id);
		return "redirect:/movie";
	}

	// 영화 정보 수정
	@PatchMapping("/update")
	public String updateMovie(MovieDTO movieDTO,
			@RequestParam(value = "files", required = false) List<MultipartFile> files) throws Exception {
		ms.updateMovie(movieDTO);
		return "redirect:/movie";
	}

	// 영화 관련 이미지 다운로드
	@RequestMapping("/download")
	public ResponseEntity<Resource> downloadFile(@RequestParam("id") int id, @RequestParam("movieId") int movieId)
			throws Exception {
		FileDTO fileDTO = ms.selectFileById(id, movieId);

		return null;
	}

}
