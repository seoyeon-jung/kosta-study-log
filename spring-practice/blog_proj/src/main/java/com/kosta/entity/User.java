package com.kosta.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
@EntityListeners(AuditingEntityListener.class)
@RequiredArgsConstructor
@Data
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Builder // 빌터 패턴으로 객체 생성
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	// 사용자가 가질 수 있는 권한 목록 반환
	// '사용자' 권한만 있기 때문에 '사용자' 권한만 부여
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("user"));
	}

	// 사용자 식별값 반환
	// 사용자의 식별 가능한 이름 = email
	@Override
	public String getUsername() {
		return email;
	}

	// 계정 만료 여부
	// true : 만료 아님 | false : 만료
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정 잠금 여부
	// true : 열림 | false : 잠김
	@Override
	public boolean isAccountNonLocked() {
		return UserDetails.super.isAccountNonLocked();
	}

	// 비밀번호 만료 여부
	// true: 만료되지 않음 | false : 만료
	@Override
	public boolean isCredentialsNonExpired() {
		return UserDetails.super.isCredentialsNonExpired();
	}

	// 계정 사용 가능 여부
	@Override
	public boolean isEnabled() {
		return UserDetails.super.isEnabled();
	}

}
