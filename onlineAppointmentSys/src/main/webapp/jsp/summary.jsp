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
	  height: 65%;
	  display: grid;
	  justify-items: center;
	  align-items: center;
	  background-color: white;
	  border-radius: 7px;
	  box-shadow: 0px 0px 5px 2px black;
	}


.navbar {
  overflow: hidden;
  background-color: #333;
  width: 100%;
  height: 100%;
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

.navbar a:hover {
  background-color: #111;
}
</style>
<title>Summary</title>
</head>
<body>
	<main id="main-holder">
		<div class="navbar">			
			<a href="home.jsp">Logout</a>		
		</div>
	    <h1 id="sum-header"> Appointment Summary. </h1>
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