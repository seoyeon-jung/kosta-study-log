package com.report.domain;

public enum Role {
	USER("ROLE_USER"), ADMIN("ROLE_ADMIN");

	String role;

	Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}