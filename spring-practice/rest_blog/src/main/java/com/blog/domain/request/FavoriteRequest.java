package com.blog.domain.request;

import com.blog.entity.Favorite;
import com.blog.entity.ImageFile;

import lombok.Builder;
import lombok.Data;

//추가랑 수정할 때 사용하는 DTO
//각각 나눠서 만들어도 된다
@Data
public class FavoriteRequest {
	private Long id;
	private String title, url;
	private ImageFile imageFile;

	@Builder
	public Favorite toEntity() {
		return Favorite.builder().id(id).title(title).url(url).image(imageFile).build();
	}
}
