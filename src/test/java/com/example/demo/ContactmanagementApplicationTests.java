package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.model.UserDao;
import com.example.model.UserDto;
import com.example.repository.UserRepository;
import com.example.service.JwtUserDetailService;

@SpringBootTest
class ContactmanagementApplicationTests {
	@MockBean
	private UserRepository userRepository;
	@InjectMocks
	private JwtUserDetailService service;
	@Autowired
	PasswordEncoder passwordEncoder;
	
//	@Test
//	void contextLoads() {
//	}
//	@Test
//	public void testData() {
//		double a=27;
//		assertEquals(a, Math.pow(3, 3));
//	}
	//@Test
//	public void createUserTest() {
//		UserDto userDto=new UserDto("maitri","maitri");
//		service.save(userDto);
//		Assertions.assertThat(UserDao.g	etId()).isGreaterThan(0);
//	}
}
