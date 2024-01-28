package com.abit8.servletapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/second")
public class SecondMap extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        var writer = resp.getWriter();
        String param1 = req.getParameter("param1");
        writer.write("<h1>" + param1 + "</h1>");

        Map<String, String[]> parameterMap = req.getParameterMap();
        parameterMap.entrySet().forEach(e -> writer.println("<h3>" + e.getKey() + " = " + Arrays.toString(e.getValue()) + "</h3>"));
    }
}
