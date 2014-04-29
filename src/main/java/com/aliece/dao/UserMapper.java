package com.aliece.dao;

import java.util.List;

import com.aliece.entity.User;

public interface UserMapper {

	public User findById(int id);
	public void save(User user);
	public void del(int id);
	public void edit(User user);
	public User findByUsername(String username);
	public List<User> findAll();
}
