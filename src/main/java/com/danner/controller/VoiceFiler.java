package com.danner.controller;

import com.danner.entity.Vocalization;
import com.danner.utility.PropertiesLoader;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.util.Properties;

public class VoiceFiler implements PropertiesLoader {

    private String FILE_PATH = "/properties.properties";
    private final Logger logger = LogManager.getLogger(this.getClass());

    public void generateVoiceFile(Vocalization vocalization, String sessionId, HttpServletRequest request, String relativePath)  {
        TextToSpeech textToSpeech = new TextToSpeech();
        String OUTPUT_FILE_SETTING = "audio/wav";
        String catalinaHome = request.getContextPath();

        try {
            Properties properties = loadProperties(FILE_PATH);
            textToSpeech.setUsernameAndPassword(properties.getProperty("username"), properties.getProperty("password"));
            textToSpeech.setEndPoint(properties.getProperty("url"));

            SynthesizeOptions synthesizeOptions =
                    new SynthesizeOptions.Builder()
                            .text(vocalization.getText())
                            .accept(OUTPUT_FILE_SETTING)
                            .voice(vocalization.getLanguage())
                            .build();

            InputStream inputStream = textToSpeech.synthesize(synthesizeOptions).execute();
            InputStream in = WaveUtils.reWriteWaveHeader(inputStream);

            String path = relativePath + sessionId;
            File folder=new File(path);
            boolean exist=folder.exists();
            if(!exist){
                folder.mkdirs();
            }else{
                logger.info("Your folder exists.");
            }

            String filepath = path + "/output.wav";

            OutputStream out = new FileOutputStream(filepath);
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
        } catch (Exception exception) {
            logger.error("Exception: ", exception);
        }
    }
}

