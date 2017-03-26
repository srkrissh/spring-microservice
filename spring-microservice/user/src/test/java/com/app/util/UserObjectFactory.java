package com.app.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.dto.User;
import com.app.entity.UserEntity;

public class UserObjectFactory {
	
	/**
	 * Create {@link List} of {@link UserEntity}
	 * @return {@link List}
	 */
	public List<UserEntity> createUserEntityList() {
		List<UserEntity> users = new ArrayList<>();
		users.add(createSavedUserEntity());
		users.add(createSavedUserEntity());
		return users;
	}
	
	/**
	 * Create {@link List} of {@link User}
	 * @return {@link List}
	 */
	public List<User> createUserList() {
		List<User> users = new ArrayList<>();
		users.add(createSavedUser());
		users.add(createSavedUser());
		return users;
	}
	
	/**
	 * Create new user entity without id and version
	 * 
	 * @return
	 */
	public UserEntity createNewUserEntity() {
		User newUser = createNewUser();
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(newUser.getUserName());
		userEntity.setPassword(newUser.getPassword());
		return userEntity;
	}
	
	/**
	 * Create data object for new user
	 * 
	 * @return
	 */
	public User createNewUser() {
		User newUser = new User();
		newUser.setUserName("testuser");
		newUser.setPassword("pass1234");
		return newUser;
	}
	/**
	 * Create user object as a saved user along with <tt>id</tt> and <tt>version</tt>
	 * 
	 * @return {@link User} object
	 */
	public User createSavedUser() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User newUser = createNewUser();
		User savedUser = new User();
		savedUser.setId(1L);
		savedUser.setVersion(0L);
		savedUser.setUserName(newUser.getUserName());
		savedUser.setPassword(encoder.encode(newUser.getPassword()));
		return savedUser;
	}
	
	/**
	 * Create {@link UserEntity} 
	 * 
	 * @return {@link UserEntity}
	 */
	public UserEntity createSavedUserEntity() {
		User newUser = createNewUser();
		UserEntity savedUserEntity = new UserEntity();
		savedUserEntity.setId(1L);
		savedUserEntity.setVersion(0L);
		savedUserEntity.setUserName(newUser.getUserName());
		savedUserEntity.setPassword(newUser.getPassword());
		return savedUserEntity;
	}

}
