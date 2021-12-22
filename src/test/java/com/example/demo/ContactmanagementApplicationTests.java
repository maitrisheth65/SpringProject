package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.UserDao;
import com.example.model.UserDto;
import com.example.repository.UserRepository;

//@RunWith(SpringRunner.class)

@SpringBootTest
public class ContactmanagementApplicationTests {
	@Autowired
	private UserRepository userRepository;

	@Test
	public void saveTest() {
		UserDao userDao = new UserDao();
		userDao.setUsername("sheth");
		userDao.setPassword("sheth");
		userRepository.save(userDao);
		Assertions.assertThat(userDao.getId()).isGreaterThan(0);
	}
	@Test
	public void getUserTest() {
	UserDao user = userRepository.findById((long) 50).get();
	Assertions.assertThat(user.getId()).isEqualTo(50);
	}
	@Test
	public void getListOfUsersTest() {
	List<UserDao> users = userRepository.findAll();
	Assertions.assertThat(users.size()).isGreaterThan(0);
	}

	@Test
	public void updateUserTest() {
	
	

	
	  UserDao updatedContact = userRepository.findById((long) 50).orElse(null);
		  updatedContact.setUsername("amishah");
	  updatedContact.setPassword("amishah");
	  
	Assertions.assertThat(userRepository.save(updatedContact).getUsername()).isEqualTo("amishah");



	}

	@Test
	public void deleteUserTest() {
	


	

	userRepository.deleteById((long) 51);



	
	UserDao user1 = null;
	Optional<UserDao> optionalUser = Optional.ofNullable(userRepository.findByUsername("ami10"));
	if (optionalUser.isPresent()) {
	user1 = optionalUser.get();
	Assertions.assertThat(user1).isNull();
	}



	}



}
