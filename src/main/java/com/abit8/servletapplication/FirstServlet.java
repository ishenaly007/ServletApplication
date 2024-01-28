package com.abit8.servletapplication;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

//@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("INIT");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        var writer = resp.getWriter();
        resp.setHeader("MY_HEADER", "HI!!!!!");
        String header = req.getHeader("user-agent");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            writer.write("<h3>" + header + "</h3>");
        }
        writer.write("<h1>Привет из First servlet</h1>");
        writer.write("<h1>" + header + "</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.write("<h1>" + req.getParameter("login") + "</h1>");
        writer.write("<h2>" + req.getParameter("pwd") + "</h2>");
    }

    @Override
    public void destroy() {
        System.out.println("DESTROY");
    }
}
