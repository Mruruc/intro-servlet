package com.mruruc.response;

import com.mruruc.exceptions.UserRegistrationValidationException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Locale;

@WebServlet(urlPatterns = {"/postMethod"})
public class PostMethod extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setLocale(Locale.ENGLISH);
        response.setCharacterEncoding("UTF-8");
        response.setDateHeader("Last-Modified",System.currentTimeMillis());
        response.setDateHeader("Expires",System.currentTimeMillis()+86400000L); // Expires 24 hours later

        PrintWriter out = response.getWriter();

        try {
            String userName = request.getParameter("userName");
            String email = request.getParameter("email");

             validation(userName, email);


            out.println("<h1>We Got Below Data: <br/>" +
                    "User Name: " + userName +
                    "<br/> Email:" + email + "</h1>");
            response.setStatus(HttpServletResponse.SC_CREATED); //201

            URL url=new URL("http://localhost:8080/intro_servlet_jsp_war_exploded/");

          out.println("<h3> <a href= " + url + ">Go to home page...</a> </h3>");

        } catch (UserRegistrationValidationException validationException) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, validationException.getMessage());

            //   out.println("<h1>"+ validationException.getMessage() + "</h1>");
        }
    }

    private boolean validation(String userName, String email) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new UserRegistrationValidationException("User Name Cannot Be Null Or Empty String");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new UserRegistrationValidationException("Email Cannot Be Null Or Empty");
        }
        return true;
    }
}
