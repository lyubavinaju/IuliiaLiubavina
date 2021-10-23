package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import com.epam.tc.hw1.dataproviders.SubDataProvider;
import org.testng.annotations.Test;

public class CalculatorSubtractTest extends CalculatorBaseTest {
    @Test(dataProvider = "subData", dataProviderClass = SubDataProvider.class)
    public void subLongsTest(long a, long b, long expected) {
        long sub = calculator.sub(a, b);
        assertThat(sub).isEqualTo(expected);
    }

    @Test(dataProvider = "subOverflowData", dataProviderClass = SubDataProvider.class)
    public void subLongsOverflowTest(long a, long b) {
        assertThatCode(() -> calculator.sub(a, b)).doesNotThrowAnyException();
    }
}
