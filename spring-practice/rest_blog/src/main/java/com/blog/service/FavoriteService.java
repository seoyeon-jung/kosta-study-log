package com.blog.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.blog.domain.FavoriteRequest;
import com.blog.domain.FavoriteResponse;

public interface FavoriteService {

	FavoriteResponse insertFav(FavoriteRequest fav, MultipartFile file);

	List<FavoriteResponse> getAllFav();

	FavoriteResponse getFavoriteById(Long id);

	FavoriteResponse deleteFav(Long id);

	FavoriteResponse updateFav(FavoriteRequest fav, MultipartFile file);

}
