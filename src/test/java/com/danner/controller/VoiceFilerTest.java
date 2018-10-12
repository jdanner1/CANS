package com.danner.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoiceFilerTest {
    @Test
    void generateVoiceFile() {
        VoiceFiler voiceFiler = new VoiceFiler();
        voiceFiler.generateVoiceFile();

    }

}