package com.danner.persistence;

import com.danner.entity.Post;
import com.danner.entity.User;
import com.danner.persistence.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    UserDao dao;

    @BeforeEach
    void setUp() {
        dao = new UserDao();
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

                database.disconnect();
        } catch (SQLException sqlException) {
            logger.error("SQL_Exceptioon: " , sqlException);
        } catch (Exception exception) {
            logger.error("Exceptioon: " , exception);
        }
    }

    @Test
    void addUser() {
        User user = new User("A", "Luther", "Danner", "ldanner2", "password", "ldanner2@madisoncollege.edu", "password2", 2123970);
        int userID = dao.addUser(user);
        assertNotEquals(0, userID);
        User addedUser = dao.getUserByID(userID);
        assertEquals("Luther", addedUser.getFirstName());
    }

    @Test //Working on this
    void addUserWithPost() {
        User user = new User("A", "Luther", "Danner", "ldanner2", "password", "ldanner2@madisoncollege.edu", "password2", 2123970);

        String statusCode = "A";
        String title = "Dual Axle Dump Trailer";
        String description = "With all steel construction, pull out loading ramps, dual 5,000 lb axles and a 10,000 lb capacity hydraulic dump box, 'The Mule' work trailer will help you get the job done.";
        String categoryCode = "trb";
        String areaCode = "mad";
        String subAreaCode = null;
        String replyEmail = "jdanner1@madisoncollege.edu";
        String privacyCode = "P";
        int outsideContactOk = 0;
        String locationCity = "Madison";
        String locationState = "WI";
        String locationPostal = "53711";
        String locationCrossStreet1 = "John Nolen Dr.";
        String locationCrossStreet2 = "E. Wilson St.";
        String locationLatitude = "43.053619";
        String locationLongitude = "-89.377808";
        String image = null;
        int imagePosition = 0;
        int price = 6899;
        String contactName = "John Danner";
        String contactPhone = null;
        String contactPhoneExtension = null;
        int contactTextOk = 1;
        int seeMyOther = 1;

        Post post = new Post(user, statusCode, title, description, categoryCode, areaCode, subAreaCode, replyEmail, privacyCode, outsideContactOk,
                locationCity, locationState, locationPostal, locationCrossStreet1, locationCrossStreet2, locationLatitude, locationLongitude, image,
                imagePosition, price, contactName, contactPhone, contactPhoneExtension, contactTextOk, seeMyOther);

        user.addPost(post);

        int userID = dao.addUser(user);
        assertNotEquals(0, userID);
        User addedUser = dao.getUserByID(userID);
        assertEquals("Luther", addedUser.getFirstName());
        assertEquals(1, addedUser.getPosts().size());
    }

    @Test
    void getUserByID() {
        User retrievedUser = dao.getUserByID(1);
        assertNotNull(retrievedUser);
        assertEquals("John", retrievedUser.getFirstName());
    }

    @Test
    void updateUser() {
        String newFirstName = "Lily";
        User user = dao.getUserByID(1);
        user.setFirstName(newFirstName);
        dao.updateUser(user);
        User retrievedUser = dao.getUserByID(1);
        assertEquals(newFirstName, retrievedUser.getFirstName());
    }

    @Test
    void deleteUser() {
        dao.deleteUser(dao.getUserByID(1));
        assertNull(dao.getUserByID(1));
    }
}

