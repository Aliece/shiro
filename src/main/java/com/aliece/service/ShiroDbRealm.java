package com.aliece.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.aliece.entity.Role;
import com.aliece.entity.User;

@Named
public class ShiroDbRealm extends AuthorizingRealm{

	@Inject
	private UserService userService;

	/**
	 * Ȩ����֤����
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String loginName = (String) principalCollection.fromRealm(getName()).iterator().next();
		User user = userService.findByUsername(loginName);
		if(user != null){
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.setRoles(user.getRoleNames());
			
			List<Role> roleList = user.getRoleList();
			for (Role role : roleList) {
				info.addStringPermissions(role.getPermissions());
			}
			
			return info;
		}
		return null;
		
	}

	/**
	 * ��¼��֤����
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		User user = userService.findByUsername(token.getUsername());
		if(user != null){
			return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
		}
		return null;
	}
	
	
}
