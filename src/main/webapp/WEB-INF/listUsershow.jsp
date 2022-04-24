<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="dd" uri="http://java.sun.com/jsp/jstl/core" %> 
<!doctype html>
<html lang="en">
  <head>
    <title>Admin View Userlist</title>
    <!-- Required meta tags -->
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>
  <body>
<nav class="navbar navbar-light bg-light">
    <div class="container">
  
        <a href="/admin"><span class="navbar-brand mb-0 h1">ABC_Cars_Pte_Ltd</span></a>
  
<a href="/admin/show">Show Car</a>
<a href="/admin/search">Search</a>
<a href="/admin/add">ADD Car</a>



<form action="/logout">
<input type="submit" class="btn btn-danger" value="logout">
</form>

    </div>
</nav>
      <div class="container my-5">
          <div class="container-fluid">
              <table class="table table-dark">
                  <tbody>
                      <tr>
                        <td>#</td>
                          <td>fullName</td>
                          <td>userName</td>
                          <td>userMail</td>
                          <td>userRole</td>
                          <td>userDelete</td>
                          <td>userUpdate</td>
                      </tr>
                      <% int i = 1; %>
                      <dd:forEach var="prod" items="${show}">
                      <tr>
                        <td><%= i %> <% i++; %></td>
                        <td>${prod.fullName}</td>
                        <td>${prod.userName}</td>
                          <td>${prod.mailid}</td>
                          <td>${prod.role}</td>
                        <td><a class="btn btn-danger text-right" href="/deletelistUser?cardId=${prod.userId}">delete</a></td>
                        <td><a class="btn btn-success text-right" href="/admin/listUser/update/${prod.userId}">Update</a></td>
                    </tr>
                </dd:forEach>
                  </tbody>
              </table>
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