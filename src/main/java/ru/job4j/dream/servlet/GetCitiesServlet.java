package ru.job4j.dream.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.dream.model.City;
import ru.job4j.dream.store.DbStore;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class GetCitiesServlet extends HttpServlet {
    private static final Gson GSON = new GsonBuilder().create();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        City city = GSON.fromJson(req.getReader(), City.class);
        resp.setContentType("application/json; charset=utf-8");
        OutputStream output = resp.getOutputStream();
        String json = GSON.toJson(city);
        output.write(json.getBytes(StandardCharsets.UTF_8));
        output.flush();
        output.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<City> cities = DbStore.instOf().getAllCities();
        resp.setContentType("application/json; charset=utf-8");
        OutputStream output = resp.getOutputStream();
        String json = GSON.toJson(cities);
        output.write(json.getBytes(StandardCharsets.UTF_8));
        output.flush();
        output.close();
    }
}