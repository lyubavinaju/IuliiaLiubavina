package com.epam.tc.hw5.cucumber.step.common;

import com.epam.tc.hw5.cucumber.context.Data;
import com.epam.tc.hw5.cucumber.context.Data.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStep extends AbstractBaseStep {

    @Given("I open JDI GitHub site")
    public void openJdiGitHubSite() {
        homePage.open();
    }

    @When("I login as user {string}")
    public void loginAsUser(String username) {
        User user = Data.getInstance().getUser(username);
        header.openLoginMenu().login(user.getLogin(), user.getPassword());
    }

    @When("I click on \"Service\" button in Header")
    public void clickOnServiceButtonInHeader() {
        header.openService();
    }

    @When("I click on {string} button in Service dropdown")
    public void clickOnButtonInServiceDropdown(String page) {
        header.clickToPage(page);
    }
}
