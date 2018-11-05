package com.danner.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Controls the intake of page requests and forwards to the associated JSP.
 *
 * @author John Danner
 *
 */
@WebServlet(
        name = "EditProfile",
        urlPatterns = {"/EditProfile"}
)
public class EditProfileServlet extends HttpServlet {

    /**
     * Forwards request and response objects to the JSP page.
     *
     * @param response - the HttpServletResponse object
     * @param request - the HttpServletRequest object
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/userRole01/edit-profile.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}



