<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="dd" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<title>User View Car</title>
<meta charset="ISO-8859-1">

    <!-- Bootstrap CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>

<style>
    body {
    background-color: #eee
}

.card {
    border: none;
    border-radius: 10px;
}

.c-details span {
    font-weight: 300;
    font-size: 13px
}

.icon {
    width: 50px;
    height: 50px;
    background-color: #eee;
    border-radius: 15px;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 39px
}

.badge span {
    background-color: #fffbec;
    width: 60px;
    height: 25px;
    padding-bottom: 3px;
    border-radius: 5px;
    display: flex;
    color: #fed85d;
    justify-content: center;
    align-items: center;
}

.progress {
    height: 10px;
    border-radius: 10px;
}

.progress div {
    background-color: red;
}

.text1 {
    font-size: 14px;
    font-weight: 600;
}

.text2 {
    color: #a5aec0;
}
</style>
  <body>
    <nav class="navbar navbar-light bg-light">
        <div class="container">
      
            <a href="/user"><span class="navbar-brand mb-0 h1">ABC_Cars_Pte_Ltd</span></a>
            <a href="/user/add"><span class="btn btn-success">ADD Car</span></a>
         

<a href="/user/search">Search</a>
          <form action="/logout">
<input type="submit" class="btn btn-danger" value="logout">
</form>
        </div>
    </nav>
   <div class="container mt-5">
      <div class="container-fluid">
          <div class="row">
            <dd:forEach var="prod" items="${show}">
            <div class="card-group  mt-2 col-md-4">
                <div class="card">
                    <img class="card-img-top" src="/uploads/${prod.image}" width="250" height="230" alt="Card image cap">
                    <div class="card-body">
                    <h4 class="card-title">Car Name:${prod.carName}</h4>
                        <h4 class="card-title">Car Model:${prod.carModel}</h4>
                        <p class="card-text">Car Registration Number:${prod.carRegNumber}</p>
                        <p class="card-text">Car Manufacturer Date:${prod.manufaData}</p>
                        <p class="card-text">Car Price:${prod.carPrice}</p>
                       
                    </div>
                </div>
            </div>
          </dd:forEach>
            </div>
      </div>
  </div>
     <footer >
<div  class="bg-light mt-5" style="text-align: center;
  
    padding: 10px;">
  <h5> <b>@Developed by Nilesh Bhardwaj</b> </h5>
</div>
 </footer>
</body>
</html>