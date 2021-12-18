package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.UserDao;
import com.example.model.UserDto;
import com.example.repository.UserRepository;

@Service

public class JwtUserDetailService implements UserDetailsService{
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
	public UserDao save(UserDto user) {
		UserDao newUser = new UserDao();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(newUser);
	}

	   public Optional<UserDao> findById(long id) {
	        return userRepository.findById(id);
	    }
	   public List<UserDao>findAll(){
		   return userRepository.findAll();
	   }
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserDao user=userRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
	}
	   public UserDao updateContact(long id, UserDto userDto) {
	        UserDao updatedContact = userRepository.findById(id).orElse(null);
	        updatedContact.setUsername(userDto.getUsername());
	        updatedContact.setPassword(passwordEncoder.encode(userDto.getPassword()));
	     
	        return userRepository.save(updatedContact);
	    }
	
	
}

