/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



//this servlet code is not need and this work is done by userdetails.jsp page


package com.resource;

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
public class profile extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
         
       Connect connect = new Connect();
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        HttpSession session = req.getSession();
        
        String fname = (String) session.getAttribute("name");
        String lname = "", pass = "";
        
        try {
            Connection con = connect.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from register where firstname = ?");
            stmt.setString(1, fname);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                fname = (String)rs.getString(1);
                lname = (String)rs.getString(2);
                pass = (String)rs.getString(3);

            }
        //   out.println("/index.html");
       
        
         out.println("");
            out.println("your profile :<br>");
        out.println("your name  is: " + fname + "<br>");
        out.println("Your last name is: " + lname + "<br>");
        out.println("Your Password is: " + pass + "<br>");
         out.println("<a href='changePass.html'>Change  password</a>");
         out.println("<a href='delete'>delete user</a>");
        } catch (Exception e) {
            out.println(e);
        }
        
       
        

     
        
        
    }
    
    
}
