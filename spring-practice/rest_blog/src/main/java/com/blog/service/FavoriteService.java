package com.blog.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.blog.domain.request.FavoriteRequest;
import com.blog.domain.response.FavoriteResponse;

public interface FavoriteService {

	FavoriteResponse insertFav(FavoriteRequest fav, MultipartFile file);

	List<FavoriteResponse> getAllFav();

	FavoriteResponse getFavoriteById(Long id);

	FavoriteResponse deleteFav(Long id);

	FavoriteResponse updateFav(FavoriteRequest fav, MultipartFile file);

}
