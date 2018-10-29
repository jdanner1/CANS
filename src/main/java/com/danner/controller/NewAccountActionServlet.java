package com.danner.controller;

import com.danner.entity.User;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *
 *
 *@author    John Danner
 */
@WebServlet(
        name = "NewAccountAction",
        urlPatterns = { "/NewAccountAction" }
)

public class NewAccountActionServlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general
     *                              servlet exception
     *@exception  IOException       if there is a general
     *                              I/O exception
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();

        String statusCode = "A";
        String firstName = request.getParameter("first");
        String lastName = request.getParameter("last");
        String userName = request.getParameter("user");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(statusCode, firstName, lastName, userName, password, email);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        String url = "/Home";
        response.sendRedirect(url);

    }
}