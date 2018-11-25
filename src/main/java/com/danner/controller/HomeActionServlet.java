package com.danner.controller;

import com.danner.entity.User;
import com.danner.entity.Vocalization;
import com.danner.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 *
 *@author    John Danner
 */
@WebServlet(
        name = "HomeAction",
        urlPatterns = { "/HomeAction" }
)

public class HomeActionServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao genericDao;
    private GenericDao genericDao2;

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

        generateVocalization(request);

        String url = "Vocalization";
        response.sendRedirect(url);
    }

    private void generateVocalization(HttpServletRequest request)  {
        genericDao = new GenericDao(Vocalization.class);
        String text = request.getParameter("main-input");
        String language = request.getParameter("language");
        String email = request.getParameter("email");
        boolean isEmailed = false;


        if (email.equals("Yes")) {
            isEmailed = true;
        }

        HttpSession session = request.getSession();
        String sessionId = request.getSession().getId();
        User user = (User)session.getAttribute("user");

        Vocalization vocalization = new Vocalization(user, text, language, isEmailed);
        genericDao.addEntity(vocalization);

        VoiceFiler audio = new VoiceFiler();

        String relativePath = this.getServletContext().getRealPath("audio-files/");
        audio.generateVoiceFile(vocalization, sessionId, request, relativePath);

        String catalinaHome = System.getProperty("catalina.home");
        String playPath = "/audio-files/" + sessionId + "/output.wav";  //  FileNotFoundException: /home/student/tomcat/audio-files/4C1F657DC83452F3536E64698BF847D2/output.wav
        session.setAttribute("vocalization", vocalization);
        session.setAttribute("sessionId", sessionId);
        session.setAttribute("playPath", playPath);
    }
}