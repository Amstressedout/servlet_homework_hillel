package com.hillel.controller;

import com.hillel.service.StatusesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatusesServlet extends HttpServlet {
    private final StatusesService statusesService = new StatusesService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("statuses", statusesService.findAllStatuses());
        req.getRequestDispatcher("views/statuses.jsp").forward(req, resp);
    }
}
