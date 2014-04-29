<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>edit page</title>
  </head>
  
  <body>
  	<form action="/user/update" method="post">
	   	<table>
			<tr>
				<td>
					<input name="id" type="hidden" value="${user.id }"/>
				</td>
				<td>
					<input name="username" value="${user.username }"/>
				</td>
				<td>
					<input name="password" value="${user.password }"/>
				</td>
				<td>
					<button value="修改">修改</button>
				</td>
			</tr>
	   	</table>
  	</form>
  </body>
</html>
