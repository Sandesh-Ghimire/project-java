///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.resource;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// *
// * @author Sandesh Ghimire
// */
//public class authorize extends HttpServlet{
//    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
//         res.setContentType("text/html");
//        PrintWriter out = res.getWriter();
//        
//        HttpSession session = req.getSession();
//        String fname = (String) session.getAttribute("name");
//        
//        if(fname != null){
//            out.println("sucessful");
//            
//            
//            
//            RequestDispatcher rd = req.getRequestDispatcher("hacking.html");
//                rd.forward(req, res);
//        }
//        else{
//            out.println("error");
//            
//        }
//    }
//    
//}
