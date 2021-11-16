package com.epam.tc.hw5.cucumber.step.exercise3;

import com.epam.tc.hw5.cucumber.step.common.AbstractBaseStep;
import io.cucumber.java.en.When;

public class Exercise3Step extends AbstractBaseStep {

    @When("I select 'vip' checkbox for \"Sergey Ivan\" on User Table Page")
    public void selectVipCheckboxForOnUserTablePage() {
        userTablePage.ivan().clickCheckbox();
    }
}
