package com.danner.controller;

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

/**
 * The Home action servlet processes the form to create a new vocalization, calls for the new vocalization and directs the user based on the outcome of that attempt.
 *
 * @author John Danner
 */
@WebServlet(
        name = "HomeAction",
        urlPatterns = { "/HomeAction" }
)

public class HomeActionServlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests and directs user based on the outcome of the vocalization generation process.
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

        Boolean result = generateVocalization(request);
        if (result) {
            String url = "Vocalization";
            response.sendRedirect(url);
        } else {
            String url = "VocalizationFailure";
            response.sendRedirect(url);
        }
    }

    /**
     * Takes the steps required to generate a vocalization and make file information available to the JSP.  It reports outcome of attempt.
     * @param request
     * @return
     */
    private Boolean generateVocalization(HttpServletRequest request)  {
        final Logger logger = LogManager.getLogger(this.getClass());
        GenericDao vocalizationDao;
        vocalizationDao = new GenericDao(Vocalization.class);
        String text = request.getParameter("main-input");
        String language = request.getParameter("language");
        boolean isEmailed = false;


        HttpSession session = request.getSession();
        String sessionId = (String)session.getAttribute("sessionId");
        User user = (User)session.getAttribute("user");

        Vocalization vocalization = new Vocalization(user, text, language, isEmailed);
        vocalizationDao.addEntity(vocalization);

        VoiceFiler audio = new VoiceFiler();

        String relativePath1 = this.getServletContext().getRealPath("audio-files/");
        logger.info("HomeActionServlet Path1 to generate file: " + relativePath1);

        Boolean result = audio.generateVoiceFile(vocalization, sessionId, relativePath1);

        String fileSuffix = Integer.toString(vocalization.getVocalizationID());
        String playPath = "/audio-files/" + sessionId + "/output" + fileSuffix + ".wav";
        session.setAttribute("vocalization", vocalization);
        session.setAttribute("playPath", playPath);
        return result;
    }
}