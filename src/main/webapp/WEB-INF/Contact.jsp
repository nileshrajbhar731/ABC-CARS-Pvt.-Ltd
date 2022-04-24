<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/cosmo/bootstrap.min.css" integrity="sha384-5QFXyVb+lrCzdN228VS3HmzpiE7ZVwLQtkt+0d9W43LQMzz4HBnnqvVxKg6O+04d" crossorigin="anonymous">

<title>Contact us </title>
<script src="https://kit.fontawesome.com/1bd0e9e09f.js" crossorigin="anonymous"></script>
<style>
  * {
    padding: 0;
    margin: 0;
    border: 0;
    box-sizing: border-box;
}
.containe
    {
        border: 2px solid gray;
        border-radius: 20px;
        box-shadow: 5px 5px 5px 5px #EBECF0;
        width: 1500px;
        height: 600px;
        margin: 40px auto;
        padding: 0 40px 10px 40px;
        display: flex;
    }
    .button1{
        top:76%;
       left:43%;
       width:200px;
       height:40px;
       position: absolute;
       margin:20px;
       }
          
.text5
{
  width: 400px;
}
.content3
{
  margin: 50px;
}
.content4{
  margin: 50px;
}
.content5{
  margin: 50px 100px;
}
.foot{
  display: flex;
  justify-content: center;
}
span{
  margin: 10px;
}

input[type=text], select, textarea {
  width: 400px;
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  
}

input[type=submit] {
  
  color: white;
  padding: 12px 20px;
  border: none;
  
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.cont-form {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  margin: 30px;
}

</style>
</head>
<body>

   <nav class="navbar navbar-light bg-light">
    <div class="container">
  
        <a href="/"><span class="navbar-brand mb-0 h1">ABC_Cars_Pte_Ltd</span></a>
  
<a href="/login">login</a>
<a href="/register">Register</a>
<a href="/about">About Us</a>
<a href="/contact">Contact Us</a>

    </div>
</nav>
<main>
 <div class="containe container">
   <div>
  <h1 style="text-align: center;margin: 20px;">Contact Us</h1>
  <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d241316.64332184338!2d72.74109731120357!3d19.082522324551874!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3be7c6306644edc1%3A0x5da4ed8f8d648c69!2sMumbai%2C%20Maharashtra!5e0!3m2!1sen!2sin!4v1648191304127!5m2!1sen!2sin" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
  </div>
<div class="cont-form">
  <form>
    <label for="fname">First Name</label>
    <input type="text" placeholder="Your name.."><br>

    <label for="lname">Last Name</label>
    <input type="text" placeholder="Your last name.."><br>

    <label for="country">Country</label>
    <select name="country">
    <option disabled selected value="Select Country">Select Country</option>
      <option value="australia">Australia</option>
      <option value="canada">Canada</option>
      <option value="usa">USA</option>
    </select><br>

    <label for="subject">Subject</label>
    <textarea placeholder="Write something.." style="height:100px"></textarea><br>

    <input type="submit" class="btn btn-primary"  value="Submit">
  </form>
</div>
 </div>
 </main>
     <footer >
<div  class="bg-light" style="text-align: center;
  
    padding: 10px;">
  <h5> <b>@Developed by Nilesh Bhardwaj</b> </h5>
</div>
 </footer>
 
</body>
</html>