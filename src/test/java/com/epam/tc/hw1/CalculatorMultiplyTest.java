package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import com.epam.tc.hw1.dataproviders.AddDataProvider;
import com.epam.tc.hw1.dataproviders.MulDataProvider;
import org.testng.annotations.Test;

public class CalculatorMultiplyTest extends CalculatorBaseTest {

    @Test(dataProvider = "mulData", dataProviderClass = MulDataProvider.class)
    public void mulLongsTest(long a, long b, long expected) {
        long mult = calculator.mult(a, b);
        assertThat(mult).isEqualTo(expected);
    }

    @Test(dataProvider = "mulOverflowData", dataProviderClass = MulDataProvider.class)
    public void mulLongsOverflowTest(long a, long b) {
        assertThatCode(() -> calculator.mult(a, b)).doesNotThrowAnyException();
    }

    @Test(dataProvider = "addCommutativityData", dataProviderClass = AddDataProvider.class)
    public void addCommutativityTest(long a, long b) {
        long ab = calculator.mult(a, b);
        long ba = calculator.mult(b, a);
        assertThat(ab).isEqualTo(ba);
    }

    @Test(dataProvider = "addAssociativityData", dataProviderClass = AddDataProvider.class)
    public void addAssociativityTest(long a, long b, long c) {
        long ab = calculator.mult(a, b);
        long abc1 = calculator.mult(ab, c);
        long bc = calculator.mult(b, c);
        long abc2 = calculator.mult(a, bc);
        assertThat(abc1).isEqualTo(abc2);
    }
}
