package com.demo.webapp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;

@WebServlet( name="Hello-Servlet", urlPatterns={"/hello"} )
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, java.io.IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("helloform.html");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, java.io.IOException {

        req.setAttribute("name", req.getParameter("my-name"));
        RequestDispatcher dispatcher = req.getRequestDispatcher("sayhello.jsp");
        dispatcher.forward(req, resp);
    }

}