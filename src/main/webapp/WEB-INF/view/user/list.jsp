<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>login page</title>
  </head>
  
  <body>
  <shiro:hasPermission name="user:add">
  	<h2><a href="/user/add">添加用户</a></h2>
  </shiro:hasPermission>
  	<h2><a href="/logout">安全退出</a></h2>
   	<table>
   		<thead>
   			<tr>
   				<th>id</th>
   				<th>username</th>
   				<th>password</th>
   				<th>/</th>
   			</tr>
   		</thead>
   		<tbody>
   			<c:forEach items="${userList }" var="user">
	   			<tr>
	   				<td>
	   					${user.id }
	   				</td>
	   				<td>
	   					${user.username }
	   				</td>
	   				<td>
	   					${user.password }
	   				</td>
	   				<td>
	   					<shiro:hasPermission name="user:edit">
	   						<a href="/user/edit/${user.id }">编辑</a>
	   					</shiro:hasPermission>
	   					<shiro:hasPermission name="user:delete">
	   						<a href="/user/delete/${user.id }">删除</a>
	   					</shiro:hasPermission>
	   				</td>
	   			</tr>
   			</c:forEach>
   		</tbody>
   	</table>
  </body>
</html>
