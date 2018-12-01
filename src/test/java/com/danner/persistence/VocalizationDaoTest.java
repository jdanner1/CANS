package com.danner.persistence;

import com.danner.entity.Vocalization;
import com.danner.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class VocalizationDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao genericDao;
    private GenericDao genericDao2;

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(Vocalization.class);
        genericDao2 = new GenericDao(User.class);
        TestUserGenerator testUser = new TestUserGenerator();
        testUser.initializeUser();
    }

   @Test
    void addVocalization() {
        User user = (User)genericDao2.getEntityByID(1);
        String text = "This is a jUnit test for Vocalizations";
        String language = "en-US_AllisonVoice";
        boolean isEmailed = true;
        LocalDate createTimestamp = LocalDate.now();

        Vocalization vocalization = new Vocalization(user, text, language, isEmailed);

        int vocalizationID = genericDao.addEntity(vocalization);
        assertNotEquals(0, vocalizationID);
        Vocalization addedVocalization = (Vocalization)genericDao.getEntityByID(vocalizationID);
        assertEquals(vocalization, addedVocalization);
        logger.info("Vocalization Info: " + addedVocalization.toString());
    }



    @Test
    void getVocalizationByID() {
        Vocalization retrievedVocalization = (Vocalization)genericDao.getEntityByID(1);
        assertNotNull(retrievedVocalization);
        assertEquals(genericDao.getEntityByID(1), retrievedVocalization);
        logger.info("Vocalization Info: " + retrievedVocalization.toString());
    }


    @Test
    void deleteVocalization() {
        genericDao.deleteEntity(genericDao.getEntityByID(1));
        assertNull(genericDao.getEntityByID(1));
    }

    @Test
    void getAll() {

        List<Vocalization> allVocalizations = genericDao.getAll();
        logger.info(allVocalizations);
    }
}

