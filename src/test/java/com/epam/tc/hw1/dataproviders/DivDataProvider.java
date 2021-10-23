package com.epam.tc.hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class DivDataProvider {
    @DataProvider
    public static Object[][] divData() {
        return new Object[][] {
            {10, 2, 5},
            {10, -2, -5},
            {10, -3, -3},
            {0, -3, 0},
        };
    }

    @DataProvider
    public static Object[][] divByZeroData() {
        return new Object[][] {
            {1, 0},
            {-1, 0},
            {0, 0}
        };
    }
}
