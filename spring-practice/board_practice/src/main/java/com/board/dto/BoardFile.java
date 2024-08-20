package com.board.dto;

import lombok.Data;

@Data
public class BoardFile {
	private int id, boardId;
	private String originFileName, storedFilePath;
	private long fileSize;
}
