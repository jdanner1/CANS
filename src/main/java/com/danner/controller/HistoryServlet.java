package com.danner.controller;

import com.danner.entity.User;
import com.danner.entity.Vocalization;
import com.danner.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;


/**
 * Controls the intake of page requests and forwards to the associated JSP.
 * Makes user's vocalizations available to JSP, in the preferred order.
 *
 * @author John Danner
 *
 */
@WebServlet(
        name = "History",
        urlPatterns = {"/History"}
)
public class HistoryServlet extends HttpServlet {

    /**
     * Forwards request and response objects to the JSP page.
     *
     * @param response - the HttpServletResponse object
     * @param request - the HttpServletRequest object
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Vocalization> vocalizations = user.getVocalizations();
        Collections.reverse(vocalizations);

        logger.info("Vocalizations: " + vocalizations);
        session.setAttribute("vocalizations", vocalizations);

        String url = "/userRole01/history.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}


