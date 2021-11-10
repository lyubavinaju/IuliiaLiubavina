package com.epam.tc.hw3.dataprovider;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Properties;

public class Data {
    private static final String USER_PROPERTIES_FILE = "com/epam/tc/hw3/user/user.properties";
    protected static final String HOME_PAGE = "Home Page";

    protected static Properties readUserProperties() {
        Properties properties = new Properties();
        InputStream inputStream = Data.class.getClassLoader().getResourceAsStream(USER_PROPERTIES_FILE);
        try {
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
