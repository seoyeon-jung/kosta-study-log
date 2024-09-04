package com.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog.domain.FavoriteRequest;
import com.blog.domain.FavoriteResponse;
import com.blog.entity.Favorite;
import com.blog.entity.ImageFile;
import com.blog.repository.FavoriteRepository;
import com.blog.repository.ImageFileRepository;
import com.blog.util.FileUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {
	private final FavoriteRepository favoriteRepository;
	private final FileUtils fileUtils;
	private final ImageFileRepository imageFileRepository;

	// 이미지 저장 메소드 (중복되므로 메소드 생성)
	private ImageFile saveImage(MultipartFile file) {
		if (file != null) {
			// originalFileName으로 기존에 이미지가 존재하는지 여부 확인
			String fileName = file.getOriginalFilename();
			ImageFile existingImage = imageFileRepository.findByFileName(fileName);

			if (existingImage != null) {
				return existingImage; // 기존 이미지 재사용
			}

			// 새 이미지 파일 가져오기
			ImageFile imageFile = fileUtils.fileUpload(file);

			if (imageFile != null) {
				// DB에 저장
				ImageFile savedImageFile = imageFileRepository.save(imageFile);
				return savedImageFile;
			}
		}
		return null;
	}

	// favorite 작성
	@Override
	public FavoriteResponse insertFav(FavoriteRequest favDTO, MultipartFile file) {
		ImageFile savedImage = saveImage(file);
		if (savedImage != null) {
			// postDTO (postRequest)에 이미지 파일 추가
			favDTO.setImageFile(savedImage);
		}

		Favorite favorite = favDTO.toEntity();
		Favorite savedFavorite = favoriteRepository.save(favorite);
		return FavoriteResponse.toDTO(savedFavorite);
	}

	// favorite 전체 리스트
	@Override
	public List<FavoriteResponse> getAllFav() {
		List<Favorite> favoriteList = favoriteRepository.findAll();

		if (favoriteList.size() > 0) {
			// list 존재
			List<FavoriteResponse> list = favoriteList.stream().map(FavoriteResponse::toDTO).toList();
			return list;
		} else {
			// 없는 경우 빈 list return
			return new ArrayList<>();
		}
	}

	// favorite id로 찾기
	@Override
	public FavoriteResponse getFavoriteById(Long id) {
		Favorite favorite = favoriteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 북마크를 찾을 수 없음"));
		FavoriteResponse favoriteResponse = FavoriteResponse.toDTO(favorite);
		return favoriteResponse;
	}

	// favorite 삭제
	@Override
	public FavoriteResponse deleteFav(Long id) {
		Favorite favorite = favoriteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 북마크를 찾을 수 없음"));

		favoriteRepository.delete(favorite);
		return FavoriteResponse.toDTO(favorite);
	}

	// favorite 수정
	@Override
	public FavoriteResponse updateFav(FavoriteRequest favDTO, MultipartFile file) {
		Favorite favorite = favoriteRepository.findById(favDTO.getId())
				.orElseThrow(() -> new IllegalArgumentException("해당 북마크를 찾을 수 없음"));

		ImageFile savedImage = saveImage(file);
		if (savedImage != null) {
			// postDTO (postRequest)에 이미지 파일 추가
			favorite.setImage(savedImage);
		}

		if (favDTO.getTitle() != null) {
			favorite.setTitle(favDTO.getTitle());
		}

		if (favDTO.getUrl() != null) {
			favorite.setUrl(favDTO.getUrl());
		}

		Favorite updatedFavorite = favoriteRepository.save(favorite);
		FavoriteResponse result = FavoriteResponse.toDTO(updatedFavorite);

		return result;
	}
}
