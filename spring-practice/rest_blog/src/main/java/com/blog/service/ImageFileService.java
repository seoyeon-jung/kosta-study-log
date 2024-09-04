package com.blog.service;

import org.springframework.web.multipart.MultipartFile;

import com.blog.domain.FileDTO;
import com.blog.entity.ImageFile;

public interface ImageFileService {
	ImageFile saveImage(MultipartFile file);

	FileDTO getImageById(Long id);
}
