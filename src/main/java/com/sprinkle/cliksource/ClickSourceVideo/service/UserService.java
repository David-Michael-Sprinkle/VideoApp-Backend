package com.sprinkle.cliksource.ClickSourceVideo.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.sprinkle.cliksource.ClickSourceVideo.entity.Link;
import com.sprinkle.cliksource.ClickSourceVideo.entity.User;

public interface UserService {
	
	  List<User> getAllUser(); 
	  
	  User getUserById(ObjectId id);
	 
	  User getUserByUserid(String userid);
	 
	  void modifyUserById(ObjectId id, User user); 

	  User addlink(String userid, Link link);
	  
	  User deletelink(String userid,String linkid);

	  User createUser(User user);

	  void deleteUser(ObjectId id);
}
