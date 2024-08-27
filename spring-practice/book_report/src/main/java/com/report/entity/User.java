package com.report.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.report.domain.Role;
import com.report.domain.UserGrade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@RequiredArgsConstructor
@Data
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;

	@Column(name = "nickname", nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private UserGrade grade = UserGrade.EXPLORER; // user의 등급

	@Column(nullable = false)
	private Long point = 0L; // point의 초기값은 무조건 0

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role = Role.USER; // user의 역할 (USER, ADMIN)

	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Role을 기반으로 GrantedAuthority 리스트 생성
		List<GrantedAuthority> roleAuthorities = List.of(role).stream()
				.map(r -> new SimpleGrantedAuthority(r.getRole())).collect(Collectors.toList());

		// UserGrade를 기반으로 GrantedAuthority 리스트 생성
		List<GrantedAuthority> gradeAuthorities = List.of(grade).stream()
				.map(g -> new SimpleGrantedAuthority(g.getGrade())).collect(Collectors.toList());

		// Role과 UserGrade 권한 리스트를 합쳐서 반환
		return List.of(roleAuthorities, gradeAuthorities).stream().flatMap(Collection::stream)
				.collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	// 글 작성 시, 포인트 +5
	public void addPoints(long pointsToAdd) {
		this.point += pointsToAdd;
	}
}
