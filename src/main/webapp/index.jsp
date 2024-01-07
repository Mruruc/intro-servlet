<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>HOME</title>
    </head>
    <body>
       <h1><%= "Home Page!" %></h1>
       <br/>
       <a href="https://github.com/Mruruc">My GitHub ....</a>
       <br/>

       <a href="http://localhost:8080/intro_servlet_jsp_war_exploded/SimpleServletPath"> first Servlet </a>
       <br/>
       <a href="http://localhost:8080/intro_servlet_jsp_war_exploded/secondServlet">
           Second Servlet Configured With Deployment descriptor.
       </a>
       <br/>
       <button style="background-color: cornflowerblue">
           <a href="http://localhost:8080/intro_servlet_jsp_war_exploded/Login.html">
               Log in
           </a>
       </button>
       <br/>
        <h1>
            <a href="http://localhost:8080/intro_servlet_jsp_war_exploded/httpHeader">
                Header Information:
            </a>
        </h1>
    </body>
</html>