package com.mruruc.servletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Set;


@WebServlet(urlPatterns ={"/servletContext"})
public class GeneralServletContextFeature extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext servletContext = getServletContext();

        String contextPath = servletContext.getContextPath();
        int majorVersion = servletContext.getMajorVersion();
        int minorVersion = servletContext.getMinorVersion();
        Set<String> resourcePaths = servletContext.getResourcePaths("/WEB-INF");

        //list of servlets in this servlets context:
       // Enumeration<Servlet> servletNames = servletContext.getServlets();

        servletContext.log("Log test......");

        // get server info
        String serverInfo = servletContext.getServerInfo();

        // set an attribute to servlet context
        servletContext.setAttribute("LOVE","Tomcat");
        //get all attribute
        Enumeration<String> attributeNames = servletContext.getAttributeNames();

     ///   servletContext.setResponseCharacterEncoding("UTF-8");
        //get name of servlet context
        String servletContextName = servletContext.getServletContextName();

        PrintWriter writer = response.getWriter();

        writer.println("<h1> Servlet Context Name: "+servletContextName+"</h1>");
        writer.println("<h1 > Context Path: "+contextPath+"</h1>");
        writer.println("<h1 > Major Version: "+majorVersion+"</h1>");
        writer.println("<h1 > Minor Version: "+minorVersion+"</h1>");

        resourcePaths.stream().forEach((resource)
        -> writer.println("<h1 > Resource : "+resource+"</h1>"));

/*
       while (servletNames.hasMoreElements()){
           Servlet servlet = servletNames.nextElement();
           writer.println("<li>"+ servlet.getServletInfo() +"</li>");
       }
*/
       writer.println("<h3>Server Info: " +serverInfo + "</h3>");

       while (attributeNames.hasMoreElements()){
           String s = attributeNames.nextElement();
           writer.println("<li> "+attributeNames +"->"+ s +"</li>");
       }

    }
}
