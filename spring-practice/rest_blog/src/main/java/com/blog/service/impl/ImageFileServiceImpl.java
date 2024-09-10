package com.blog.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog.domain.FileDTO;
import com.blog.entity.ImageFile;
import com.blog.repository.ImageFileRepository;
import com.blog.service.ImageFileService;
import com.blog.util.FileUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageFileServiceImpl implements ImageFileService {
	private final ImageFileRepository imageFileRepoistory;
	private final FileUtils fileUtils;
	private final ImageFileRepository imageFileRepository;

	// 이미지 저장 메소드 (중복되므로 메소드 생성)
	@Override
	public ImageFile saveImage(MultipartFile file) {
		if (file != null) {
			// 이미지 파일 가져오기
			ImageFile imageFile = fileUtils.fileUpload(file);

			if (imageFile != null) {
				// DB에 저장
				ImageFile savedImageFile = imageFileRepoistory.save(imageFile);
				return savedImageFile;
			}
		}
		return null;
	}

	@Override
	public FileDTO getImageById(Long id) {
		ImageFile image = imageFileRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 id에 맞는 파일 없음"));
		return FileDTO.toDTO(image);
	}

}
