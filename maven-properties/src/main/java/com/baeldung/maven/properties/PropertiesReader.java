package com.baeldung.maven.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Reads properties from one file.
 * 
 * @author Donato Rimenti
 */
public class PropertiesReader {

    /**
     * Properties managed by this reader.
     */
    private Properties properties;

    /**
     * Reads the property file with the given name.
     * 
     * @param propertyFileName the name of the property file to read
     * @throws IOException if the file is not found or there's a problem reading it
     */
    public PropertiesReader(String propertyFileName) throws IOException {
        InputStream is = getClass().getClassLoader()
            .getResourceAsStream(propertyFileName);
        this.properties = new Properties();
        this.properties.load(is);
        String dir =this.properties.getProperty("basedir");
        try (InputStream input = new FileInputStream(dir+"/roleid.txt")) {

            Properties prop = new Properties();
            prop.load(input);
            System.out.println(prop.getProperty("roleid"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("got the file");
    }

    /**
     * Gets the property with the given name from the property file.
     * @param propertyName the name of the property to read
     * @return the property with the given name
     */
    public String getProperty(String propertyName) {
        return this.properties.getProperty(propertyName);
    }

}