package com.epam.tc.hw5.cucumber.step.common;

import io.cucumber.java.en.Then;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;

public class CommonAssertionStep extends AbstractBaseStep {

    @Then("{string} page should be opened")
    public void pageShouldBeOpened(String pageName) {
        Assertions.assertThat(basePage.title()).isEqualTo(pageName);
    }

    @Then("{int} log row has {string} text in log section on {string} Page")
    public void logRowHasTextInLogSection(int logCount, String logText, String pageName) {
        List<WebElement> checkboxLog = log.items().stream().filter(log ->
            log.getText().contains(logText)).collect(Collectors.toList());
        Assertions.assertThat(checkboxLog).hasSize(logCount);
    }
}
