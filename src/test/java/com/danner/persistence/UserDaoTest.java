package com.danner.persistence;

import com.danner.entity.Vocalization;
import com.danner.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private UserDao dao;
    private VocalizationDao vocalizationDao;

    @BeforeEach
    void setUp() {
        dao = new UserDao();
        vocalizationDao = new VocalizationDao();
        TestUserGenerator testUser = new TestUserGenerator();
        testUser.initializeUser();
    }

    @Test
    void addUser() {
        User user = new User("A", "Luther", "Danner", "ldanner2", "password", "ldanner2@madisoncollege.edu");
        int userID = dao.addUser(user);
        assertNotEquals(0, userID);
        User addedUser = dao.getUserByID(userID);
        assertEquals("Luther", addedUser.getFirstName());
    }

    @Test
    void addUserWithVocalization() {
        User user = new User("A", "Luther", "Danner", "ldanner2", "password", "ldanner2@madisoncollege.edu");

        String text = "Testing add user with vocoalization method.";
        String language = "en-US_AllisonVoice";
        boolean isEmailed = true;

        Vocalization vocalization = new Vocalization(user, text, language, isEmailed);

        user.addVocalization(vocalization);

        int userID = dao.addUser(user);
        assertNotEquals(0, userID);
        User addedUser = dao.getUserByID(userID);
        assertEquals(user, addedUser);
        assertEquals(1, addedUser.getVocalizations().size());
        int vocalizationId = vocalization.getVocalizationID();
        Vocalization addedVocalization = vocalizationDao.getVocalizationByID(vocalizationId);
        assertEquals(vocalization, addedVocalization);
        logger.info("User Info: " + user.toString());
        logger.info("Vocalization Info: " + vocalization.toString());
    }

    @Test
    void getUserByID() {
        User retrievedUser = dao.getUserByID(1);
        assertNotNull(retrievedUser);
        assertEquals(dao.getUserByID(1), retrievedUser);
        logger.info("User Info: " + retrievedUser.toString());
    }

    @Test
    void updateUser() {
        String newFirstName = "Lily";
        User user = dao.getUserByID(1);
        user.setFirstName(newFirstName);
        dao.updateUser(user);
        User retrievedUser = dao.getUserByID(1);
        assertEquals(user, retrievedUser);
        logger.info("User Info: " + retrievedUser.toString());
    }

    @Test
    void deleteUser() {
        dao.deleteUser(dao.getUserByID(1));
        assertNull(dao.getUserByID(1));
    }
}

