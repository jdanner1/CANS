package com.danner.controller;

import com.danner.entity.User;
import com.danner.entity.Vocalization;
import com.danner.utility.PropertiesLoader;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.Properties;

/**
 * The type Voice filer, generates audio files using IBM Watson API
 * @author jdanner/IBM
 */
public class VoiceFiler implements PropertiesLoader {

    /**
     * Generate voice file boolean.
     *
     * @param vocalization the vocalization
     * @param sessionId    the session id
     * @param relativePath the relative path
     * @return the boolean representing the success of emailing the file.
     */
    public boolean generateVoiceFile(Vocalization vocalization, String sessionId, String relativePath)  {
        final Logger logger = LogManager.getLogger(this.getClass());
        String propertyPath = "/properties.properties";
        TextToSpeech textToSpeech = new TextToSpeech();
        Boolean result = false;
        String outputFileSetting = "audio/wav";
        String fileSuffix = Integer.toString(vocalization.getVocalizationID());
        User user = vocalization.getUser();
        String email = user.getEmail();

        try {
            Properties properties = loadProperties(propertyPath);
            textToSpeech.setUsernameAndPassword(properties.getProperty("username"), properties.getProperty("password"));
            textToSpeech.setEndPoint(properties.getProperty("url"));

            SynthesizeOptions synthesizeOptions =
                    new SynthesizeOptions.Builder()
                            .text(vocalization.getText())
                            .accept(outputFileSetting)
                            .voice(vocalization.getLanguage())
                            .build();

            InputStream inputStream = textToSpeech.synthesize(synthesizeOptions).execute();
            InputStream in = WaveUtils.reWriteWaveHeader(inputStream);

            String path = relativePath + sessionId;
            File folder = new File(path);
            boolean exist=folder.exists();
            if(!exist){
                boolean isMade = folder.mkdirs();
                logger.info("Folders created? " + isMade);
            }else{
                logger.info("Your folder exists.");
            }

            String filepath = path + "/output" + fileSuffix + ".wav";

            OutputStream out = new FileOutputStream(filepath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.close();
            in.close();
            inputStream.close();
            SendEmail sender = new SendEmail();
            result = sender.sendEmail(filepath, email);
            deleteDirectory(path);
            deleteDirectory(path);
        } catch (IOException e) {
            logger.error("IO_Exceptioon: " , e);
        } catch (Exception exception) {
            logger.error("Exception: ", exception);
        }
        return result;
    }

    /**
     * Deletes files and directories
     * @param receivedPath
     */
    private void deleteDirectory(String receivedPath) {  // String path
        final Logger logger = LogManager.getLogger(this.getClass());
        File file  = new File(receivedPath);

        String keeper = "README.md";
        if (file.isDirectory()) {
            String[] childFiles = file.list();
            if (childFiles.length == 0) {
                //Directory is empty. Proceed for deletion
                boolean isDeleted = file.delete();
                logger.info("Directory " + file.getName() + " deleted? " + isDeleted);
            } else {
                //Directory has other files.
                //Need to delete them first
                for (String itemInFolder : childFiles) {
                    //recursive delete the files
                    logger.info("Item in Directory: " + itemInFolder);
                    File tester = new File(receivedPath + "/" + itemInFolder);
                    String fullPath = tester.getAbsolutePath();
                    logger.info("fullPath: " + fullPath);
                    deleteDirectory(fullPath);
                }
            }
        } else {
            //it is a simple file. Proceed for deletion
            if (!(keeper.equals(file.getName()))) { //
                logger.info("About to delete file!!");
                logger.info("The file: " + file.getName());
                boolean isDeleted = file.delete();
                logger.info("File deleted? " + isDeleted);
            }
        }
    }
}

