package com.danner.controller;

import com.danner.entity.User;
import com.danner.entity.Vocalization;
import com.danner.persistence.GenericDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Identifies the vocalization selected for regeneration, gets the details needed to rebuild it and does so.  The user is directed based on the outcome.
 *
 *@author    John Danner
 */
@WebServlet(
        name = "ResubmitVocalization",
        urlPatterns = { "/ResubmitVocalization" }
)

public class ResubmitVocalizationServlet extends HttpServlet {

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

        GenericDao vocalizationDao;
        vocalizationDao = new GenericDao(Vocalization.class);
        HttpSession session = request.getSession();
        String sessionId = (String)session.getAttribute("sessionId");
        String relativePath = (String)session.getAttribute("relativePath");

        int vocalizationID = Integer.parseInt(request.getParameter("vocalization"));
        Vocalization vocalization = (Vocalization)vocalizationDao.getEntityByID(vocalizationID);
        User user = vocalization.getUser();
        String text = vocalization.getText();
        String language = vocalization.getLanguage();
        boolean isEmailed = vocalization.isEmailed();

        Vocalization newVocalization = new Vocalization(user, text, language, isEmailed);
        vocalizationDao.addEntity(newVocalization);

        VoiceFiler audio = new VoiceFiler();
        Boolean result = audio.generateVoiceFile(newVocalization, sessionId, relativePath);
        session.setAttribute("vocalization", newVocalization);

        if (result) {
            String url = "Vocalization";
            response.sendRedirect(url);
        } else {
            String url = "VocalizationFailure";
            response.sendRedirect(url);
        }
    }
}



