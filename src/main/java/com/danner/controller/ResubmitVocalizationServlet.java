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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 *
 *@author    John Danner
 */
@WebServlet(
        name = "ResubmitVocalization",
        urlPatterns = { "/ResubmitVocalization" }
)

public class ResubmitVocalizationServlet extends HttpServlet {
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
        HttpSession session = request.getSession();
        String sessionId = (String)session.getAttribute("sessionId");
        String relativePath = (String)session.getAttribute("relativePath");

        int vocalizationID = Integer.parseInt(request.getParameter("vocalization"));
        Vocalization vocalization = (Vocalization)genericDao.getEntityByID(vocalizationID);
        User user = vocalization.getUser();
        String text = vocalization.getText();
        String language = vocalization.getLanguage();
        boolean isEmailed = vocalization.isEmailed();

        Vocalization newVocalization = new Vocalization(user, text, language, isEmailed);
        genericDao.addEntity(newVocalization);

        VoiceFiler audio = new VoiceFiler();

        //String relativePath2 = this.getServletContext().getRealPath("audio-files/");
        logger.info("relativePath: " + relativePath);
        logger.info("SessionId: " + sessionId);
        logger.info("Context Path: " + request.getContextPath());
        audio.generateVoiceFile(newVocalization, sessionId, relativePath);

        String playPath = "/audio-files/" + sessionId + "/output.wav";
        logger.info("Play path: " + playPath);
        session.setAttribute("vocalization", newVocalization);
        session.setAttribute("playPath", playPath);


        String url = "Vocalization";
        response.sendRedirect(url);
    }
}



