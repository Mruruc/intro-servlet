package com.mruruc.servletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "Consumer",
        description = "Consumer of Servlet Context's Attributes!",
        urlPatterns = {"/loveServlet"}
)
public class CallContextAttributeDefinedInAnotherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        ServletContext servletContext = getServletContext();

        String dbConnection = (String) servletContext.getAttribute("Db_Connection");
        String love =(String) servletContext.getAttribute("LOVE");

        String counter = (String) servletContext.getAttribute("counter");

        System.out.println("Db Connection: "+dbConnection);
        PrintWriter writer = res.getWriter();
        res.setContentType("text/html");

        writer.println("<h1>"+love+"</h1>");
        writer.println("<h1>"+counter+"</h1>");

    }
}
