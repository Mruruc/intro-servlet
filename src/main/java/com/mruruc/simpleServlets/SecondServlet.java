package com.mruruc.simpleServlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
       try{
           StringBuffer requestURL = req.getRequestURL();
           PrintWriter writer = res.getWriter();

           writer.println("<h1>From Servlet configured with xml !</h1>");
           writer.println("<h1>User URL:"+requestURL+" !</h1>");

       } catch (IOException exception) {
           System.out.println(exception.getMessage());
           throw exception;
       }
    }
}
