package com.sagar.springsocialserver.domain.model;

public class ApplicationInfo {
	
	private String name;
	private String version;
	private String upTime;
	
	public String getName() {
		return name;
	}
	public ApplicationInfo setName(String name) {
		this.name = name;
		return this;
	}
	public String getVersion() {
		return version;
	}
	public ApplicationInfo setVersion(String version) {
		this.version = version;
		return this;
	}
	public String getUpTime() {
		return upTime;
	}
	public ApplicationInfo setUpTime(String upTime) {
		this.upTime = upTime;
		return this;
	}
	
	@Override
	public String toString() {
		return "ApplicationInfo [name=" + name + ", version=" + version + ", upTime=" + upTime + "]";
	}
	

}
