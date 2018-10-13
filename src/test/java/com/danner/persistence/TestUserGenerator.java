package com.danner.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUserGenerator {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public void initializeUser() {
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = null;
        int rowsAdded = 0;

        try  {
            database.connect();
            connection = database.getConnection();
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
            logger.info("SQL_Result_1: " + result);
            result = statement.executeUpdate("TRUNCATE user;");
            result = statement.executeUpdate("TRUNCATE vocalization;");
            logger.info("SQL_Result_2: " + result);
            result = statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
            logger.info("SQL_Result_3: " + result);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user "
                    + "(status_code, first_name, last_name, user_name, password, email, create_date) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)");


            preparedStatement.setString(1, "A");
            preparedStatement.setString(2, "John");
            preparedStatement.setString(3, "Danner");
            preparedStatement.setString(4, "jdanner1");
            preparedStatement.setString(5, "password");
            preparedStatement.setString(6, "jdanner@madisoncollege.edu");
            preparedStatement.setDate(7, new java.sql.Date(System.currentTimeMillis()));
            rowsAdded = preparedStatement.executeUpdate();
            logger.info("User Rows Added: " + rowsAdded);


            PreparedStatement preparedStatement2 = connection.prepareStatement("INSERT INTO vocalization "
                    + "(userID, text, language, isEmailed, create_timestamp) "
                    + "VALUES (?, ?, ?, ?, ?)");


            preparedStatement2.setInt(1, 1);
            preparedStatement2.setString(2, "This is the default vocalization created by Test User Generator");
            preparedStatement2.setString(3, "en-US_AllisonVoice");
            preparedStatement2.setBoolean(4, true);
            preparedStatement2.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            rowsAdded = preparedStatement2.executeUpdate();
            logger.info("Vocalization Rows Added: " + rowsAdded);
            database.disconnect();
        } catch (SQLException sqlException) {
            logger.error("SQL_Exceptioon: " , sqlException);
        } catch (Exception exception) {
            logger.error("Exceptioon: " , exception);
        }

    }
}
