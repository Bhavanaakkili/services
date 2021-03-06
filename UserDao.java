package com.vp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.vp.model.User;

@Component
public class UserDao {
	static List<User> list =null;
	static {		
		list = new ArrayList<User>(); 
		list.add(new User(1, "bhavana", "reddy"));
		list.add(new User(2, "bindu", "reddy"));
		list.add(new User(3, "Saiii", "akkili"));
		list.add(new User(4, "fio", "Raj"));
	}
	public List<User> getUsers(){		
		
		return UserDao.list;
	}	
	public ResponseEntity<?> insertUser(User user){
		list.add(user);		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	public ResponseEntity<?> getUser(int id){
		for (User user : list) {
			if(user.getUid() == id) {
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}
		}
		return null;
	}
	public int deleteUser(int id){
		for (User user : list) {
			if(user.getUid() == id) {
				list.remove(user);
				return id;
			}
		}
		return 0;
	}
}
