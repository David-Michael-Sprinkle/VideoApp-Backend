package com.sprinkle.cliksource.ClickSourceVideo.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.sprinkle.cliksource.ClickSourceVideo.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findById(ObjectId id);
	User findByuserid(String userid);
	

}