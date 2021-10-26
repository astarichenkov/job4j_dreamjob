package ru.job4j.dream.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RemoveCandidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getParameter("id"));
//        String id = req.getParameter("id");
        File downloadFile = null;
        File[] files= new File("c:\\images\\").listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
        }

//        Files.delete(Paths.get(downloadFile.getName()));


    }
}