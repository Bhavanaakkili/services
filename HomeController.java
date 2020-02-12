package com.vp.controll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vp.dao1.StudentDao;
import com.vp.model1.Student;

@RestController
public class HomeController {
	
	@Autowired
	StudentDao dao;
   
	@RequestMapping("/homedata")
	public ResponseEntity<Student> getHomeData() {
		
		return new ResponseEntity<Student>(new Student(11,"Giri", "Add1111"), HttpStatus.OK);
			
	}
	
	@GetMapping("/getAllUsers")
	public List<Student> getUsers(){
				
		return dao.getUsers();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Student> getUser(@PathVariable("id") int id) {
		return dao.getUser(id);
	}
	
	@PostMapping("/user")
	public ResponseEntity<Student> saveUser(@RequestBody Student user) {
		return dao.insertUser(user);
	}
	
	@DeleteMapping("user/{id}")
	public int deleteUser(@PathVariable("id") int id) {
		return dao.deleteUser(id);
	}
}
