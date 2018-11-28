package com.danner.controller;

import com.danner.entity.Role;
import com.danner.entity.User;
import com.danner.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * Controls the intake of page requests and forwards to the associated JSP.
 *
 * @author John Danner
 *
 */
@WebServlet(
        name = "Home",
        urlPatterns = {"/Home"}
)
public class HomeServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao genericDao;
    private GenericDao genericDao2;
    private String relativePath;
    private DirectoryCleaner cleaner;

    /**
     * Forwards request and response objects to the JSP page.
     *
     * @param response - the HttpServletResponse object
     * @param request - the HttpServletRequest object
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        genericDao = new GenericDao(User.class);
        genericDao2 = new GenericDao(Role.class);
        String userName = request.getUserPrincipal().getName();
        List<User> users = genericDao.getAll();
        User user = null;
        Role role = null;
        int userID = 0;

        for (User currentUser : users) {
            if (currentUser.getUserName().equals(userName)) {
                userID = currentUser.getUserID();
                user = (User)genericDao.getEntityByID(userID);
                role = (Role)genericDao2.getEntityByID(userID);
            }
        }

        HttpSession session = request.getSession();

        relativePath = this.getServletContext().getRealPath("audio-files/");
        session.setAttribute("user", user);
        session.setAttribute("role", role);
        session.setAttribute("relativePath", relativePath);
        cleaner = new DirectoryCleaner();
        cleaner.clean(session);


        String url = "/userRole01/home.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}

