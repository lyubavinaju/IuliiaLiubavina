package com.epam.tc.hw4.tests.ex2;

import com.epam.tc.hw4.dataprovider.Exercise2Data;
import com.epam.tc.hw4.pages.diffelements.DifferentElementsPage;
import com.epam.tc.hw4.tests.AbstractExerciseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


@Features({@Feature("Home page"), @Feature("Different elements page")})
@Story("Exercise2")
public class Exercise2Test extends AbstractExerciseTest {

    @Step("5. Open through the header menu Service -> Different Elements Page")
    private DifferentElementsPage openDifferentElementsPage(String differentElementsPageTitle) {
        DifferentElementsPage differentElementsPage =
                homePage.header().openService().differentElementsPage();
        wait.until(ExpectedConditions.titleIs(differentElementsPageTitle));
        return differentElementsPage;
    }

    @Step("6. Select checkboxes")
    private void selectCheckboxes(DifferentElementsPage page, List<String> checkboxesExpected) {
        List<WebElement> checkboxes = new ArrayList<>();
        checkboxesExpected.forEach(text -> {
            page.findCheckBox(text).ifPresent(checkboxes::add);
        });
        softAssertions.assertThat(checkboxes).hasSize(checkboxesExpected.size());
        checkboxes.forEach(WebElement::click);
        checkboxes.forEach(element -> softAssertions.assertThat(element.isSelected()).isTrue());
    }

    @Step("7. Select radio")
    private void selectRadio(DifferentElementsPage page, String radioExpected) {
        Optional<WebElement> radio = page.findRadio(radioExpected);
        softAssertions.assertThat(radio).isPresent();
        radio.ifPresent(WebElement::click);
        radio.ifPresent(r -> softAssertions.assertThat(r.isSelected()).isTrue());
    }

    @Step("8. Select in dropdown")
    private void selectInDropDown(DifferentElementsPage page, String colorExpected) {
        page.selectColor(colorExpected);
        softAssertions.assertThat(page.selectedColor().orElse(null))
                .isEqualTo(colorExpected);
    }

    @Step("9. Assert that conditions are true")
    private void checkLogs(DifferentElementsPage page, List<String> checkboxesExpected, String checkboxLogPattern,
                           String radioLogPattern, String colorLogPattern,
                           String radioExpected, String colorExpected) {

        List<WebElement> logs = page.logs();
        checkCheckboxesLogs(checkboxesExpected, logs, checkboxLogPattern);
        checkRadioLogs(radioExpected, logs, radioLogPattern);
        checkColorLogs(colorExpected, logs, colorLogPattern);
    }

    @Step("9.1. for each checkbox there is an individual log row and value is corresponded to the status of checkbox")
    private void checkCheckboxesLogs(List<String> checkboxesExpected,
                                     List<WebElement> logs, String checkboxLogPattern) {
        checkboxesExpected.forEach(c -> {
            List<WebElement> checkboxLog = logs.stream().filter(log ->
                    log.getText().contains(String.format(checkboxLogPattern, c))).collect(Collectors.toList());
            softAssertions.assertThat(checkboxLog).hasSize(1);
        });
    }

    @Step("9.2. for radio button there is a log row and value is corresponded to the status of radio button")
    private void checkRadioLogs(String radioExpected, List<WebElement> logs, String radioLogPattern) {
        List<WebElement> radioLog = logs.stream().filter(log ->
                log.getText().contains(String.format(radioLogPattern, radioExpected))).collect(Collectors.toList());
        softAssertions.assertThat(radioLog).hasSize(1);
    }

    @Step("9.3. for dropdown there is a log row and value is corresponded to the selected value")
    private void checkColorLogs(String colorExpected, List<WebElement> logs, String colorLogPattern) {
        List<WebElement> colorLog = logs.stream().filter(log ->
                log.getText().contains(String.format(colorLogPattern, colorExpected))).collect(Collectors.toList());
        softAssertions.assertThat(colorLog).hasSize(1);
    }

    @Test(dataProvider = "exercise2Data", dataProviderClass = Exercise2Data.class)
    void exercise2Test(String name, String password, String username,
                       String homePageTitle, String differentElementsPageTitle,
                       List<String> checkboxesExpected, String radioExpected, String colorExpected,
                       String checkboxLogPattern, String radioLogPattern, String colorLogPattern) {

        checkTitle(homePageTitle);
        performLogin(name, password);
        checkUsername(username);

        DifferentElementsPage differentElementsPage = openDifferentElementsPage(differentElementsPageTitle);

        selectCheckboxes(differentElementsPage, checkboxesExpected);
        selectRadio(differentElementsPage, radioExpected);
        selectInDropDown(differentElementsPage, colorExpected);

        checkLogs(differentElementsPage, checkboxesExpected, checkboxLogPattern, radioLogPattern, colorLogPattern,
                radioExpected, colorExpected);

        softAssertions.assertAll();
    }
}
