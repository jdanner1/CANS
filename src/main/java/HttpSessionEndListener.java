import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.*;
import java.io.File;

//public class HttpSessionEndListener implements ServletContextListener,
//        HttpSessionListener, HttpSessionAttributeListener {
//    private final Logger logger = LogManager.getLogger(this.getClass());
//
//    // Public constructor is required by servlet spec
//    public HttpSessionEndListener() {
//    }
//
//    // -------------------------------------------------------
//    // ServletContextListener implementation
//    // -------------------------------------------------------
//    public void contextInitialized(ServletContextEvent sce) {
//      /* This method is called when the servlet context is
//         initialized(when the Web application is deployed).
//         You can initialize servlet context related data here.
//      */
//    }
//
//    public void contextDestroyed(ServletContextEvent sce) {
//      /* This method is invoked when the Servlet Context
//         (the Web application) is undeployed or
//         Application Server shuts down.
//      */
//    }
//
//    // -------------------------------------------------------
//    // HttpSessionListener implementation
//    // -------------------------------------------------------
//    public void sessionCreated(HttpSessionEvent se) {
//      logger.info("Session started!!!!");
//    }
//
//    public void sessionDestroyed(HttpSessionEvent se) {
//        logger.info("Session ended!!!!");
//        HttpSession session = se.getSession();
//        String sessionId = session.getId();
//        String relativePath = (String)session.getAttribute("relativePath");
//        String path = relativePath + sessionId;
//        deleteDirectory(path);
//    }
//
//    // -------------------------------------------------------
//    // HttpSessionAttributeListener implementation
//    // -------------------------------------------------------
//
//    public void attributeAdded(HttpSessionBindingEvent sbe) {
//      /* This method is called when an attribute
//         is added to a session.
//      */
//    }
//
//    public void attributeRemoved(HttpSessionBindingEvent sbe) {
//      /* This method is called when an attribute
//         is removed from a session.
//      */
//    }
//
//    public void attributeReplaced(HttpSessionBindingEvent sbe) {
//      /* This method is invoked when an attibute
//         is replaced in a session.
//      */
//    }
//
//
//    private void deleteDirectory(String path) {
//
//        File file  = new File(path);
//        if(file.isDirectory()){
//            String[] childFiles = file.list();
//            if(childFiles == null) {
//                //Directory is empty. Proceed for deletion
//                file.delete();
//            }
//            else {
//                //Directory has other files.
//                //Need to delete them first
//                for (String childFilePath :  childFiles) {
//                    //recursive delete the files
//                    deleteDirectory(childFilePath);
//                }
//            }
//        }
//        else {
//            //it is a simple file. Proceed for deletion
//            file.delete();
//        }
//
//    }
//}
