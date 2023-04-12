package com.batch.test.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.batch.test.model.User;

@Service
public class UserService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public User createUser(User user) {

		return mongoTemplate.save(user);
	}

	public Collection<User> createUsers(List<User> users) {

		return mongoTemplate.insertAll(users);
	}

	public List<User> getAll() {

		return mongoTemplate.findAll(User.class);
	}

	public User getUserById(String id) {

		return mongoTemplate.findById(id, User.class);
	}

	public void deleteAllUsers() {
		mongoTemplate.dropCollection(User.class);
	}
}
