package com.aliece.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.aliece.dao.UserMapper;
import com.aliece.entity.User;

@Named
@Transactional
public class UserService {
	
	@Inject
	private UserMapper userMapper;

	public User login(String username, String password) {
		User user = userMapper.findByUsername(username);
		if(user != null && user.getPassword() != null && user.getPassword().equals(password)){
			return user;
		}
		return null;
	}

	public List<User> findAll() {
		
		return userMapper.findAll();
	}

	public User findById(int id) {
		return userMapper.findById(id);
	}

	public void update(User user) {
		userMapper.edit(user);
	}

	public void delete(int id) {
		userMapper.del(id);
	}

	public void add(User user) {
		userMapper.save(user);
	}

	public User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}

}
