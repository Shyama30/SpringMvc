
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>All Employees</title>
<link href="css/main.css" rel="stylesheet">
</head>
<body class="list-style">



	<%
		if (session.getAttribute("user1") == null) {
			response.sendRedirect("login.html");

		} else
			if (session.getAttribute("user1") != null && request.getParameter("message") != null) {

				out.print("Dear" + " " + session.getAttribute("user1") + " " + request.getParameter("message"));
			}
	%>
	<h1>List Employees</h1>
	<div>
			<a href="add.html">Add More Employee</a>
			<a href="index.html">Back</a>
			<a href="logout.html">logout</a>
	</div>
	<div>

		<c:if test="${!empty employees}">
			<table border="1">
				<tr>
					<th>Employee Name</th>
					<th>Password</th>
					<th>Email</th>
					<th>Employee Age</th>
					<th>Employee Salary</th>
					<th>Employee Address</th>
					<th>Usertype</th>
					<th>Actions on Row</th>
				</tr>

				<c:forEach items="${employees}" var="employee">
					<tr>
						<td><c:out value="${employee.empName}" /></td>
						<td><c:out value="${employee.password}" /></td>
						<td><c:out value="${employee.email}" /></td>
						<td><c:out value="${employee.empAge}" /></td>
						<td><c:out value="${employee.salary}" /></td>
						<td><c:out value="${employee.empAddress}" /></td>
						<td><c:out value="${employee.usertype}" /></td>
						<td align="center"><a
							href="edit.html?empId=${employee.empId}">Edit</a> | <a
							href="delete.html?empId=${employee.empId}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<%-- <%
		}
		
		
	%> --%>
</body>
</html>