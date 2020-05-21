<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	
	#regForm {
	  align-self: flex-start;
	  display: grid;
	  justify-items: center;
	  align-items: center;
	}
	
	.Reg-form-field::placeholder {
	  color: #3a3a3a;
	}
	
	.Reg-form-field {
	  border: none;
	  border-bottom: 1px solid #3a3a3a;
	  margin-bottom: 10px;
	  border-radius: 3px;
	  outline: none;
	  padding: 0px 0px 5px 5px;
	}
	
	#Reg-form-submit {
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
<title>Registration</title>
</head>
<body>
	<main id="main-holder">
	    <h1 id="Reg-header"> Account Registration </h1>
		<form:form id="regForm" modelAttribute="loginuser" action="registerProcess"
			method="post">
	
			<table align="center">
				<tr>
					<td><form:input type="text" class="Reg-form-field" placeholder="Username" pattern="[A-Za-z0-9]+" path="username" name="username" id="username" /></td>
					<td> <small> Must be unique</small> </td>
				</tr>
				<tr>
					<td><form:input class="Reg-form-field" placeholder="Password" pattern=".{8,}" path="password" name="password"
							id="password" /></td>
				</tr>
				<tr>
					<td><form:input class="Reg-form-field" placeholder="Firstname" pattern="[A-Za-z]+" path="firstname" name="firstname"
							id="firstname" /></td>
				</tr>
				<tr>
					<td><form:input class="Reg-form-field" placeholder="Lastname" pattern="[A-Za-z]+" path="lastname" name="lastname" id="lastname" /></td>
				</tr>
				<tr>
					<td><form:input type="email" class="Reg-form-field" placeholder="Email" path="email" name="email" id="email" /></td>
					<td> <small> ex: xyz@bmail.com</small> </td>
				</tr>
				<tr>
					<td><form:input class="Reg-form-field" placeholder="Address" path="address" name="address" id="address" /></td>
				</tr>
				<tr>
					<td><form:input type="tel" class="Reg-form-field" placeholder="Telephone" pattern="[0-9]{10}" path="phone" name="phone" id="phone" /></td>
					<td> <small> ex: 9778655879</small> </td>
				</tr>
	
				<tr>
					<td></td>
					<td><form:button id="Reg-form-submit" name="register">Register</form:button></td>
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