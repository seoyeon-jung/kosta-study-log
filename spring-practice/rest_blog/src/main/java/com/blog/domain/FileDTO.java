package com.blog.domain;

import com.blog.entity.ImageFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FileDTO {
	private Long id;
	// kbSize : 화면에서 파일 크기를 보여주기 위한 string
	private String origin, saved, kbSize;
	private Long size;

	public static FileDTO toDTO(ImageFile imageFile) {
		if (imageFile == null)
			return null;

		return FileDTO.builder().id(imageFile.getId()).origin(imageFile.getOriginalName())
				.saved(imageFile.getSavedName()).kbSize(((Double) (imageFile.getFileSize() / 1024.0)).toString())
				.build();
	}
}
