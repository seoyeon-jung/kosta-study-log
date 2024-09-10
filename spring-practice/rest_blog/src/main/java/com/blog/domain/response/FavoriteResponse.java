package com.blog.domain.response;

import com.blog.domain.FileDTO;
import com.blog.entity.Favorite;

import lombok.Builder;
import lombok.Data;

//화면에 찍힐 것들을 정의
@Data
@Builder
public class FavoriteResponse {
	// title, image만 찍히도록
	private Long id; // id는 알아야 하니까
	private String title, url;
	private FileDTO imageFile;

	public static FavoriteResponse toDTO(Favorite favorite) {
		return FavoriteResponse.builder().id(favorite.getId()).title(favorite.getTitle()).url(favorite.getUrl())
				.imageFile(FileDTO.toDTO(favorite.getImage())).build();
	}

}
