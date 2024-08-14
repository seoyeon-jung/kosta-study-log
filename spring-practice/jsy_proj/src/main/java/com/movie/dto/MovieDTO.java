package com.movie.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class MovieDTO {
	private int id;
	private String title, release_date, genre, director, summary;
	private int userId;
	private LocalDateTime createdAt;
	private List<FileDTO> fileList;
}
