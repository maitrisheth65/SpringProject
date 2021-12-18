package com.example.model;

import java.io.Serializable;

public class JwtResponse implements Serializable{
	/**
	 * 
	 */
	private String jwttoken;
	private static final long serialVersionUID = 6335479185245880714L;

	public JwtResponse(String token) {
		this.jwttoken=token;
	}
	public String getToken() {
		return this.jwttoken;
	}
}
