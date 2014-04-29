<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>add page</title>
  </head>
  
  <body>
  	<form action="/user/save" method="post">
	   	<table>
			<tr>
				<td>
					<input name="username" value="${user.username }"/>
				</td>
				<td>
					<input name="password" value="${user.password }"/>
				</td>
				<td>
					<button value="修改">添加</button>
				</td>
			</tr>
	   	</table>
  	</form>
  </body>
</html>
