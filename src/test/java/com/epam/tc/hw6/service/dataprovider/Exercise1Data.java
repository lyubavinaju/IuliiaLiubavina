package com.epam.tc.hw6.service.dataprovider;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import org.testng.annotations.DataProvider;

public class Exercise1Data extends Data {
    private static final String[] HEADER_ITEMS = new String[] {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
    private static final String[] LEFT_MENU_ITEMS =
        new String[] {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
    private static final int IMAGES_COUNT = 4;
    private static final String[] TEXTS_UNDER_IMAGES = new String[] {
        List.of("To include good practices", "and ideas from successful", "EPAM project").stream().collect(
            Collectors.joining(System.lineSeparator())),
        List.of("To be flexible and", "customizable").stream()
            .collect(Collectors.joining(System.lineSeparator())),
        List.of("To be multiplatform").stream().collect(Collectors.joining(System.lineSeparator())),
        List.of("Already have good base", "(about 20 internal and", "some external projects),",
            "wish to get more…").stream().collect(Collectors.joining(System.lineSeparator()))
    };

    @DataProvider
    public static Object[][] exercise1Data() {
        Properties properties = readUserProperties();
        return new Object[][] {
            {properties.getProperty("name"),
                properties.getProperty("pass"),
                properties.getProperty("username"),
                HOME_PAGE,
                HEADER_ITEMS,
                IMAGES_COUNT,
                TEXTS_UNDER_IMAGES,
                LEFT_MENU_ITEMS
            }
        };
    }
}
