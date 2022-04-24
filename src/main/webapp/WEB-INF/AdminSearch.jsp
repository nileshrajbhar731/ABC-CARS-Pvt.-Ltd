<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="dd" uri="http://java.sun.com/jsp/jstl/core" %>    
<!doctype html>
<html lang="en">
  <head>
    <title>Admin Car Search</title>
    <!-- Required meta tags -->
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
    @import url("https://fonts.googleapis.com/css2?family=Poppins:weight@100;200;300;400;500;600;700;800&display=swap");

body {
    background-color: #eee;
    font-family: "Poppins", sans-serif;
    font-weight: 300
}

.height {
    height: 100vh
}

.search {
    position: relative;
    box-shadow: 0 0 40px rgba(51, 51, 51, .1)
}

.search input {
    height: 60px;
    text-indent: 25px;
    border: 2px solid #d6d4d4
}

.search input:focus {
    box-shadow: none;
    border: 2px solid blue
}

.search .fa-search {
    position: absolute;
    top: 20px;
    left: 16px
}

.search button {
    position: absolute;
    top: 5px;
    right: 5px;
    height: 50px;
    width: 110px;
    background: blue
}
</style>  
</head>
  <body>
<nav class="navbar navbar-light bg-light">
    <div class="container">
  
        <a href="/admin"><span class="navbar-brand mb-0 h1">ABC_Cars_Pte_Ltd</span></a>
  
<a href="/admin/show">Show Car</a>
<a href="/admin/listUser">listUser</a>

<a href="/admin/add">ADD Car</a>



<form action="/logout">
<input type="submit" class="btn btn-danger" value="logout">
</form>

    </div>
</nav>
    <form action="searchproduct" method="get">
    <div class="container ">
        <div class="row height d-flex justify-content-center align-items-center">
            
            <div class="col-md-8">
                <strong>Which option do you want to choose?</strong>
                <div class="form-check">
                   <input class="form-check-input" type="radio" name="mysearch" value="prodid" id="exampleRadios1"  checked>
                   <label class="form-check-label" for="exampleRadios1">
                    Search By Car Model 
                   </label>
                </div>
                <div class="form-check">
                   <input class="form-check-input" type="radio"name="mysearch" value="prodprice" id="exampleRadios2" >
                   <label class="form-check-label" for="exampleRadios2">
                    Search By Car Price
                   </label>
                </div>
                <div class="search">
                     <i class="fa fa-search"></i>
                      <input type="text" class="form-control" name="searchid" placeholder="Enter the Car Model" required="required"/> 
                      
                    </div>

                    <div class="search">
                        <i class="fa fa-search"></i>
                         <input type="text" name="searchminp" class="form-control" placeholder="Enter the Min Price" required="required"/> 
                         
                       </div>
                       <div class="search">
                        <i class="fa fa-search"></i>
                         <input type="text" name="searchmaxp" class="form-control" placeholder="Enter the Max Price" required="required"/> 
                        
                       </div>
                        <button class="btn btn-primary">Search</button> 
            </div>
        </div>
    </div>
    </form>
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