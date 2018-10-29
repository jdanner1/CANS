package com.danner.controller;

import com.danner.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;


/**
 *
 *
 *@author    John Danner
 */
@WebServlet(
        name = "NewAccountAction",
        urlPatterns = { "/NewAccountAction" }
)

public class EditProfileActionServlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception ServletException  if there is a general
     *                              servlet exception
     *@exception IOException       if there is a general
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

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        user.setStatusCode(statusCode);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setModifyDate(LocalDate.now());

        String url = "/Home";
        response.sendRedirect(url);

    }
}
