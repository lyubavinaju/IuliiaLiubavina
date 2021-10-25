package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.epam.tc.hw1.dataproviders.DivDataProvider;
import org.testng.annotations.Test;

public class CalculatorDivideTest extends CalculatorBaseTest {

    @Test(dataProvider = "divData", dataProviderClass = DivDataProvider.class)
    public void divTest(long a, long b, long expected) {
        long div = calculator.div(a, b);
        assertThat(div).isEqualTo(expected);
    }

    @Test(dataProvider = "divByZeroData", dataProviderClass = DivDataProvider.class)
    public void divByZeroTest(long a, long b) {
        assertThatThrownBy(() -> calculator.div(a, b)).hasMessageContaining("divide by zero");
    }
}
