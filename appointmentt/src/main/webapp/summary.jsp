<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Create an account</title>
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
		  width: 100%;
		  height: 100%;
		  display: grid;
		  justify-items: center;
		  align-items: center;
		  background-color: white;
		  border-radius: 7px;
		  box-shadow: 0px 0px 5px 2px black;
		}
		
		#AppForm {
		  align-self: flex-start;
		  display: grid;
		  justify-items: center;
		  align-items: center;
		}
		
		.App-form-field::placeholder {
		  color: #3a3a3a;
		}
		
		.App-form-field {
		  border: none;
		  border-bottom: 1px solid #3a3a3a;
		  margin-bottom: 10px;
		  border-radius: 3px;
		  outline: none;
		  padding: 0px 0px 5px 5px;
		}
		
		#App-form-submit {
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
	
	.navbar {
	 overflow: hidden;
	  background-color: #333;
	  width: 100%;
	  height:100%;
	  border-top-right-radius: 7px;
	  border-top-left-radius: 7px;
	}
	
	.navbar a {
	  float: right;
	  font-size: 16px;
	  color: white;
	  text-align: center;
	  padding: 14px 16px;
	  text-decoration: none;
	}
	
	.dropdown {
	  float: right;
	  overflow: hidden;
	}
	
	.dropdown .dropbtn {
	  font-size: 16px;  
	  border: none;
	  outline: none;
	  color: white;
	  padding: 14px 16px;
	  background-color: inherit;
	  font-family: inherit;
	  margin: 0;
	}
	
	.navbar a:hover, .dropdown:hover .dropbtn {
	  background-color: #111;
	}
	
	.dropdown-content {
	  display: none;
	  position: absolute;
	  background-color: #f9f9f9;
	  min-width: 160px;
	  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
	  z-index: 1;
	}
	
	.dropdown-content a {
	  float: none;
	  color: black;
	  padding: 12px 16px;
	  text-decoration: none;
	  display: block;
	  text-align: left;
	}
	
	.dropdown-content a:hover {
	  background-color: #ddd;
	}
	
	.dropdown:hover .dropdown-content {
	  display: block;
	}
		
	</style>
</head>
<body>
  	<main id="main-holder">
		<div class="navbar">			
	 		<form id="logoutForm" method="POST" action="${contextPath}/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    	</form>
	 		<a onclick="document.forms['logoutForm'].submit()">Logout</a>
	 		<a href="welcome">Book Another Appointment</a>		    		
		</div>
	  	<h2 style="text-align:center"> Appointment Summary. </h2>
		<table>
			<tr>
				<td>Thank you, Your appointment has been booked. Please keep below receipt  for reference. </td>
			</tr>
			
			<tr>
				<td> Appointment Id : ${booking_id} </td>	
			</tr>
			
			<tr>
				<td> Name : ${name} </td>	
			</tr>
			
			<tr>
				<td> Appointment Date : ${booking_date} </td>	
			</tr>
			
			<tr>
				<td> Appointment Time : ${booking_time_from} To ${booking_time_to} </td>	
			</tr>
			
			<tr>
				<td> Contact : ${phone} </td>	
			</tr>
			
			<tr>
				<td style="color: red;" > Please reach 15 minutes prior to appointment time at below venue. </td>	
			</tr> 
			<tr>
				<td><address> 
					Address: 564/A TVC ltd,<br>
					Andheri(E), Mumbai-45566<br>
					India <br>
					Contact : 09878899986 
					</address>
				</td>
			</tr>	
		</table>
  	</main>
</body>
</html>