package com.crew.operation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    private Properties properties = new Properties();

    public String readProperty(String property) {
        try (FileInputStream stream = new FileInputStream("src/main/resources/application.properties")) {
            properties.load(stream);
            return properties.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
