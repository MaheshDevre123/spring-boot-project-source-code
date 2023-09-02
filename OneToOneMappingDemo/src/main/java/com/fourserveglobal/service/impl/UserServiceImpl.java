package com.fourserveglobal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourserveglobal.entity.User;
import com.fourserveglobal.entity.UserProfile;
import com.fourserveglobal.exception.ErrorDetails;
import com.fourserveglobal.repository.UserProfileRepository;
//import com.fourserveglobal.repository.UserProfileRepository;
import com.fourserveglobal.repository.UserRepository;
import com.fourserveglobal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public User saveUser(User user, UserProfile userProfile) {

		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).orElseThrow(() -> new ErrorDetails());

	}

	@Override
	public boolean isUserExist(int id) {

		return userRepository.existsById(id);
	}

	
	  @Override 
	 public User updateUser(User user,  int id) { 
	     User existingUser = userRepository.findById(id).orElseThrow();
	  
		  UserProfile userProfile=new UserProfile();
		  existingUser.setName(user.getName());
	      existingUser.setEmail(user.getEmail());
	  
	  UserProfile existingUserProfile =userProfileRepository.findById(id).orElseThrow( ()->
	        new ErrorDetails());
	  existingUserProfile.setPhonenumber(user.getUserProfile().getPhonenumber());
	  
	  existingUserProfile.setAddress(user.getUserProfile().getAddress());
	  existingUser.setUserProfile(existingUserProfile);
	return  userRepository.save(existingUser);
	  //userProfileRepository.save(existingUserProfile); return existingUser ; 
	  
	  }
	  
	
	 

	@Override
	public void deleteUser(int id) {
		userRepository.findById(id).orElseThrow(() -> new ErrorDetails());
		userRepository.deleteById(id);

	}

	

}
