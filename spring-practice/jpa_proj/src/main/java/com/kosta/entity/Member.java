package com.kosta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "member_tbl") // 테이블명 지정 (JPA entity임을 명시)
@NoArgsConstructor
@Data
public class Member {
	@Id // 기본키
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동 증가 (=auto_increment)
	private int id;

	@Column(nullable = false) // not null과 같은 의미
	private String name;
}
