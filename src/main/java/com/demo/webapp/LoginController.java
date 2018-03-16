package com.demo.webapp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.demo.webapp.services.AuthenticationService;

@WebServlet( urlPatterns={"/login"} )
public class LoginController extends HttpServlet {
    private AuthenticationService authService;

    @Override
    public void init() throws ServletException {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2unit");
            authService = new AuthenticationService(emf);
        }
        catch(Exception ex) {
            throw new ServletException(
                "Could not initialize authentication service",
                ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, java.io.IOException {

        RequestDispatcher dispatcher  = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, java.io.IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            if(authService.authenticate(username, password)) {
                HttpSession session = req.getSession();
                session.setAttribute("authenticated", "true");
                resp.sendRedirect("phonebook");
                return;
            }
        }
        catch(Exception ex) {
            throw new ServletException(
                "Could not query authentication service",
                ex);
        }


        // Forwards to login.jsp if user was not authenticated
        doGet(req, resp);
    }
}