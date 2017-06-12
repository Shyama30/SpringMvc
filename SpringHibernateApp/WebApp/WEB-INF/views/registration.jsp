<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
<link href="css/main.css" rel="stylesheet">
<script type="text/javascript" src="js/main.js"></script>

</head>

<body>
	<div class="employee-style">
		<h2 align="center">Add Employee Data</h2>

		<form action="save.html" method="post" name="myform"
			onsubmit="return validate()">
			<table>
				<tr>
					<td><label>Usertype</label></td>
					<td><select name="usertype">
							<option value="Admin">Admin</option>
							<option value="Employee">Employee</option>
					</select></td>
				</tr>
				<tr>
					<td><label>Employee Name</label></td>
					<td><input type="text" name="empName" size="30"></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><input type="email" name="email" size="30"></td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td><input type="text" name="password" size="30"></td>
				</tr>
				<tr>
					<td><label>Employee Age</label></td>
					<td><input type="text" name="empAge" size="30"></td>
				</tr>
				<tr>
					<td><label>Employee Salary</label></td>
					<td><input type="text" name="salary" size="30"
						pattern="[0-9]{1,9}" title="enter only numeric value"></td>
				</tr>
				<tr>
					<td><label>Employee Address</label></td>
					<td><textarea rows="2" cols="28" name="empAddress"></textarea></td>
				</tr>
				<tr>
					<td id="p1" colspan="2"><input type="submit" value="submit">
				</tr>
			</table>
		</form>
	</div>
	<%-- <% } 
	}
%> --%>


</body>
</html>