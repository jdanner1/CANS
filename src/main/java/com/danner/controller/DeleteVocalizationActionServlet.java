package com.danner.controller;

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

/**
 * Takes the delete vocalization form submissions, deletes requested vocalizations and sends the user to the Home page.
 *
 *@author    John Danner
 */
@WebServlet(
        name = "DeleteVocalizationAction",
        urlPatterns = { "/DeleteVocalizationAction" }
)

public class DeleteVocalizationActionServlet extends HttpServlet {

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
        final Logger logger = LogManager.getLogger(this.getClass());
        GenericDao vocalizationDao;

        vocalizationDao = new GenericDao(Vocalization.class);
        String[] ids = request.getParameterValues("vocalization");
        logger.info("Ids: " + ids);

        for (String id : ids) {
            int vocalizationID = Integer.parseInt(id);
            Vocalization vocalization = (Vocalization)vocalizationDao.getEntityByID(vocalizationID);
            vocalizationDao.deleteEntity(vocalization);
        }

        String url = "Home";
        response.sendRedirect(url);
    }
}



