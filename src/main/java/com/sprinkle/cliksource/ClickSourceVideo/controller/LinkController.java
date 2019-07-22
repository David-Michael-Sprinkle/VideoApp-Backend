package com.sprinkle.cliksource.ClickSourceVideo.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sprinkle.cliksource.ClickSourceVideo.entity.Link;
import com.sprinkle.cliksource.ClickSourceVideo.entity.User;
import com.sprinkle.cliksource.ClickSourceVideo.service.UserService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(value="*")
@RestController
@RequestMapping("/api/user")
public class LinkController {
	
	private UserService service;
	 
    @Autowired
    LinkController(UserService service) {
        this.service = service;
    }
  
 //Video Specific Services
 //READ USER From USERID
 @RequestMapping(value = "/{userid}", method = RequestMethod.GET)
 public User getUserByUserid(@PathVariable("userid") String userid) {
   return service.getUserByUserid(userid);
 }
  
  //Add Link to User JSON links ARRAY
  @RequestMapping(value = "/{userid}/addlink", method = RequestMethod.POST)
  public User Addlink(@PathVariable("userid") String userid, @RequestBody Link link) {
	return service.addlink(userid, link);
  }
  
  //Delete Link to USER JSON links ARRAY
  @RequestMapping(value = "/{userid}/deletelink/{linkid}", method = RequestMethod.PUT)
  public User Deletelink(@PathVariable("userid") String userid,@PathVariable("linkid") String linkid) {
	return service.deletelink(userid, linkid);
  }
  
  //Standard Crud User For Testing
  // READ ALL 
  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<User> getAllUser() {
    return service.getAllUser();
  }
  
  // READ USER from MONGOID
  @RequestMapping(value = "/mongo/{id}", method = RequestMethod.GET)
  public User getUserById(@PathVariable("id") ObjectId id) {
    return service.getUserById(id);
  }
  //UPDATE from MONGOID
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void modifyUserById(@PathVariable("id") ObjectId id, @Valid 
  @RequestBody User user) {
	service.modifyUserById(id, user);
  }
  
  //CREATE / ADD 
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public User createUser(@Valid @RequestBody User user) {
    return service.createUser(user);
  }
  
  
  //DELETE
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteUser(@PathVariable ObjectId id) {
    service.deleteUser(id);
  }

}