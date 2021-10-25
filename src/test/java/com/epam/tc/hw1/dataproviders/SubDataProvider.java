package com.epam.tc.hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class SubDataProvider {
    @DataProvider
    public static Object[][] subData() {
        return new Object[][] {
            {1, 2, -1},
            {1, -2, 3},
            {-100000000000L, 0, -100000000000L},
            {Long.MAX_VALUE, 1, Long.MAX_VALUE - 1},
            {Long.MIN_VALUE + 1, 1, Long.MIN_VALUE}
        };
    }

    @DataProvider
    public static Object[][] subOverflowData() {
        return new Object[][] {
            {Long.MAX_VALUE, -1},
            {Long.MIN_VALUE, 1}
        };
    }
}
