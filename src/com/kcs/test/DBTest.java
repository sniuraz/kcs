package com.kcs.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.kcs.database.User;
import com.kcs.database.UserDao;

public class DBTest {

//	@Test
//	public void testSearchingSingleUserById() {
//		
//		User user = new User(1, "Jonas", "Jonaitis", "jonas@jonas.lt", "Jonu g. 123", "123456", "jonas", "jonas");
//		UserDao dao = new UserDao();
//		dao.deleteUser(1);
//		dao.addUser(user);
//		
//		User user2 = dao.getUserById(1);
//		
//		assertUserEqual(user, user2);
//	
//	}
//	
	private void assertUserEqual(User user, User user2) {
		
		assertEquals(user.getId(), user2.getId());
		assertEquals(user.getFirstName(), user2.getFirstName());
		assertEquals(user.getLastName(), user2.getLastName());
		assertEquals(user.getEmail(), user2.getEmail());
		assertEquals(user.getAddress(), user2.getAddress());
		assertEquals(user.getPhone(), user2.getPhone());
		assertEquals(user.getUname(), user2.getUname());
		assertEquals(user.getPass(), user2.getPass());
	}
	
	@Test
	public void testSearchingSingleUserByName(){
		
		User user = new User(1, "Jonas", "Jonaitis", "jonas@jonas.lt", "Jonu g. 123", "123456", "jonas", "jonas");
		UserDao dao = new UserDao();
		dao.addUser(user);
		
		List<User> user2 = dao.getUsersByName("Jonas");
		assertUserEqual(user, user2.get(0));
		assertEquals(1, user2.size());
		
		
		
	}

}