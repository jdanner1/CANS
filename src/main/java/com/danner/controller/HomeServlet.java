package com.danner.controller;

import com.danner.entity.Role;
import com.danner.entity.User;
import com.danner.entity.Vocalization;
import com.danner.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;


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
        String deletePath = request.getContextPath() + "/audio-files/";

        for (User currentUser : users) {
            if (currentUser.getUserName().equals(userName)) {
                userID = currentUser.getUserID();
                user = (User)genericDao.getEntityByID(userID);
                role = (Role)genericDao2.getEntityByID(userID);
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

