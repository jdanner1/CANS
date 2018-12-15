package com.danner.controller;

import com.danner.entity.User;
import com.danner.persistence.GenericDao;
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
        name = "EditProfileAction",
        urlPatterns = { "/EditProfileAction" }
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

        GenericDao userDao;
        userDao = new GenericDao(User.class);

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String status = request.getParameter("status");

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setStatusCode(status);
        user.setModifyDate(LocalDate.now());
        userDao.updateEntity(user);

        String url = "Home";
        response.sendRedirect(url);

    }
}
