package com.hillel.controller;

import com.hillel.service.AccountsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/accounts")
public class AccountsServlet extends HttpServlet {
    private final AccountsService accountsService = new AccountsService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("accounts", accountsService.findAllAccounts());
        request.getRequestDispatcher("views/accounts.jsp").forward(request, response);
    }
}
