package com.demo.webapp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import java.net.URLEncoder;

@WebServlet( name="Hello-Servlet", urlPatterns={"/hello"} )
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, java.io.IOException {

        resp.sendRedirect("helloform.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, java.io.IOException {

        String name = req.getParameter("my-name");
        // URL decode to remove illegal cookie characters, such as space etc.
        name = URLEncoder.encode(name, "UTF-8");
        Cookie cookie = new Cookie("myname", name);
        resp.addCookie(cookie);
        resp.sendRedirect("sayhello.jsp");
    }
}