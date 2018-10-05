package com.danner.persistence;

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

