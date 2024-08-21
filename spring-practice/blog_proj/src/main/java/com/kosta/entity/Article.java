package com.kosta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
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

	@Builder()
	public Article(int id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

}
