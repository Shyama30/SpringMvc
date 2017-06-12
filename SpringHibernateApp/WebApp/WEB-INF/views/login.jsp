<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/login.css" rel="stylesheet">
<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<%
		if (request.getParameter("message") != null) {
			out.print(request.getParameter("message"));
		}
	%> 
	<div class="login-style">
		<h2 align="center">Login Form</h2>
		<form action="authentication.html" method="post" name="loginform">
			<table>
				<tr>
					<td><label>UserName</label></td>
					<td><input type="email" name="email" placeholder="enter your emailId"></td>
				<tr>
					<td><label>Password</label></td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td id="p3" colspan="2"><input type="submit" value="login">
                    <a class="button" href="registration.html">click new user</a>
					<a  class="button" href="logout.html">logout</a>
		
				</tr>
			</table>


		</form>
	</div>
</body>
</html>