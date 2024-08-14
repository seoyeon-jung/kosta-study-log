package com.movie.dto;

import lombok.Data;

@Data
public class FileDTO {
	private int id, movieId;
	private String originFileName, storedFilePath;
	private long fileSize;
}
