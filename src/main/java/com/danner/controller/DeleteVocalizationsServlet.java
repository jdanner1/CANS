package com.danner.controller;

import com.danner.entity.User;
import com.danner.entity.Vocalization;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Controls the intake of page requests and forwards to the associated JSP.
 *
 * @author John Danner
 *
 */
@WebServlet(
        name = "DeleteVocalizations",
        urlPatterns = {"/DeleteVocalizations"}
)
public class DeleteVocalizationsServlet extends HttpServlet {

    /**
     * Forwards request and response objects to the JSP page.
     *
     * @param response - the HttpServletResponse object
     * @param request - the HttpServletRequest object
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Vocalization> vocalizations;
        UserManager userManager = new UserManager();
        vocalizations = userManager.getVocalizations();

        HttpSession session = request.getSession();
        session.setAttribute("vocalizations", vocalizations);

        String url = "/admin/delete-vocalizations.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}



