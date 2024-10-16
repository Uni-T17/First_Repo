package com.kit.kat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.kit.kat.model.User;
import com.kit.kat.model.UserController;
import com.kit.kat.model.UserRepository;

@SpringBootTest
class KitKat3ApplicationTests {

	@Autowired
	private UserController userController;

	@Autowired
	private UserRepository repository;

	@Test
	void contextLoads() {

	}

	@ParameterizedTest
	@CsvSource({ "aike,20,aikepaung767@gmail.com", "kit,20,kit@gmail.com" })
	void TestData(String name, int age, String email) {

		User user1 = new User();
		user1.setName(name);
		user1.setAge(age);
		user1.setEmail(email);

		userController.userRegister(user1);
		User retrievedUser = repository.findByName(name);

		assertEquals(user1, retrievedUser);
	}

}
