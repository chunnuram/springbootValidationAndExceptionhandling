package com.validations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.validations.dto.request.UserDto;
import com.validations.dto.response.SuccessReponse;
import com.validations.entity.User;
import com.validations.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class MyController {

	@Autowired
	private UserService userservice;
	
	@PostMapping("/save")
	public ResponseEntity<SuccessReponse> save(@RequestBody @Valid UserDto userdto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userservice.saveUser(userdto));
	}
	@GetMapping("/getuser")
	public ResponseEntity<List<User>> get() {
		return ResponseEntity.status(HttpStatus.CREATED).body(userservice.getUserList());
	}
	@GetMapping("/getuser/{id}")
	public ResponseEntity<User> get(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userservice.getUser(id));
	}
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		userservice.deleteUser(id);
		return ResponseEntity.status(HttpStatus.CREATED).body("user deleted successfully !");
	}
}
