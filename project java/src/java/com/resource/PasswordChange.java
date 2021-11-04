package com.resource;

import com.resource.Connect;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sandesh Ghimire
 */
public class PasswordChange extends HttpServlet{
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        
        Connect connect = new Connect();
       HttpSession session = req.getSession();
        String name = (String)session.getAttribute("name");
        
        if(name == null){
            out.println("Please register first");
        }else{
            try{
                String pass = (String)req.getParameter("newpassword");
                Connection con = connect.getConnection();
                PreparedStatement stmt;
                stmt = con.prepareStatement("update register set password = ? where firstname = ?");
                stmt.setString(2, name);
                stmt.setString(1, pass);
                
                stmt.execute();
                
                con.close();
                
                res.sendRedirect("mainpage.html");
            }catch(Exception e){
                out.println(e);
            }
        }
        
        out.close();
    
    
    }
    
}
