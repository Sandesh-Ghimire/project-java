<%-- 
    Document   : userdetails
    Created on : Sep 16, 2021, 10:17:17 AM
    Author     : Sandesh Ghimire
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("userid");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "register";
String userid = "root";
String password = "";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="https://www.dlf.pt/dfpng/middlepng/18-189455_hd-orange-loading-gif-hd-png-download.png" type="image/gif">
    <link rel="stylesheet" href="prjcss.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   
     
<!-- for footer design only -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">


   
    <title>user details</title>
</head>


<body>
<nav class="nav">
    <div class="container">
        <div class="logo" >
            <img src="flooop.png" height="100px" width="100px">
            
        </div>
        <div id="mainListDiv" class="main_list">
            <ul class="navlinks">
                <li><a href="mainpage.html">Home</a></li>
                <li><div class="dropdown">
                    <button class="dropbtn">Resources 
                     
                    </button>
                    <div class="dropdown-content">
                      
                      <a href="hacking.html">Hacking</a>
                      <a href="web-development.html">Web-development</a>
                      <a href="game.html">Game-development</a>
                    </div>
                  </div>
                </li> 
                <li><a href="about.html">About</a></li>
                <li><a href="service.html">Services</a></li>
                <li><a href="contact.html">Contact Us</a></li>
                <li><a href="index.html" class="">Logout</a></li>
                <li> <a href="profile">Profile</a></li>
              
            </ul>
        </div>
        <span class="navTrigger">
            <i></i>
            <i></i>
            <i></i>
        </span>
    </div>
</nav>


    
    
    <h1 align="center" style="margin:50;">Retrieve data from database in jsp</h1>
<table border="1" align="center">
<tr>
<td>first name</td>
<td>last name</td>
<td>password</td>
</tr>




<%
try{

connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resource", "root", "");
PreparedStatement stmt = connection.prepareStatement("Select * from register where firstname = ?");
String nm= (String) session.getAttribute("name");

stmt.setString (1,nm);

resultSet = stmt.executeQuery();

while(resultSet.next()){
   %>
         
         <tr>
<td><%=resultSet.getString("firstname") %></td>
<td><%=resultSet.getString("lastname") %></td>
<td><%=resultSet.getString("password") %></td>


</tr>
         
      
    <% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
        



</table>



<p align="center">
     <button type="button" class="button" ><span><a href="changePass.html"  style="text-decoration: none;">Change pass</a></span></button>
 <button  type="button"   class="button" ><span><a href="delete"  style="text-decoration: none;">Delete User</a></span></button>
  
</p>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="prjjs.js"></script>


<script>
    $(window).scroll(function() {
        if ($(document).scrollTop() > 50) {
            $('.nav').addClass('affix');
            console.log("OK");
        } else {
            $('.nav').removeClass('affix');
        }
    });
</script>

</body>





</html>
