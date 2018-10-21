package com.danner.controller;

import com.danner.entity.User;
import com.danner.entity.Vocalization;
import com.danner.persistence.GenericDao;
import com.danner.persistence.TestUserGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoiceFilerTest {/*
    private final Logger logger = LogManager.getLogger(this.getClass());
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
        VoiceFiler voiceFiler = new VoiceFiler();
        voiceFiler.generateVoiceFile(vocalization);

    } */
}