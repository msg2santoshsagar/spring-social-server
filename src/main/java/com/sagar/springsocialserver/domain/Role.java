package com.sagar.springsocialserver.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Enumerated(EnumType.STRING)
	private RoleType name;

	public RoleType getName() {
		return name;
	}

	public Role setName(RoleType name) {
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return "Role [name=" + name + "]";
	}
	

}