package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public UserDao(String string, String string2) {
		// TODO Auto-generated constructor stub
    	this.username=string;
    	this.password=string2;
	}
    public UserDao() {
    	
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column
    private String username;
    @Column
    @JsonIgnore
    private String password;

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
}
