/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resource;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sandesh Ghimire
 */
public class register extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
       res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String fname = (String)req.getParameter("Fname");
        String lname = (String)req.getParameter("Lname");
        String pass = (String)req.getParameter("password");
        
       
        
        
       Connect connect = new Connect();
        try {
            Connection con = connect.getConnection();
            PreparedStatement stmt;
            stmt = con.prepareStatement("insert into register (firstname, lastname, password) values (?, ?, ?)");
            stmt.setString(1, fname);
            stmt.setString(2, lname);
            stmt.setString(3, pass);
            
            stmt.execute();
         
            
            out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <link rel=\"icon\" href=\"https://www.dlf.pt/dfpng/middlepng/18-189455_hd-orange-loading-gif-hd-png-download.png\" type=\"image/gif\">\n" +
"    <link rel=\"stylesheet\" href=\"prjcss.css\">\n" +
"    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
"   \n" +
"     \n" +
"<!-- for footer design only -->\n" +
"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n" +
"<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\" integrity=\"sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/\" crossorigin=\"anonymous\">\n" +
"\n" +
"\n" +
"   \n" +
"    <title>resources</title>\n" +
"</head>\n" +
"\n" +
"\n" +
"\n" +
"<body>\n" +
"<nav class=\"nav\">\n" +
"    <div class=\"container\">\n" +
"        <div class=\"logo\" >\n" +
"            <img src=\"flooop.png\" height=\"100px\" width=\"100px\">\n" +
"            \n" +
"        </div>\n" +
"        <div id=\"mainListDiv\" class=\"main_list\">\n" +
"            <ul class=\"navlinks\">\n" +
"                <li><a href=\"index.html\">Home</a></li>\n" +
"                <li><div class=\"dropdown\">\n" +
"                    <button class=\"dropbtn\">Resources \n" +
"                     \n" +
"                    </button>\n" +
"\n" +
"                  </div>\n" +
"                </li> \n" +
"                <li><a href=\"about.html\">About</a></li>\n" +
"                <li><a href=\"service.html\">Services</a></li>\n" +
"                <li><a href=\"contact.html\">Contact Us</a></li>\n" +
"               \n" +
"              \n" +
"            </ul>\n" +
"        </div>\n" +
"        <span class=\"navTrigger\">\n" +
"            <i></i>\n" +
"            <i></i>\n" +
"            <i></i>\n" +
"        </span>\n" +
"    </div>\n" +
"</nav>\n" +
"\n" +
"    \n" +
"</body><!-- comment --> \n" +
"</html>\n" +
"     ");
            out.println("<h1><br>Registration sucessful</h1>");
            out.println("<h1><br> click here to go to home page: <a href=mainpage.html>me</a></h1>");
        } catch (Exception ex) {
            out.println(ex);
        } 
    }
}
