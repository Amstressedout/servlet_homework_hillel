package com.hillel.controller;

import com.hillel.service.ClientStatusService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientStatusServlet extends HttpServlet {
    private final ClientStatusService clientStatusService = new ClientStatusService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clientStatuses", clientStatusService.findAllFromClientStatus());
        req.getRequestDispatcher("views/clientStatus.jsp").forward(req, resp);
    }
}
