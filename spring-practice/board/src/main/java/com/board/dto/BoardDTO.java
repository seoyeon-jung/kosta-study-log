package com.board.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
// DTO(Data Transfer Object) : 각 계층(뷰, 컨트롤러, 서비스) 간 데이터를 주고받을 때 사용되는 객체
public class BoardDTO {
	private int id;
	private String title, content;
	private int hit;
	private LocalDateTime createdAt;
	private String creator;
	private LocalDateTime updatedAt;
	private List<FileDTO> fileList; // 글에 첨부된 파일 list
}