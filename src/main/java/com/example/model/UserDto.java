package com.example.model;

public class UserDto {
	private String username;
	private String password;
	private String jwttoken;
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getJwttoken() {
		return jwttoken;
	}
	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDto() {
		
	}
	public UserDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	//	this.id = id;
	}

}
