package ru.job4j.dream.servlet;

import ru.job4j.dream.store.DbStore;
import ru.job4j.dream.store.MemStore;
import ru.job4j.dream.utils.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RemoveCandidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        File file = FileUtils.getFileById(id);
        if (file != null) {
            Files.delete(Paths.get(file.getAbsolutePath()));
        }
        DbStore.instOf().removeCandidateById(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}