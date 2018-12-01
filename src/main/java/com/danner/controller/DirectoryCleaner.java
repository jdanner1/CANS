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
            Executors.newScheduledThreadPool(1);;

    public void clean(HttpSession session)  {
        logger.info("Inside the cleaner!!");
        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                String path = (String)session.getAttribute("deletePath"); // relativePath
                logger.info("Relative path: " + path);
                deleteDirectory(path);
            }
        }, 1, 3L , TimeUnit.MINUTES);
    }


    private void deleteDirectory(String path) {  // String path
        File file  = new File(path);
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
                for (String childFilePath : childFiles) {
                    //recursive delete the files
                    deleteDirectory(childFilePath);
                }
            }
        } else {
            //it is a simple file. Proceed for deletion
            if (epoch - file.lastModified() > 12000 && !(keeper.equals(file.getName()))) { //
                logger.info("About to delete file!!");
                boolean isDeleted = file.delete();
                logger.info("File deleted? " + isDeleted);
            }
        }
    }
}
