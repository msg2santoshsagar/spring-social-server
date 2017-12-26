package com.sagar.springsocialserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class FacebookUser {
	
	private String id;
	private String email;
	
	@JsonProperty(value="first_name")
	private String firstName;
	
	@JsonProperty(value="last_name")
	private String lastName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "FacebookUser [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
	
	

}
