
package com.viswa.springsecdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.viswa.springsecdemo.model.Customer;
import com.viswa.springsecdemo.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Controller

@RequiredArgsConstructor
public class UserController {

	private final PasswordEncoder passwordEncoder;
	private final CustomerRepository customerRepository;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
		try {
			String hashPwd = passwordEncoder.encode(customer.getPassword());
			customer.setPassword(hashPwd);
			Customer savedCustomer = customerRepository.save(customer);

			if (savedCustomer.getId() > 0) {
				return ResponseEntity.status(HttpStatus.CREATED).body("User Registration Succesful");
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Registration Failed");
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An Error Occured:" + e.getMessage());
		}
	}
}
