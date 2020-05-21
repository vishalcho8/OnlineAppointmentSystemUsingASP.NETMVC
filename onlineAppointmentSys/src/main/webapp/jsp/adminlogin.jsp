<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
	html {
  height: 100%;
	}
	
	body {
	  height: 100%;
	  margin: 0;
	  font-family: Arial, Helvetica, sans-serif;
	  display: grid;
	  justify-items: center;
	  align-items: center;
	  background-color: #3a3a3a;
	}
	
	#main-holder {
	  width: 50%;
	  height: 70%;
	  display: grid;
	  justify-items: center;
	  align-items: center;
	  background-color: white;
	  border-radius: 7px;
	  box-shadow: 0px 0px 5px 2px black;
	}
	
	#loginForm {
	  align-self: flex-start;
	  display: grid;
	  justify-items: center;
	  align-items: center;
	}
	
	.login-form-field::placeholder {
	  color: #3a3a3a;
	}
	
	.login-form-field {
	  border: none;
	  border-bottom: 1px solid #3a3a3a;
	  margin-bottom: 10px;
	  border-radius: 3px;
	  outline: none;
	  padding: 0px 0px 5px 5px;
	}
	
	#login-form-submit {
  width: 100%;
  padding: 7px;
  border: none;
  border-radius: 5px;
  color: white;
  font-weight: bold;
  background-color: #3a3a3a;
  cursor: pointer;
  outline: none;
}
	
</style>
<title>Admin Login</title>
</head>
<body>
	<main id="main-holder">
	    <h1 id="login-header">Admin Account Login</h1>
		<form:form id="adminloginForm" modelAttribute="adminlogin" action="adminloginProcess"
			method="post">
			<table align="center">
				<tr>
					<td><form:input type="text" class="login-form-field" placeholder="Username" path="username" name="username" 
							id="username" /></td>
				</tr>
				<tr>
					<td><form:password class="login-form-field" placeholder="Password" path="password" name="password"
							id="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td align="left"><form:button id="login-form-submit" name="login">Login</form:button></td>
				</tr>
	
				<tr></tr>
				<tr>
					<td></td>
					<td><a href="home.jsp">Home</a></td>
				</tr>
			</table>
		</form:form>
		
		<table align="center">
			<tr>
				<td style="font-style: italic; color: red;">${message}</td>
			</tr>
		</table>
 	</main>
</body>
</html>