package com.danner.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class DirectoryCleaner {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);
    private String path;

    public void clean(HttpSession session)  {
        logger.info("Inside the cleaner!!");
        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                path = (String)session.getAttribute("relativePath"); // relativePath
                logger.info("Relative path: " + path);
                deleteDirectory(path);
            }
        }, 1, 3L , TimeUnit.MINUTES);
    }

// https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
    private void deleteDirectory(String receivedPath) {  // String path

        File file  = new File(receivedPath);

        String keeper = "README.md";
        LocalDateTime time = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        long epoch = time.atZone(zoneId).toEpochSecond();
        if (file.isDirectory()) {
            String[] childFiles = file.list();
            if (childFiles == null) {
                //Directory is empty. Proceed for deletion
                file.delete();
            } else {
                //Directory has other files.
                //Need to delete them first
                for (String itemInFolder : childFiles) {
                    //recursive delete the files
                    logger.info("Item in Directory: " + itemInFolder);
                    String updatedPath = path + itemInFolder;
                    logger.info("Item to delete: " + updatedPath);
                    File tester = new File(updatedPath);
                    if (!(tester.isDirectory())) {
                        String fullPath = tester.getAbsolutePath();
                        logger.info("fullPath: " + fullPath);
                        deleteDirectory(fullPath);
                    } else {
                        deleteDirectory(updatedPath);
                    }
                }
            }
        } else {
            //it is a simple file. Proceed for deletion
            if (epoch - file.lastModified() > 12000 && !(keeper.equals(file.getName()))) { //
                logger.info("About to delete file!!");
                logger.info("The file: " + file.getName());
                boolean isDeleted = file.delete();
                logger.info("File deleted? " + isDeleted);
            }
        }
    }
}
