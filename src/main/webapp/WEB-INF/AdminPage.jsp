<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="dd" uri="http://java.sun.com/jsp/jstl/core" %>  
        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<title>Admin Page</title>
</head>
<style>
  body{
    background-image: url(https://pbs.twimg.com/media/DQcnGOnUEAE_e3U.jpg);
  }
</style>
<body>

<nav class="navbar navbar-light bg-light">
    <div class="container">
  
        <a href="/admin"><span class="navbar-brand mb-0 h1">ABC_Cars_Pte_Ltd</span></a>
  
<a href="/admin/show">Show Car</a>
<a href="/admin/listUser">listUser</a>
<a href="/admin/search">Search</a>
<a href="/admin/add">ADD Car</a>
<dd:forEach var="car" items="${show}">
<tr>

<td><i class="login__icon fas fa-user">  ${car}</i></td>



</tr>
</dd:forEach>


<form action="/logout">
<input type="submit" class="btn btn-danger" value="logout">
</form>

    </div>
</nav>

</body>
</html>
