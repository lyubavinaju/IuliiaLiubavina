package com.epam.tc.hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class AddDataProvider {
    @DataProvider
    public static Object[][] addData() {
        return new Object[][] {
            {1, 2, 3},
            {1, -2, -1},
            {-100000000000L, 0, -100000000000L},
            {Long.MAX_VALUE - 1, 1, Long.MAX_VALUE},
            {Long.MIN_VALUE + 1, -1, Long.MIN_VALUE}
        };
    }

    @DataProvider
    public static Object[][] addOverflowData() {
        return new Object[][] {
            {Long.MAX_VALUE, 1},
            {Long.MIN_VALUE, -1}
        };
    }

    @DataProvider
    public static Object[][] addCommutativityData() {
        return new Object[][] {
            {125, 789},
            {-125, 789},
            {-125, 0},
        };
    }

    @DataProvider
    public static Object[][] addAssociativityData() {
        return new Object[][] {
            {234, 9387, 29},
            {-234, 9387, 29},
            {234, -9387, -29},
            {-234, -9387, -29},
            {234, 0, 29}
        };
    }
}
