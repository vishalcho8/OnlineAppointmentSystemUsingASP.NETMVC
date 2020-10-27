<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
	  background-color: #6df076;
	}
	
	#main-holder {
	  width: auto;
	  height: auto;
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
	  overflow: scroll;
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

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
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
<title>Admin</title>
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
		  	<a href="welcome">Goto Appointment Booking</a>
		</div>
		<form:form id="loginForm"  modelAttribute="bookingdetail" >
			<table align="center">			
			     <tr>
				      <th>ID</th>
				      <th>Name</th>
				      <th>Email</th>
				      <th>Date</th>
				      <th>Time from</th>
				      <th>Time to</th>
				      <th>Update</th>
				      <th>Delete</th>				      
			     </tr>
		  			    
				 <c:forEach items="${admin}" var="bookinglist">
			      <tr>
			       <td>${bookinglist.booking_id}</td>
			       <td>${bookinglist.name}</td>
			       <td>${bookinglist.email}</td>
			       <td>${bookinglist.booking_date} </td>
			       <td>${bookinglist.booking_time_from}</td>
			       <td>${bookinglist.booking_time_to}</td>
			       <td><a type="button" id="login-form-submit"
			        href="/updatebooking?id=${bookinglist.booking_id}">Update</a> </td>
			       <td> <a type="button" id="login-form-submit"
			        href="/delete?id=${bookinglist.booking_id}">Delete</a></td>
			      </tr>
			     </c:forEach>
			     
			</table>
		</form:form>
 	</main>
	
</body>
</html>