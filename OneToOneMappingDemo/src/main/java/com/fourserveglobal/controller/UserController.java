package com.fourserveglobal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fourserveglobal.entity.User;
import com.fourserveglobal.entity.UserProfile;
import com.fourserveglobal.exception.ErrorDetails;
import com.fourserveglobal.repository.UserRepository;
import com.fourserveglobal.service.UserService;


@RestController
public class UserController {
	    
	    @Autowired
	    private UserService userService;
	   
	   

		public UserController(UserService userService) {
		super();
		this.userService = userService;
	    }
     
	    //for saving
	    @PostMapping("/user")
		public User save(@RequestBody User user, UserProfile userProfile) {
	    	return userService.saveUser(user, userProfile);
	    }
	    
        // for fetching
	    @GetMapping("/a")
	    public List<User> getAll() {
	    	return userService.getAllUser();
	    }
         
	    // for fetching by id
	    @GetMapping("{id}")
	    public ResponseEntity<User> getUserById( @PathVariable("id") int id)
	    {
	    	
	    	boolean isEmployeeExist=userService.isUserExist(id);
	    	if(isEmployeeExist) {
	    	return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	    	}
	    	else {
	    	throw new ErrorDetails("User is not available  : "+id);
	    	}
	    }
	    
	    
	   
	     //for update
		 @PutMapping("{id}") 
		  public ResponseEntity<User> updateUser(@PathVariable("id") int id,@RequestBody User user) { boolean
		  isUserExist=userService.isUserExist(id); 
		  if(isUserExist) { 
			  return new ResponseEntity<>(userService.updateUser(user,id), HttpStatus.CREATED); }
		  else {
		    throw new ErrorDetails("Student is not available : "+id); 
		  }
		  }
		 
	    
	    //for Delete
	    @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
	    	//delete employee from DB
	    	boolean isUserExist=userService.isUserExist(id);
	    	if(isUserExist) {
	    	userService.deleteUser(id);
	    	return new ResponseEntity<String>("Student Deleted successfully ", HttpStatus.OK);
	    	}else
	    	{
	    		throw new ErrorDetails("Student is not available : "+id);
	    	}
	    	
	    }
	   
}
