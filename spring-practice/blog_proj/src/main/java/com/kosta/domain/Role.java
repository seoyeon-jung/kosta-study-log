package com.kosta.domain;

public enum Role {
	ROLE_USER("ROLE_USER"), ROLE_ADMIN("ROLE_ADMIN");

	String role;

	Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
