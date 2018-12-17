package com.danner.utility;

import java.io.*;
import java.util.*;


/**
 * The interface Properties loader.
 */
public interface PropertiesLoader  {


    /**
     * This default method will load a properties file into a Properties instance
     * and return it.
     *
     * @param propertiesFilePath a path to a file on the java classpath list
     * @return a populated Properties instance or an empty Properties instance if the file path was not found.
     * @throws IOException the io exception
     * @throws Exception   the exception
     */
    default Properties loadProperties(String propertiesFilePath) throws IOException, Exception {
        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        return properties;
    }
}
