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
        name = "DeleteVocalizationAction",
        urlPatterns = { "/DeleteVocalizationAction" }
)

public class DeleteVocalizationActionServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao genericDao;

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

        genericDao = new GenericDao(Vocalization.class);
        int vocalizationID = Integer.parseInt(request.getParameter("vocalization"));
        Vocalization vocalization = (Vocalization)genericDao.getEntityByID(vocalizationID);
        genericDao.deleteEntity(vocalization);

        String url = "Home";
        response.sendRedirect(url);
    }
}



