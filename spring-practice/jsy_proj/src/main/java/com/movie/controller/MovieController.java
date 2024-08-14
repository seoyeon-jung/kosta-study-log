package com.movie.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;

import com.movie.dto.FileDTO;
import com.movie.dto.MovieDTO;
import com.movie.dto.UserDTO;
import com.movie.service.MovieService;
import com.movie.service.MovieServiceImpl;
import com.movie.service.UserService;
import com.movie.service.UserServiceImpl;

@Controller
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	private MovieService ms = new MovieServiceImpl();
	@Autowired
	private UserService us = new UserServiceImpl(); // 글 작성할 때 작성자를 선택하기 위한 userService

	// 영화 리스트 보여주기
	@RequestMapping(value = { "", "/", "/list" })
	public ModelAndView showAllMovies() throws Exception {
		ModelAndView mav = new ModelAndView("/movie/list");
		List<MovieDTO> movieList = ms.getAllMovies();
		mav.addObject("movieList", movieList);
		return mav;
	}

	// 영화 정보 작성 화면 보여주기
	@GetMapping("/post")
	public ModelAndView showPostMovie() throws Exception {
		ModelAndView mav = new ModelAndView("movie/post");
		List<UserDTO> userList = us.getAllUserList();
		mav.addObject("userList", userList);
		return mav;
	}

	// 영화 정보 작성
	@PostMapping("/post")
	public String addMovie(MovieDTO movieDTO,
			@RequestParam(value = "files", required = false) List<MultipartFile> files) throws Exception {
		ms.postMovie(movieDTO, files);
		return "redirect:/movie";
	}

	// 영화 정보 상세보기
	@GetMapping("/detail/{id}")
	public ModelAndView showMovie(@PathVariable("id") int id) throws Exception {
		ModelAndView mav = new ModelAndView("movie/detail");
		MovieDTO movieDTO = ms.getMovieById(id);
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
		ms.updateMovie(movieDTO, files);
		return "redirect:/movie";
	}

	// 영화 관련 이미지 다운로드
	@RequestMapping("/detail/download")
	public ResponseEntity<Resource> downloadFile(@RequestParam("id") int id, @RequestParam("movieId") int movieId)
			throws Exception {
		FileDTO fileDTO = ms.selectFileById(id, movieId);
		String fileName = fileDTO.getOriginFileName();
		UrlResource resource;
		try {
			resource = new UrlResource("file:" + fileDTO.getStoredFilePath());
		} catch (Exception e) {
			throw new Exception("파일 다운로드 에러");
		}

		String encodedFileName = UriUtils.encode(fileName, StandardCharsets.UTF_8);
		String contentDispostionValue = "attachment; filename=\"" + encodedFileName + "\"";

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, contentDispostionValue).body(resource);
	}

}
