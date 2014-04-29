package com.aliece.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

	private int id;
	private String username;
	private String password;
	private List<Role> roleList;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * @return ��ɫ����
	 */
	public Set<String> getRoleNames() {
		Set<String> set = new HashSet<String>();
		for (Role role : roleList) {
			set.add(role.getRolename());
		}
		return set;
	}
	
	
	
}
