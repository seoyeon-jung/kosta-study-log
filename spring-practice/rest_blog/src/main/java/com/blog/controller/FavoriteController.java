package com.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.domain.FavoriteRequest;
import com.blog.domain.FavoriteResponse;
import com.blog.service.FavoriteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/favorite")
public class FavoriteController {
	private final FavoriteService favoriteService;

	// 전체 즐겨찾기 리스트 가져오기
	@GetMapping("")
	public ResponseEntity<List<FavoriteResponse>> getAllFav(@RequestParam(name = "id", required = false) Long id) {
		List<FavoriteResponse> list = new ArrayList<FavoriteResponse>();
		if (id == null) {
			list = favoriteService.getAllFav();
		} else {
			FavoriteResponse favorite = favoriteService.getFavoriteById(id);
			list.add(favorite);
		}
		return ResponseEntity.ok(list);
	}

	// 즐겨찾기 하나 조회
	@GetMapping("/{id}")
	public ResponseEntity<FavoriteResponse> getFavById(@PathVariable("id") Long id) {
		FavoriteResponse favoriteResponse = favoriteService.getFavoriteById(id);
		return ResponseEntity.ok(favoriteResponse);
	}

	// 즐겨찾기 추가
	@PostMapping("")
	public ResponseEntity<FavoriteResponse> writeFav(FavoriteRequest fav,
			@RequestParam(name = "image") MultipartFile file) {
		FavoriteResponse savedFavorite = favoriteService.insertFav(fav, file);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedFavorite);
	}

	// 즐겨찾기 수정
	@PatchMapping("")
	public ResponseEntity<FavoriteResponse> modifyFav(FavoriteRequest fav,
			@RequestParam(name = "image") MultipartFile file) {
		FavoriteResponse updatedFavorite = favoriteService.updateFav(fav, file);
		return ResponseEntity.ok(updatedFavorite);
	}

	// 즐겨찾기 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<FavoriteResponse> removeFav(@PathVariable("id") Long id) {
		FavoriteResponse favoriteResponse = favoriteService.deleteFav(id);
		return ResponseEntity.ok(favoriteResponse);
	}
}
