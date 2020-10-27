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
		  	<div class="dropdown">
		    	<button class="dropbtn">User Profile</button>
		    	<div class="dropdown-content"> 
					<div class="dropdown-content">
		      		<a href="#">${pageContext.request.userPrincipal.name}</a>
		      		<form id="logoutForm" method="POST" action="${contextPath}/logout">
			            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			        </form>
		      		<a onclick="document.forms['logoutForm'].submit()">Logout</a>
		    	</div>
		    	</div>
		  	</div>
		  	<a href="/admin">Admin</a> 	
		</div>
		
		<h1 id="Reg-header"> Appointment Rescheduling </h1>
		 
		<form:form id="AppForm" method="POST" modelAttribute="bookingdetail">
			<form:hidden path="booking_id" />
			<form:hidden path="name" />
			<form:hidden path="email" />
			<form:hidden path="phone" />
			<form:hidden path="booked_on" />
			<table align="center">
				<tr>
				<td>Please provide following details.</td>
				</tr>
						
				<tr>
				<td>only appointment Date and time can be updated.</td>
				</tr>	
				<tr>
				<td><form:input class="App-form-field" path="booking_date" type="date" id="start" name="appDate"
				       value="${booking_date_temp}"
				       min="${booking_date_temp}" /> </td>
				 <td> <small>Choose an Appointment date</small> </td>		
				</tr>
				
				<tr>
				<td> <form:select class="App-form-field" path="booking_time_from" id="apptTF" name="apptFrom">
				    <option value="09.00" selected="">09.00</option>
				    <option value="09.30">09.30</option>
				    <option value="10.00">10.00</option>
				    <option value="10.30">10.30</option>
				    <option value="11.00">11.00</option>
				    <option value="11.30">11.30</option>
				    <option value="12.00">12.00</option>
				    <option value="12.30">12.30</option>
				    <option value="13.00">13.00</option>
				    <option value="13.30">13.30</option>
				    <option value="14.00">14.00</option>
				    <option value="14.30">14.30</option>
				    <option value="15.00">15.00</option>
				    <option value="15.30">15.30</option>
				    <option value="16.00">16.00</option>
				    <option value="16.30">16.30</option>
				    <option value="17.00">17.00</option>
				    <option value="17.30">17.30</option>
				    <option value="18.00">18.00</option>
				</form:select> 
				</td>
				
				<td> <small>Choose Appointment from</small> </td>
				</tr>
				
				<tr>
				<td> <form:select class="App-form-field" path="booking_time_to" id="apptTT" name="apptTo">
				    <option value="09.00" >09.00</option>
				    <option value="09.30" selected="">09.30</option>
				    <option value="10.00">10.00</option>
				    <option value="10.30">10.30</option>
				    <option value="11.00">11.00</option>
				    <option value="11.30">11.30</option>
				    <option value="12.00">12.00</option>
				    <option value="12.30">12.30</option>
				    <option value="13.00">13.00</option>
				    <option value="13.30">13.30</option>
				    <option value="14.00">14.00</option>
				    <option value="14.30">14.30</option>
				    <option value="15.00">15.00</option>
				    <option value="15.30">15.30</option>
				    <option value="16.00">16.00</option>
				    <option value="16.30">16.30</option>
				    <option value="17.00">17.00</option>
				    <option value="17.30">17.30</option>
				    <option value="18.00">18.00</option>
				</form:select> 
				</td>
				
				<td> <small>Choose appointment to</small> </td>	
				</tr>
				
				<tr>
					<td></td>
					<td><form:button id="App-form-submit" name="submit">Update</form:button></td>
				</tr>
				<tr></tr>
				
			</table>
		</form:form>
	</main>
</body>
</html>