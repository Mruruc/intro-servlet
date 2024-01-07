package com.mruruc.request;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = {"/httpHeader"})
public class Headers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String serverName = request.getServerName();
        String authHeader = request.getHeader("Authorization");

        StringBuffer requestURL = request.getRequestURL();
        String authType = request.getAuthType();
        String method = request.getMethod();
        String contextPath = request.getContextPath();
        String pathInfo = request.getPathInfo();
        String pathTranslated = request.getPathTranslated();
        String remoteUser = request.getRemoteUser();
        String localAddr = request.getLocalAddr();
        String localName = request.getLocalName();
        int remotePort = request.getRemotePort();

        Enumeration<String> headerNames = request.getHeaderNames();

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Header Information's:</h1>");
        writer.println("<h3> Server Name:" +serverName+ " </h3>");
        writer.println("<h3> Authorization:" +authHeader+ " </h3>");
        writer.println("<h3> Request Url :" +requestURL+ " </h3>");
        writer.println("<h3> Auth :" +authType+ " </h3>");
        writer.println("<h3> Method:" +method+ " </h3>");
        writer.println("<h3> Context Path :" +contextPath+ " </h3>");
        writer.println("<h3> Path Information :" +pathInfo+ " </h3>");
        writer.println("<h3> Path Translated :" +pathTranslated+ " </h3>");
        writer.println("<h3> Remote User :" +remoteUser+ " </h3>");
        writer.println("<h3>  Local Addr:" +localAddr+ " </h3>");
        writer.println("<h3> Local Name :" +localName+ " </h3>");
        writer.println("<h3> Remote Port :" +remotePort+ " </h3>");

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            writer.println("<p><b>" + headerName + ":</b> " + headerValue + "</p>");
        }

    }
}


/*
*
* User-Agent: Provides information about the client's browser or other user agent.
String userAgent = request.getHeader("User-Agent");
*
Referer: Indicates the URL of the webpage that linked to the resource being requested. Useful for understanding navigation flow.
String referer = request.getHeader("Referer");
*
Accept-Language: Used to determine the client's preferred language, which can be useful for localization.
String language = request.getHeader("Accept-Language");
*
Host: Specifies the domain name of the server and (optionally) the TCP port number on which the server is listening.
String host = request.getHeader("Host");
*
Authorization: Contains credentials for authenticating the client with the server, often used in API requests.
String authHeader = request.getHeader("Authorization");
*
Content-Type: Used in POST and PUT requests to indicate the media type of the resource being sent in the request body.
String contentType = request.getHeader("Content-Type");
*
Cookie: Contains cookies sent by the client to the server.
String cookies = request.getHeader("Cookie");
* */
