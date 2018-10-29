package com.danner.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * Controls the intake of page requests and forwards to the associated JSP.
 *
 * @author John Danner
 *
 */
@WebServlet(
        name = "NewAccount",
        urlPatterns = {"/NewAccount"}
)
public class NewAccountServlet extends HttpServlet {

    /**
     * Forwards request and response objects to the JSP page.
     *
     * @param response - the HttpServletResponse object
     * @param request - the HttpServletRequest object
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/new-account.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
