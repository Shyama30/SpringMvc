<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring3MVC with Hibernate3 CRUD Example using Annotations</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<% 
if(session.getAttribute("user1")==null){
	response.sendRedirect("login.html");
	
}
else
       if (session.getAttribute("user1") != null && request.getParameter("message") != null) {

				out.print("Dear" + " " + session.getAttribute("user1") +" "+ request.getParameter("message"));

       }
%>

	<div class="index-style">
		<h2>
			<a href="add.html">Add Employee</a>
		</h2>
		<h2>
			<a href="employees.html">List of Employees</a>
		</h2>
	</div>
<%-- <% } %>  --%>
</body>
</html>