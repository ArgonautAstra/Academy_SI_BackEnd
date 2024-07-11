package it.corso.service;

import java.util.List;

import it.corso.dto.UserDto;
import it.corso.dto.UserLoginRequestDto;
import it.corso.dto.UserSignupDto;
import it.corso.dto.UserUpdateDto;
import it.corso.model.User;

public interface UserService {

	void userSignup(UserSignupDto userdDto);

	void userUpdate(UserUpdateDto userUpdateDto);

	void userDelete(String email);

	User getUserByEmail(String email);

	UserDto getUserDtoByEmail(String email);

	List<UserDto> getAllUser();

	boolean existsUserByEmail(String email);
	
	boolean login(UserLoginRequestDto userLoginRequestDto);

	void addCourse(int userId, int courseId);

	void deleteCourse(int userId, int courseId);

}