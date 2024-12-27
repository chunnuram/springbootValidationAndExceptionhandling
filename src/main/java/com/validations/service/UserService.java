package com.validations.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.validations.dto.request.UserDto;
import com.validations.dto.response.SuccessReponse;
import com.validations.entity.User;

@Service
public interface UserService {
	public SuccessReponse saveUser(UserDto userdto);
	public List<User> getUserList();
	public User getUser(Long id);
	public void deleteUser(Long id);
}
