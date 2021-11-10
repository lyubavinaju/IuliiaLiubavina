package com.epam.tc.hw3.dataprovider;

import java.util.List;
import java.util.Properties;
import org.testng.annotations.DataProvider;

public class Exercise2Data extends Data {
    private static final String DIFFERENT_ELEMENTS_PAGE = "Different Elements";
    private static final List<String> CHECKBOX_VALUES = List.of("Water", "Wind");
    private static final String RADIO_VALUE = "Selen";
    private static final String COLOR_VALUE = "Yellow";
    private static final String CHECKBOX_LOG_PATTERN = "%s: condition changed to true";
    private static final String RADIO_LOG_PATTERN = "metal: value changed to %s";
    private static final String COLOR_LOG_PATTERN = "Colors: value changed to %s";

    @DataProvider
    public static Object[][] exercise2Data() {
        Properties properties = readUserProperties();
        return new Object[][] {
            {properties.getProperty("name"),
                properties.getProperty("pass"),
                properties.getProperty("username"),
                HOME_PAGE, DIFFERENT_ELEMENTS_PAGE,
                CHECKBOX_VALUES, RADIO_VALUE, COLOR_VALUE,
                CHECKBOX_LOG_PATTERN, RADIO_LOG_PATTERN, COLOR_LOG_PATTERN
            }
        };
    }
}
