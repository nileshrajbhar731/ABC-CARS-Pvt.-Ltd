<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>  
     <%@ taglib prefix="th" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
 <!-- Bootstrap CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"/>
 <script src="https://kit.fontawesome.com/372a3a159c.js" crossorigin="anonymous"></script>
</head>
<style>
   

* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;	
	font-family: Raleway, sans-serif;
}

body {
	background: linear-gradient(90deg, #C7C5F4, #776BCC);		
}

.containe {
	display: flex;
	align-items: center;
	justify-content: center;
	min-height: 100vh;
}

.screen {		
	background: linear-gradient(90deg, #5D54A4, #7C78B8);		
	position: relative;	
	height: 600px;
	width: 360px;	
	box-shadow: 0px 0px 24px #5C5696;
}

.screen__content {
	z-index: 1;
	position: relative;	
	height: 100%;
}

.screen__background {		
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	z-index: 0;
	-webkit-clip-path: inset(0 0 0 0);
	clip-path: inset(0 0 0 0);	
}

.screen__background__shape {
	transform: rotate(45deg);
	position: absolute;
}

.screen__background__shape1 {
	height: 520px;
	width: 520px;
	background: #FFF;	
	top: -50px;
	right: 120px;	
	border-radius: 0 72px 0 0;
}

.screen__background__shape2 {
	height: 220px;
	width: 220px;
	background: #6C63AC;	
	top: -172px;
	right: 0;	
	border-radius: 32px;
}

.screen__background__shape3 {
	height: 540px;
	width: 190px;
	background: linear-gradient(270deg, #5D54A4, #6A679E);
	top: -24px;
	right: 0;	
	border-radius: 32px;
}

.screen__background__shape4 {
    height: 400px;
    width: 200px;
    background: #7E7BB9;
    top: 190px;
    right: 50px;
    border-radius: 0px;
}

.login {
	width: 320px;
	padding: 30px;
	padding-top: 150px;
}

.login__field {
	padding: 20px 0px;	
	position: relative;	
}

.login__icon {
	position: absolute;
	top: 30px;
	color: #7875B5;
}

.login__input {
	border: none;
	border-bottom: 2px solid #D1D1D4;
	background: none;
	padding: 10px;
	padding-left: 24px;
	font-weight: 700;
	width: 75%;
	transition: .2s;
}

.login__input:active,
.login__input:focus,
.login__input:hover {
	outline: none;
	border-bottom-color: #6A679E;
}

.login__submit {
	background: #fff;
	font-size: 14px;
	margin-top: 30px;
	padding: 16px 20px;
	border-radius: 26px;
	border: 1px solid #D4D3E8;
	text-transform: uppercase;
	font-weight: 700;
	display: flex;
	align-items: center;
	width: 100%;
	color: #4C489D;
	box-shadow: 0px 2px 2px #5C5696;
	cursor: pointer;
	transition: .2s;
}

.login__submit:active,
.login__submit:focus,
.login__submit:hover {
	border-color: #6A679E;
	outline: none;
}

.button__icon {
	font-size: 24px;
	margin-left: auto;
	color: #7875B5;
}

</style>
<body>
 <nav class="navbar navbar-light bg-light">
        <div class="container">
      
            <a href="/"><span class="navbar-brand mb-0 h1">ABC_Cars_Pte_Ltd</span></a>
      
<a href="/about">About Us</a>
<a href="/contact">Contact Us</a>
            <a href="/register"><span class="btn btn-primary">Register</span></a>
        </div>
    </nav>
    <th:if test="${param.error}">
                  <h5 class="bg-danger text-center">Please Check Your Email And Password</h5>
            </th:if>
 
    <div class="containe">
        <div class="screen">
            <div class="screen__content">
               
                    <form class="login" action="/login" method="post">
                    
                    
                    <div class="login__field">
                        
                        <i class="login__icon fas fa-at"></i> 
                        <input type="email" name="username" class="login__input" placeholder="Enter the email" required="required"/>
                    </div>
                    
                    <div class="login__field">
                        <i class="login__icon fa-solid fa-lock"></i>
                        <input type="password" name="password" class="login__input" placeholder="Enter the password" required="required"/>
                    </div>
                   <input type="hidden"                          
        name="${_csrf.parameterName}"  
        value="${_csrf.token}"/>  
                   
                    <button class="button login__submit">
                        <span class="button__text">login</span>
                        <i class="button__icon fas fa-chevron-right"></i>
                    </button>	
                </form>			
               
             
            </div>
            <div class="screen__background">
                <span class="screen__background__shape screen__background__shape4"></span>
                <span class="screen__background__shape screen__background__shape3"></span>		
                <span class="screen__background__shape screen__background__shape2"></span>
                <span class="screen__background__shape screen__background__shape1"></span>
            </div>		
        </div>
    </div>
      <footer >
<div  class="bg-light" style="text-align: center;
  
    padding: 10px;">
  <h5> <b>@Developed by Nilesh Bhardwaj</b> </h5>
</div>
 </footer>
</body>
</html>