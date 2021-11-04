/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resource;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Sandesh Ghimire
 */
public class login extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        Connect connect = new Connect();
        String fname = req.getParameter("username");
        String pass = req.getParameter("password");
        try{
        Connection con = connect.getConnection();
        PreparedStatement stmt = con.prepareStatement("select password from register where firstname = ? ");
        stmt.setString(1, fname);
        
        ResultSet rs;
        rs = stmt.executeQuery();
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
        if(rs.next()){
            String password = rs.getString(1);
            if(password.equals(pass)){
              //  out.println("Welcome bro");
                HttpSession session = req.getSession();
                session.setAttribute("name", fname);
               
                RequestDispatcher rd = req.getRequestDispatcher("mainpage.html");
                rd.forward(req, res);
                
            }else{
                out.println("<br>Wrong username or password.");
            }
        }else{
            
            out.println("<h1>please enter correct value and try again </h1>");
        }
        
        }catch(Exception e){
            out.println(e);
        }
        
    }
    
}
