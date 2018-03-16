package com.demo.webapp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.RequestDispatcher;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import com.demo.webapp.domain.entities.PhoneBookEntry;
import com.demo.webapp.repositories.PhoneBookEntryRepository;

@WebServlet( urlPatterns={"/phonebook"} )
public class PhoneBookController extends HttpServlet {
    private PhoneBookEntryRepository phoneBookRepository;

    @Override
    public void init() throws ServletException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2unit");
        phoneBookRepository = new PhoneBookEntryRepository(emf);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, java.io.IOException {

        List<PhoneBookEntry> entries = phoneBookRepository.findAll();
        req.setAttribute("entries", entries);
        req.getRequestDispatcher("phonebook.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, java.io.IOException {

        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String phone = req.getParameter("phone");

        // TODO: Add validation?
        PhoneBookEntry entry = new PhoneBookEntry();
        entry.setFname(fname);
        entry.setLname(lname);
        entry.setPhone(phone);
        phoneBookRepository.save(entry);

        resp.sendRedirect("phonebook");
    }
}