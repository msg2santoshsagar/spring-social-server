package com.sagar.springsocialserver.domain;

import java.util.HashSet;
import java.util.Set;

public class MaskedUser {

	private String userName;
	private Set<Role> role = new HashSet<>();
	private String name;
	private String email;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MaskedUser [userName=" + userName + ", role=" + role + ", name=" + name + ", email=" + email + "]";
	}
	
}