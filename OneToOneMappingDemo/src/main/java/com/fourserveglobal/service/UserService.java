package com.fourserveglobal.service;

import java.util.List;

import com.fourserveglobal.entity.User;
import com.fourserveglobal.entity.UserProfile;

public interface UserService {
    public User saveUser(User user, UserProfile userProfile);
    public List<User> getAllUser();
    public User getUserById(int id);
   
    public User updateUser(User user, int id);
   
	public void deleteUser(int id);
    public boolean isUserExist(int id);
     
  
}
