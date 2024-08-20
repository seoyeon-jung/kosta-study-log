package com.board.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class Board {
	private int id;
	private String title, content;
	private LocalDateTime createdAt;
	private User creator;
	private List<BoardFile> fileList;
}
