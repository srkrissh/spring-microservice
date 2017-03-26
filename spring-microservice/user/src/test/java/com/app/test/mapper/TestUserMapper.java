package com.app.test.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.app.dto.User;
import com.app.entity.UserEntity;
import com.app.mapper.UserMapper;
import com.app.util.UserObjectFactory;

/**
 * Tests user mapper
 * 
 * @author Seetharama Krishna
 *
 */
public class TestUserMapper {
	
	private UserObjectFactory factory;
	private UserMapper mapper;
	
	@Before
	public void setUp() {
		factory = new UserObjectFactory();
		mapper = new UserMapper();
	}
	
	@Test
	public void testMapDtoToEntity() {
		User savedUser = factory.createSavedUser();
		UserEntity entity = mapper.mapDtoToEntity(savedUser);
		assertEquals(entity.getId(), savedUser.getId());
		assertEquals(entity.getUserName(), savedUser.getUserName());
	}
	
	@Test
	public void testMapEntityToDTO() {
		UserEntity savedUserEntity = factory.createSavedUserEntity();
		User user = mapper.mapEntityToDto(savedUserEntity);
		assertEquals(user.getId(), savedUserEntity.getId());
		assertEquals(user.getUserName(), savedUserEntity.getUserName());
	}
	

}
