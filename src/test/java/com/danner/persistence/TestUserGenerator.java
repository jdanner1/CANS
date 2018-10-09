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
            result = statement.executeUpdate("TRUNCATE post;");
            logger.info("SQL_Result_2: " + result);
            result = statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
            logger.info("SQL_Result_3: " + result);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user "
                    + "(status_code, first_name, last_name, user_name, password, email, cl_password, cl_accountID, create_date) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");


            preparedStatement.setString(1, "A");
            preparedStatement.setString(2, "John");
            preparedStatement.setString(3, "Danner");
            preparedStatement.setString(4, "jdanner1");
            preparedStatement.setString(5, "password");
            preparedStatement.setString(6, "jdanner@madisoncollege.edu");
            preparedStatement.setString(7, "password2");
            preparedStatement.setInt(8, 12345678);
            preparedStatement.setDate(9, new java.sql.Date(System.currentTimeMillis()));
            rowsAdded = preparedStatement.executeUpdate();
            logger.info("User Rows Added: " + rowsAdded);


            PreparedStatement preparedStatement2 = connection.prepareStatement("INSERT INTO post "
                    + "(userID, status_code, title, description, category_code, area_code, subarea_code, replyemail, privacy_code, outsidecontactok," +
                    "location_city, location_state, location_postal, location_crossstreet1, location_crossstreet2, location_latitude, location_longitude," +
                    "image, image_position, price, contact_name, contact_phone, contact_phone_extension, contacttextok, seemyother) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");


            preparedStatement2.setInt(1, 1);
            preparedStatement2.setString(2, "A");
            preparedStatement2.setString(3, "Snowmobile Trailer");
            preparedStatement2.setString(4, "High quality long lasting aluminum 2 place snowmobile trailer with drive off/on ramps and 6,000 GVWR capacity");
            preparedStatement2.setString(5, "trb");
            preparedStatement2.setString(6, "mad");
            preparedStatement2.setString(7, null);
            preparedStatement2.setString(8, "jdanner1@madisoncollege.edu");
            preparedStatement2.setString(9, "P");
            preparedStatement2.setInt(10, 0);
            preparedStatement2.setString(11, "Madison");
            preparedStatement2.setString(12, "WI");
            preparedStatement2.setString(13, "53711");
            preparedStatement2.setString(14, "John Nolen Dr.");
            preparedStatement2.setString(15, "E. Wilson St.");
            preparedStatement2.setString(16, "43.053619");
            preparedStatement2.setString(17, "-89.377808");
            preparedStatement2.setString(18, null);
            preparedStatement2.setInt(19, 0);
            preparedStatement2.setInt(20, 5499);
            preparedStatement2.setString(21, "John Danner");
            preparedStatement2.setString(22, null);
            preparedStatement2.setString(23, null);
            preparedStatement2.setInt(24, 1);
            preparedStatement2.setInt(25, 1);
            rowsAdded = preparedStatement2.executeUpdate();
            logger.info("Post Rows Added: " + rowsAdded);
            database.disconnect();
        } catch (SQLException sqlException) {
            logger.error("SQL_Exceptioon: " , sqlException);
        } catch (Exception exception) {
            logger.error("Exceptioon: " , exception);
        }

    }
}
