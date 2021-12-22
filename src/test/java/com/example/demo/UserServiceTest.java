package com.example.demo;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;



import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.model.UserDao;
import com.example.model.UserDto;
import com.example.repository.UserRepository;
import com.example.service.JwtUserDetailService;

@SpringBootTest
public class UserServiceTest {
	@Autowired
	private JwtUserDetailService jwtUserDetailService;
	@Mock
	private UserRepository userRepository;

	@Test
	public void addUserTest() {
	UserDao user = new UserDao("test","test");
	UserDto user1 = new UserDto("test","test");
	when(userRepository.save(user)).thenReturn(user);
	if(jwtUserDetailService.save(user1)!=0) {
		
	}
	else {
		Assertions.fail("failed");
	}
	}
	
	@Test
	public void updateUserTest() {
		UserDto userDto=new UserDto();
		userDto.setUsername("ami");
		userDto.setPassword("ami");
		UserDao user=jwtUserDetailService.updateContact(50,userDto);
		if(user.getUsername().equals(userDto.getUsername())) {
			
		}
		else {
			Assertions.fail("failed");
		}
	}
	@Test
	public void deleteUserTest() {
	int id=58;
  jwtUserDetailService.deleteById(id);
	if(userRepository.findById((long) id).isEmpty()) {
		
	}
	else {
		Assertions.fail("failed");
		}
	}
}
