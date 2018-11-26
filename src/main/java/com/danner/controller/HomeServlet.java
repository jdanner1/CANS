package com.danner.controller;

import com.danner.entity.Role;
import com.danner.entity.User;
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
import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * Controls the intake of page requests and forwards to the associated JSP.
 *
 * @author John Danner
 *
 */
@WebServlet(
        name = "Home",
        urlPatterns = {"/Home"}
)
public class HomeServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao genericDao;
    private GenericDao genericDao2;
    private String relativePath;

    /**
     * Forwards request and response objects to the JSP page.
     *
     * @param response - the HttpServletResponse object
     * @param request - the HttpServletRequest object
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        genericDao = new GenericDao(User.class);
        genericDao2 = new GenericDao(Role.class);
        String userName = request.getUserPrincipal().getName();
        List<User> users = genericDao.getAll();
        User user = null;
        Role role = null;
        int userID = 0;

        for (User currentUser : users) {
            logger.info(currentUser.getUserName());
            if (currentUser.getUserName().equals(userName)) {
                userID = currentUser.getUserID();
                user = (User)genericDao.getEntityByID(userID);
                role = (Role)genericDao2.getEntityByID(userID);
            }
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", role);

        relativePath = this.getServletContext().getRealPath("audio-files/");

        Runtime.getRuntime().addShutdownHook(new Thread() {  //  https://stackoverflow.com/questions/2070179/how-to-check-session-has-been-expired-in-java
                                                      // this is not working because it only triggers when tomcat shuts down
                                                      // use link to learn when session ends and clean up then.  Alternately have a job run looking for
                                                      //old stuff

            public void run() {
                // setting it up to use this start of the path:  HomeServlet.this.relativePath;
                String sessionId = request.getSession().getId();
                String path = relativePath + sessionId;
                //File outputFile = new File(path, "output.wav");
                //outputFile.delete();
                deleteDirectory(path);




            }
        });


        String url = "/userRole01/home.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    public void deleteDirectory(String path) {

        File file  = new File(path);
        if(file.isDirectory()){
            String[] childFiles = file.list();
            if(childFiles == null) {
                //Directory is empty. Proceed for deletion
                file.delete();
            }
            else {
                //Directory has other files.
                //Need to delete them first
                for (String childFilePath :  childFiles) {
                    //recursive delete the files
                    deleteDirectory(childFilePath);
                }
            }
        }
        else {
            //it is a simple file. Proceed for deletion
            file.delete();
        }

    }
}

