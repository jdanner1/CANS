package com.danner.controller;

import com.danner.entity.Role;
import com.danner.entity.User;
import com.danner.persistence.GenericDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


/**
 * Controls the intake of page requests and forwards to the associated JSP.
 * Identifies user and makes details available to JSP.
 * @author John Danner
 *
 */
@WebServlet(
        name = "Home",
        urlPatterns = {"/Home"}
)
public class HomeServlet extends HttpServlet {

    /**
     * Forwards request and response objects to the JSP page.
     *
     * @param response - the HttpServletResponse object
     * @param request - the HttpServletRequest object
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GenericDao userDao;
        GenericDao roleDao;
        String relativePath;

        userDao = new GenericDao(User.class);
        roleDao = new GenericDao(Role.class);
        String userName = request.getUserPrincipal().getName();
        List<User> users = userDao.getAll();
        User user = null;
        Role role = null;
        int userID = 0;
        String deletePath = request.getContextPath() + "/audio-files/";

        // Get current user based on user name
        for (User currentUser : users) {
            if (currentUser.getUserName().equals(userName)) {
                userID = currentUser.getUserID();
                user = (User)userDao.getEntityByID(userID);
                role = (Role)roleDao.getEntityByID(userID);
            }
        }

        HttpSession session = request.getSession();
        String sessionId = request.getSession().getId();

        relativePath = this.getServletContext().getRealPath("audio-files/");
        session.setAttribute("sessionId", sessionId);
        session.setAttribute("user", user);
        session.setAttribute("role", role);
        session.setAttribute("relativePath", relativePath);
        session.setAttribute("deletePath", deletePath);

        String url = "/userRole01/home.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}

