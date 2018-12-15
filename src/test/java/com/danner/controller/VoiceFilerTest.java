package com.danner.controller;

import com.danner.entity.Vocalization;
import com.danner.persistence.GenericDao;
import com.danner.persistence.TestUserGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VoiceFilerTest {

    private GenericDao genericDao;
    private Vocalization vocalization;

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(Vocalization.class);
        TestUserGenerator testUser = new TestUserGenerator();
        testUser.initializeUser();
        vocalization = (Vocalization)genericDao.getEntityByID(1);
    }

    @Test
    void generateVoiceFile() {
        String sessionId = "TestSessionId";
        VoiceFiler voiceFiler = new VoiceFiler();
        String relativePath = "/home/student/IdeaProjects/individualproject/target/individualproject/audio-files";
        boolean result = voiceFiler.generateVoiceFile(vocalization, sessionId, relativePath);
        assertEquals(true, result);
    }
}