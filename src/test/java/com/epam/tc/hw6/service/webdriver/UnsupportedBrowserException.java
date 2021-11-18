package com.epam.tc.hw6.service.webdriver;

import java.util.Arrays;
import java.util.stream.Collectors;

public class UnsupportedBrowserException extends RuntimeException {
    private static final String MESSAGE = "Available browsers: " + Arrays.stream(Browser.values())
                                                                         .map(Enum::name)
                                                                         .collect(Collectors.joining("\n"));

    public UnsupportedBrowserException() {
        super(MESSAGE);
    }
}
