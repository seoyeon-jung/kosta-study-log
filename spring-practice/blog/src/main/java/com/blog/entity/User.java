package com.blog.entity;

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

	// getAuthorities() : 권한들을 가져오자!
	// 사용자들이 가질 수 있는 권한 목록을 반환한다.
	// 여기서는 "사용자"라는 권한만 부여할 것임.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("user"));
	}

	// getUsername() : 사용자 식별값 가져오자!
	// 여기서는 사용자의 식별 가능한 이름은 email이다.
	@Override
	public String getUsername() {
		return email;
	}

	// isAccountNonExpired() : 계정 만료 여부
	// true: 만료 아님 | false: 만료
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// isAccountNonLocked() : 계정 잠금 여부
	// true: 잠기지 않음(열림) | false: 잠김
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// isCredentialsNonExpired() : 비밀번호 만료 여부
	// true: 만료 아님 | false: 만료
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// isEnabled() : 계정 활성화(만료) 여부
	// true: 만료 아님 | false: 만료
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Builder
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
}