package com.validations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.validations.dto.request.UserDto;
import com.validations.dto.response.SuccessReponse;
import com.validations.entity.User;
import com.validations.exception.UserNotFoundExceptions;
import com.validations.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userrepo;
	
	private ObjectMapper mapper;
	
	@Override
	public SuccessReponse saveUser(UserDto userDTO) {
		// TODO Auto-generated method stub
		 User user=new User();
		 user.setName(userDTO.getName());
		 user.setEmail(userDTO.getEmail());
		 user.setMobileNo(userDTO.getMobileNo());
		 user.setAge(userDTO.getAge());
		 user.setNationality(userDTO.getNationality());
		 user.setGender(userDTO.getGender());
		 User saveuser= userrepo.save(user);
		 SuccessReponse successReponse=new SuccessReponse();
		 successReponse.setMessage("Data save sucessfully !");
		 successReponse.setStatus(HttpStatus.CREATED);
		 successReponse.setData(saveuser);
		 return successReponse;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		if(!userrepo.existsById(id)) {
			
			throw new UserNotFoundExceptions("user does not exists "+id);
		}
		return userrepo.findById(id).get();
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userrepo.deleteById(id);
	}

	
}
