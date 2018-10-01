package com.danner.controller;

import com.danner.persistence.Database;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoadArea {

    private final Logger logger = LogManager.getLogger(this.getClass());


    public void loadInputFile() {
        String filePath = "/home/student/IdeaProjects/individualproject/src/main/resources/area.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ) {

            loadRecords(reader);
        } catch (FileNotFoundException fileNotFoundException) {
            logger.error("FileNotFoundException: " , fileNotFoundException);
        } catch (IOException inputOutputException) {
            logger.error("IOException: ", inputOutputException);
        } catch (Exception exception) {
            logger.error("Exception: " , exception);
        }
    }

    private void loadRecords(BufferedReader reader) {
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = null;

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();

            while (reader.ready()) {
                sql = reader.readLine();
                int message = selectStatement.executeUpdate(sql);
                logger.info(message);
            }

            database.disconnect();
        } catch (SQLException e) {
            logger.error("LoadArea.loadRecords()...SQL Exception: ", e);
        } catch (Exception e) {
            logger.error("LoadArea.loadRecords()...Exception: ", e);
        }
    }
}
