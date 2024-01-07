package com.mruruc;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/UrlParameter"})
public class UrlParameter extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String contentType = request.getParameter("contentType");


        if("JSON".equalsIgnoreCase(contentType)){
            response.setContentType("application/json");
        }
        else if("HTML".equalsIgnoreCase(contentType)){
            response.setContentType("text/html");
        }
        else{
            response.setContentType("text/xml");
        }

        PrintWriter writer = response.getWriter();
        if("HTML".equalsIgnoreCase(contentType)) {
            writer.println("<h1>Hello</h1>");
        } else if("JSON".equalsIgnoreCase(contentType)) {
            writer.println("{\"message\": \"Hello\"}");
        } else {
            writer.println("<message>Hello</message>");
        }
    }

}
