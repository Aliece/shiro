package com.aliece.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Role {

	private int id;
	private String rolename;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Collection<String> getPermissions() {
		List<String> list = new ArrayList<String>();
		list.add("user:add");
		list.add("user:edit");
		return list;
	}
	
	
}
