package com.danner.persistence;

import com.danner.entity.Vocalization;
import com.danner.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao genericDao;
    private GenericDao genericDao2;

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(User.class);
        genericDao2 = new GenericDao(Vocalization.class);
        TestUserGenerator testUser = new TestUserGenerator();
        testUser.initializeUser();
    }

    @Test
    void addUser() {
        User user = new User("A", "Luther", "Danner", "ldanner2", "password", "ldanner2@madisoncollege.edu");
        int userID = genericDao.addEntity(user);
        assertNotEquals(0, userID);
        User addedUser = (User)genericDao.getEntityByID(userID);
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

        int id = genericDao.addEntity(user);
        assertNotEquals(0, id);
        User addedUser = (User)genericDao.getEntityByID(id);
        assertEquals(user, addedUser);
        assertEquals(1, addedUser.getVocalizations().size());
        int vocalizationId = vocalization.getVocalizationID();
        Vocalization addedVocalization = (Vocalization) genericDao2.getEntityByID(vocalizationId);
        assertEquals(vocalization, addedVocalization);
        logger.info("User Info: " + user.toString());
        logger.info("Vocalization Info: " + vocalization.toString());
    }

    @Test
    void getUserByID() {
        User retrievedUser = (User)genericDao.getEntityByID(1);
        assertNotNull(retrievedUser);
        assertEquals(genericDao.getEntityByID(1), retrievedUser);
        logger.info("User Info: " + retrievedUser.toString());
    }

    @Test
    void updateUser() {
        String newFirstName = "Lily";
        User user = (User)genericDao.getEntityByID(1);
        user.setFirstName(newFirstName);
        user.setModifyDate(LocalDate.now());
        genericDao.updateEntity(user);
        User retrievedUser = (User)genericDao.getEntityByID(1);
        assertEquals(user, retrievedUser);
        logger.info("User Info: " + retrievedUser.toString());
    }

    @Test
    void deleteUser() {
        genericDao.deleteEntity(genericDao.getEntityByID(1));
        assertNull(genericDao.getEntityByID(1));
    }
}

