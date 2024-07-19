package com.object;

public class Member {
	public String id;

	public Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member target = (Member) obj;
			if (id.equals(target.id)) {
				return true;
			}
		}
		return false;
	}
}
