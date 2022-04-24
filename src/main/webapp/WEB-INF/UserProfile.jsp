<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="java.util.regex.*"%>
<!doctype html>
<html lang="en">
  <head>
    <title>User Profile</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
  <style>
    * {
    margin: 0;
    padding: 0
}

body {
	background: linear-gradient(90deg, #C7C5F4, #776BCC);		
}

.card {
    width: 350px;
    background-color: #efefef;
    border: none;
    cursor: pointer;
    transition: all 0.5s
}

.image img {
    transition: all 0.5s
}

.card:hover .image img {
    transform: scale(1.5)
}

.btn_ {
    height: 140px;
    width: 140px;
    border-radius: 50%
}

.name {
    font-size: 22px;
    font-weight: bold
}

.idd {
    font-size: 14px;
    font-weight: 600
}

.idd1 {
    font-size: 12px
}

.number {
    font-size: 22px;
    font-weight: bold
}

.follow {
    font-size: 12px;
    font-weight: 500;
    color: #444444
}

.btn1 {
    height: 40px;
    width: 150px;
    border: none;
    background-color: #000;
    color: #aeaeae;
    font-size: 15px
}

.text span {
    font-size: 13px;
    color: #545454;
    font-weight: 500
}

.icons i {
    font-size: 19px
}

hr .new1 {
    border: 1px solid
}

.join {
    font-size: 14px;
    color: #a0a0a0;
    font-weight: bold
}

.date {
    background-color: #ccc
}
  </style>
  </head>
  <body>
     <nav class="navbar navbar-light bg-light">
        <div class="container">
      
            <a href="/user"><span class="navbar-brand mb-0 h1">ABC_Cars_Pte_Ltd</span></a>
      <a href="/user/show">Show CarList</a>
<a href="/user/add">ADD Car</a>
<a href="/user/search">Search</a>

            
            <form action="/logout">
<input type="submit" class="btn btn-danger" value="logout">
</form>
        </div>
    </nav>
    <div class="container mt-4 mb-4 p-3 d-flex justify-content-center">
      <div class="card p-4">
          <div class=" image d-flex flex-column justify-content-center align-items-center">
             <button class="btn_ btn btn-secondary">
                <img src="http://assets.stickpng.com/images/585e4bf3cb11b227491c339a.png" height="100" width="100" />
             
              </button>
              <span class="name mt-3">${show.fullName}</span> 
               <span class="name mt-3">${show.userName}</span> 
               <span class="idd">${show.mailid}</span>
              <div class="d-flex flex-row justify-content-center align-items-center gap-2">
                 <span class="idd1">${show.role}</span>
                  <span><i class="fa fa-copy"></i></span>
                 </div>
              
              <div class=" d-flex mt-2"> 
                <button class="btn1 btn-light"><a href="/user/profile/Update/${show.userName}">Edit Profile</a></button> 
              </div>
              
          </div>
      </div>
  </div>
       <footer >
<div  class="bg-light mt-5" style="text-align: center;
  
    padding: 10px;">
  <h5> <b>@Developed by Nilesh Bhardwaj</b> </h5>
</div>
                  
 </footer>
 
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>