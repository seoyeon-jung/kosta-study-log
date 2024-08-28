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

	public static Role fromRoleString(String roleString) {
		for (Role role : values()) {
			if (role.getRole().equals(roleString)) {
				return role;
			}
		}
		throw new IllegalArgumentException("해당 role이 존재하지 않습니다");
	}
}