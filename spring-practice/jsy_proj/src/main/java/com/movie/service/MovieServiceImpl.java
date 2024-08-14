package com.movie.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.movie.dto.FileDTO;
import com.movie.dto.MovieDTO;
import com.movie.mapper.FileMapper;
import com.movie.mapper.MovieMapper;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieMapper movieMapper;
	@Autowired
	private FileMapper fileMapper;

	@Override
	public List<MovieDTO> getAllMovies() throws Exception {
		return movieMapper.selectAllmovies();
	}

	@Override
	public void postMovie(MovieDTO movieDTO, List<MultipartFile> files) throws Exception {
		movieMapper.insertMovie(movieDTO);
		int movieId = movieDTO.getId();

		// 첨부 파일이 존재하는 경우
		if (files != null && !files.isEmpty()) {
			List<FileDTO> fileList = new ArrayList<>();

			// 파일 하나씩 가져오기
			for (MultipartFile file : files) {
				if (!file.isEmpty()) {
					// 원본 파일명
					String originFileName = file.getOriginalFilename();
					// 새로운 파일명
					String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
					String storedFileName = timeStamp + "_" + originFileName;
					// 파일 저장경로 + 새로운 파일명
					String storedFilePath = "C:\\Users\\WD\\movieImage\\" + storedFileName;
					// 파일 크기
					long fileSize = file.getSize();

					FileDTO fileDTO = new FileDTO();
					fileDTO.setMovieId(movieId);
					fileDTO.setFileSize(fileSize);
					fileDTO.setOriginFileName(originFileName);
					fileDTO.setStoredFilePath(storedFilePath);

					fileList.add(fileDTO);

					// 파일 저장
					try {
						File dest = new File(storedFilePath);
						file.transferTo(dest);
					} catch (IOException e) {
						throw new Exception("파일 업로드 중 오류가 발생했습니다");
					}
				}
			}
			if (!fileList.isEmpty()) {
				fileMapper.insertFile(fileList);
			}
		}
	}

	@Override
	public MovieDTO getMovieById(int id) throws Exception {
		MovieDTO movieDTO = movieMapper.selectMovieById(id);
		List<FileDTO> fileList = fileMapper.selectFileListByMovieId(id);
		movieDTO.setFileList(fileList);
		return movieDTO;
	}

	@Override
	public void deleteMovie(int id) throws Exception {
		movieMapper.deleteMovieById(id);
	}

	@Override
	public void updateMovie(MovieDTO movieDTO, List<MultipartFile> files) throws Exception {
		movieMapper.updateMovie(movieDTO);
		int movieId = movieDTO.getId();

		// 첨부 파일이 존재하는 경우
		if (files != null && !files.isEmpty()) {
			List<FileDTO> fileList = new ArrayList<>();

			// 파일 하나씩 가져오기
			for (MultipartFile file : files) {
				if (!file.isEmpty()) {
					// 원본 파일명
					String originFileName = file.getOriginalFilename();
					// 새로운 파일명
					String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
					String storedFileName = timeStamp + "_" + originFileName;
					// 파일 저장경로 + 새로운 파일명
					String storedFilePath = "C:\\Users\\WD\\movieImage" + storedFileName;
					// 파일 크기
					long fileSize = file.getSize();

					FileDTO fileDTO = new FileDTO();
					fileDTO.setMovieId(movieId);
					fileDTO.setFileSize(fileSize);
					fileDTO.setOriginFileName(originFileName);
					fileDTO.setStoredFilePath(storedFilePath);

					fileList.add(fileDTO);

					// 파일 저장
					try {
						File dest = new File(storedFilePath);
						file.transferTo(dest);
					} catch (IOException e) {
						throw new Exception("파일 업로드 중 오류가 발생했습니다");
					}
				}
			}
			if (!fileList.isEmpty()) {
				fileMapper.insertFile(fileList);
			}
		}

	}

	@Override
	public FileDTO selectFileById(int id, int movieId) throws Exception {
		return fileMapper.selectFilesByIds(id, movieId);

	}

}
