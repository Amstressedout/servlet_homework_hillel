package com.hillel.controller;

import com.hillel.service.ClientsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clients")
public class ClientsServlet extends HttpServlet {
    private final ClientsService clientsService = new ClientsService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("clients", clientsService.findAllClients());
        request.getRequestDispatcher("views/clients.jsp").forward(request, response);
    }
}