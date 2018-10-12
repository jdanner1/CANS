package com.danner.controller;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class VoiceFiler {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public void generateVoiceFile()  {
        TextToSpeech textToSpeech = new TextToSpeech();
        textToSpeech.setUsernameAndPassword("b2eb6ae5-6f7f-4ed6-84d5-88fce3a25c55", "rQqQmgXXM6t4");
        textToSpeech.setEndPoint("https://stream.watsonplatform.net/text-to-speech/api");

        try {
            SynthesizeOptions synthesizeOptions =
                    new SynthesizeOptions.Builder()
                            .text("Hello world")
                            .accept("audio/wav")
                            .voice("en-US_AllisonVoice")
                            .build();

            InputStream inputStream = textToSpeech.synthesize(synthesizeOptions).execute();
            InputStream in = WaveUtils.reWriteWaveHeader(inputStream);

            OutputStream out = new FileOutputStream("/home/student/IdeaProjects/individualproject/src/main/resources/hello_world.wav");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.close();
            in.close();
            inputStream.close();
        } catch (IOException e) {
            logger.error("IO_Exceptioon: " , e);
        }

    }

}
