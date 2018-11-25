package com.danner.controller;

import com.danner.entity.Role;
import com.danner.entity.User;
import com.danner.entity.Vocalization;
import com.danner.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 *
 *
 *@author    John Danner
 */
@WebServlet(
        name = "DeleteUserAction",
        urlPatterns = { "/DeleteUserAction" }
)

public class DeleteUserActionServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao genericDao;
    private GenericDao genericDao2;
    private GenericDao genericDao3;

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

        genericDao = new GenericDao(User.class);
        int userID = Integer.parseInt(request.getParameter("userName"));
        User user = (User)genericDao.getEntityByID(userID);
        deleteVocalizations(user);
        deleteRoles(user);

        genericDao.deleteEntity(user);

        String url = "Home";
        response.sendRedirect(url);
    }

    private void deleteVocalizations(User user) {
        genericDao3 = new GenericDao(Vocalization.class);
        List<Vocalization> allVocalizations = genericDao3.getAll();
        for (Vocalization currentVocalization : allVocalizations) {
            if (user.equals(currentVocalization.getUser())) {
                genericDao3.deleteEntity(currentVocalization);
            }
        }
    }

    private void deleteRoles(User user) {
        genericDao2 = new GenericDao(Role.class);
        List<Role> allRoles = genericDao2.getAll();
        for (Role currentRole : allRoles) {
            if (currentRole.getUserName().equals(user.getUserName())) {
                genericDao2.deleteEntity(currentRole);
            }
        }
    }
}

