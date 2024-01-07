package com.mruruc.fileUpload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;

@WebServlet(urlPatterns = {"/cv"})
@MultipartConfig
public class FileUploadHandling extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        Part cv = req.getPart("cv");


        if (cv != null && !cv.getSubmittedFileName().isEmpty()) {

            File file = new File("C:\\Users\\mruru\\Desktop\\intro_servlet-jsp\\src\\main\\resources\\test1.txt");

            try (InputStream inputStream = cv.getInputStream();
                 FileOutputStream fileOutputStream = new FileOutputStream(file)) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

            }
        } else {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "No CV file uploaded.");
            return;
        }


        res.setContentType("text/html");
        PrintWriter writer = res.getWriter();
        writer.println("<h2> Email:" + email +" <br/> " +
                "Cv:"+ cv.getSubmittedFileName() +"</h2>");
    }

}
