package com.epam.tc.hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class MulDataProvider {
    @DataProvider
    public static Object[][] mulData() {
        return new Object[][] {
            {1, 2, 2},
            {1, -2, -2},
            {-100000000000L, 0, 0}
        };
    }

    @DataProvider
    public static Object[][] mulOverflowData() {
        return new Object[][] {
            {Long.MAX_VALUE, 2},
            {Long.MAX_VALUE, -2},
            {Long.MIN_VALUE, 2},
            {Long.MIN_VALUE, -2}
        };
    }

    @DataProvider
    public static Object[][] mulCommutativityData() {
        return new Object[][] {
            {125, 789},
            {-125, 789},
            {-125, 0},
        };
    }

    @DataProvider
    public static Object[][] mulAssociativityData() {
        return new Object[][] {
            {234, 9387, 29},
            {-234, 9387, 29},
            {234, -9387, -29},
            {-234, -9387, -29},
            {234, 0, 29}
        };
    }
}
