package com.example.springboot;

import com.example.springboot.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // loads the entire spring application context, including all the beans and configurations.
@Import(TestSecurityConfig.class)
class SpringbootFundamentalsApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void createUser() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<>("""
				{
				  "name": "John Doe",
				  "age": 25
				}
			""", headers);
		ResponseEntity<UserDto> response = restTemplate
				.withBasicAuth("user", "password")
				.postForEntity("/users/create", request, UserDto.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals("John Doe", response.getBody().getName());
		assertEquals(25, response.getBody().getAge());
	}

	@Test
	void contextLoads() {
	}

}
