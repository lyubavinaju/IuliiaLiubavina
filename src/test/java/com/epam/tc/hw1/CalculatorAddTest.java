package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import com.epam.tc.hw1.dataproviders.AddDataProvider;
import org.testng.annotations.Test;

public class CalculatorAddTest extends CalculatorBaseTest {

    @Test(dataProvider = "addData", dataProviderClass = AddDataProvider.class)
    public void addLongsTest(long a, long b, long expected) {
        long sum = calculator.sum(a, b);
        assertThat(sum).isEqualTo(expected);
    }

    @Test(dataProvider = "addOverflowData", dataProviderClass = AddDataProvider.class)
    public void addLongsOverflowTest(long a, long b) {
        assertThatCode(() -> calculator.sum(a, b)).doesNotThrowAnyException();
    }

    @Test(dataProvider = "addCommutativityData", dataProviderClass = AddDataProvider.class)
    public void addCommutativityTest(long a, long b) {
        long ab = calculator.sum(a, b);
        long ba = calculator.sum(b, a);
        assertThat(ab).isEqualTo(ba);
    }

    @Test(dataProvider = "addAssociativityData", dataProviderClass = AddDataProvider.class)
    public void addAssociativityTest(long a, long b, long c) {
        long ab = calculator.sum(a, b);
        long abc1 = calculator.sum(ab, c);
        long bc = calculator.sum(b, c);
        long abc2 = calculator.sum(a, bc);
        assertThat(abc1).isEqualTo(abc2);
    }
}
