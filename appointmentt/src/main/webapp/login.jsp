<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Log in with your account</title>
      
      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
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
  </head>

  <body>

	<div class="about-section">
	  <h1>Welcome to your health matters.</h1>
	  <p>Please eneter login using valid details for boooking an appointment </p>
	  <p>Please click on "Create an account" to create an account.</p>
	</div>
      <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>
		
        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>
      </form>
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
    </div>

    
  </body>
</html>