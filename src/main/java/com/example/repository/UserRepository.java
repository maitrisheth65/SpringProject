package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.UserDao;
@Repository
public interface UserRepository extends JpaRepository<UserDao,Long>{
	UserDao  findByUsername(String username);
}
