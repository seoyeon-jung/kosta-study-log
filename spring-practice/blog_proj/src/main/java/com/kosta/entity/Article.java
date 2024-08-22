package com.kosta.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
// hibernate가 DB에 어떤 행위를 하는 시점이나 그 이후 등 호출될 수 있는 콜백함수를 제공
// DB에 엔티티를 저장하기 전에 특정 행위를 할 수 있게 해준다.
@EntityListeners(AuditingEntityListener.class)
@RequiredArgsConstructor
@Data
public class Article {
	@Id // 기본키 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 증가
	@Column(name = "id", updatable = false) // update 시에 id 컬럼은 제외한다
	private long id;

	@Column(name = "title", nullable = false) // not null
	private String title;

	@Column(name = "content", nullable = false)
	private String content;

	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Builder()
	public Article(int id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

}
