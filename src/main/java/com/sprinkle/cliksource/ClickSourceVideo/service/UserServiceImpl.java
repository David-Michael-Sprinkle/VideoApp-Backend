package com.sprinkle.cliksource.ClickSourceVideo.service;

import java.util.List;
import java.util.stream.IntStream;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprinkle.cliksource.ClickSourceVideo.entity.Link;
import com.sprinkle.cliksource.ClickSourceVideo.entity.User;
import com.sprinkle.cliksource.ClickSourceVideo.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository repository;

	@Autowired
	UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<User> getAllUser() {
		return repository.findAll();
	}

	@Override
	public User getUserById(ObjectId id) {
		return repository.findById(id);
	}

	@Override
	public User getUserByUserid(String userid) {
		return repository.findByuserid(userid);
	}

	@Override
	public void modifyUserById(ObjectId id, User user) {
		user.setId(id);
		repository.save(user);

	}

	@Override
	public User addlink(String userid, Link link) {
		User user = repository.findByuserid(userid);
		user.addLink(link);
		repository.save(user);
		return user;
	}
	

	//find link by id then delete the index 
	@Override
	public User deletelink(String userid, String linkid) {
		User user = repository.findByuserid(userid);
		int index = user.findIndexByLinkid(linkid);
		user.deleteLink(index);
		repository.save(user);
		return user;
	}

	@Override
	public User createUser(User user) {
		user.setId(ObjectId.get());
		repository.save(user);
		return user;
	}

	@Override
	public void deleteUser(ObjectId id) {
		repository.delete(repository.findById(id));

	}

}