<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
	
	
	
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

body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}

html {
  box-sizing: border-box;
}

*, *:before, *:after {
  box-sizing: inherit;
}

.column {
  float: left;
  width: 33.3%;
  margin-bottom: 16px;
  padding: 0 8px;
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  margin: 8px;
}

.about-section {
  padding: 50px;
  text-align: center;
  background-color: #474e5d;
  color: white;
}

.container {
  padding: 0 16px;
}

.container::after, .row::after {
  content: "";
  clear: both;
  display: table;
}

.title {
  color: grey;
}

.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
}

.button:hover {
  background-color: #555;
}

@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
	
</style>
<title>Welcome</title>
</head>
<body>
	   
	<div class="navbar">			
	  	<div class="dropdown">
	    	<button class="dropbtn"> For Appointment </button>
	    	<div class="dropdown-content">
	      		<a href="login">Sign in</a>
	      		<a href="register">Sign up?</a>
	    	</div>	    	
	  	</div>
	  	
	  	<div class="dropdown">
	  		<button class="dropbtn"> Admin </button>
	    	<div class="dropdown-content">
	      		<a href="#">Sign in</a>
	    	</div>
	    </div>
	    	 		
	</div>
	
	
	<div class="about-section">
	  <h1>Welcome to your health matters.</h1>
	  <p>Please click on "For Appointment" tab in top right corner for boooking an appointment </p>
	  <p>Please click on "For Appointment" tab in top right corner for boooking an appointment</p>
	</div>

<h2 style="text-align:center">Visit Dr.Krishna Maher for guidence and treatment for following.</h2>
<div class="row">
	<div class="column">
	    <div class="card">
	      <div class="container">
	        <h2>Pediatrician</h2>
	        <p class="title">For child health issues</p>
	        <p>Some text that describes good Pediatrician.</p>
	      </div>
	    </div>
  	</div>

	<div class="column">
	    <div class="card">
	      <div class="container">
	        <h2>Dietitian</h2>
	        <p class="title">For Nutritional issues</p>
	        <p>Some text that describes good Dietitian.</p>
	      </div>
	    </div>
	</div>
  
	<div class="column">
	    <div class="card">
	      <div class="container">
	        <h2>Rheumatologists</h2>
	        <p class="title">For bone related diseases</p>
	        <p>Some text that describes good Rheumatologists. </p>
	      </div>
	    </div>
	</div>
</div>
</body>
</html>