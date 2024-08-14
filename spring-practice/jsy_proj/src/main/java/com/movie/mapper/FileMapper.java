package com.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.movie.dto.FileDTO;

@Mapper
public interface FileMapper {

	void insertFile(List<FileDTO> fileList) throws Exception;

	List<FileDTO> selectFileListByMovieId(int id) throws Exception;

	FileDTO selectFilesByIds(@Param("id") int id, @Param("movieId") int movieId) throws Exception;

}
