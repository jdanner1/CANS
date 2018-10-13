package com.danner.persistence;

import com.danner.entity.Vocalization;
import com.danner.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class VocalizationDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private VocalizationDao dao;
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        dao = new VocalizationDao();
        userDao = new UserDao();
        TestUserGenerator testUser = new TestUserGenerator();
        testUser.initializeUser();
    }

   @Test
    void addVocalization() {
        User user = userDao.getUserByID(1);
        String text = "This is a jUnit test for Vocalizations";
        String language = "en-US_AllisonVoice";
        boolean isEmailed = true;
        LocalDate createTimestamp = LocalDate.now();

        Vocalization vocalization = new Vocalization(user, text, language, isEmailed);

        int vocalizationID = dao.addVocalization(vocalization);
        assertNotEquals(0, vocalizationID);
        Vocalization addedVocalization = dao.getVocalizationByID(vocalizationID);
        assertEquals(vocalization, addedVocalization);
       logger.info("Vocalization Info: " + addedVocalization.toString());
    }



    @Test
    void getVocalizationByID() {
        Vocalization retrievedVocalization = dao.getVocalizationByID(1);
        assertNotNull(retrievedVocalization);
        assertEquals(dao.getVocalizationByID(1), retrievedVocalization);
        logger.info("Vocalization Info: " + retrievedVocalization.toString());
    }


    @Test
    void deleteVocalization() {
        dao.deleteVocalization(dao.getVocalizationByID(1));
        assertNull(dao.getVocalizationByID(1));
    }

}

