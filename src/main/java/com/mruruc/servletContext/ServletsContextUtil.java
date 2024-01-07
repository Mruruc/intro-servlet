package com.mruruc.servletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
        name = "ServletContextUtil",
        loadOnStartup = 1
)
public class ServletsContextUtil extends HttpServlet{
    static Integer counter=1;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("Db_Connection",Db.dbConnection);
        incrementCounter(servletContext);
    }

    public static synchronized void incrementCounter(ServletContext context){
        context.setAttribute("Counter",counter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){

    }

    class Db{
       static String dbConnection ="db connection ....";
    }
}
