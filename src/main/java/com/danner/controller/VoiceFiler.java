package com.danner.controller;

import com.danner.utility.PropertiesLoader;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class VoiceFiler implements PropertiesLoader {

    String FILE_PATH = "/properties.properties";
    private final Logger logger = LogManager.getLogger(this.getClass());
    private Properties properties = loadProperties(FILE_PATH);

    public void generateVoiceFile()  {
        TextToSpeech textToSpeech = new TextToSpeech();
        textToSpeech.setUsernameAndPassword(properties.getProperty("username"), properties.getProperty("password"));
        textToSpeech.setEndPoint(properties.getProperty("url"));

        try {
            SynthesizeOptions synthesizeOptions =
                    new SynthesizeOptions.Builder()
                            .text("John Danner is awesome")
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
