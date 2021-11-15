package com.epam.tc.hw3.tests.ex2;

import com.epam.tc.hw3.dataprovider.Exercise2Data;
import com.epam.tc.hw3.pages.diffelements.DifferentElementsPage;
import com.epam.tc.hw3.tests.AbstractExerciseTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Exercise2Test extends AbstractExerciseTest {

    @Test(dataProvider = "exercise2Data", dataProviderClass = Exercise2Data.class)
    void exercise2Test(String name, String password, String userName,
                       String homePageTitle, String differentElementsPageTitle,
                       List<String> checkboxesExpected, String radioExpected, String colorExpected,
                       String checkboxLogPattern, String radioLogPattern, String colorLogPattern) {
        //1, 2, 3, 4. open site and login
        exercisesCommonStart(homePageTitle, name, password, userName);

        //5. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage =
            homePage.header().openService().differentElementsPage();
        softAssertions.assertThatCode(() -> wait.until(ExpectedConditions.titleIs(differentElementsPageTitle)))
                      .doesNotThrowAnyException();

        //6. Select checkboxes
        List<WebElement> checkboxes = new ArrayList<>();
        checkboxesExpected.forEach(text -> {
            differentElementsPage.findCheckBox(text).ifPresent(checkboxes::add);
        });
        softAssertions.assertThat(checkboxes).hasSize(checkboxesExpected.size());
        checkboxes.forEach(WebElement::click);
        checkboxes.forEach(element -> softAssertions.assertThat(element.isSelected()).isTrue());

        //7. Select radio
        Optional<WebElement> radio = differentElementsPage.findRadio(radioExpected);
        softAssertions.assertThat(radio).isPresent();
        radio.ifPresent(WebElement::click);
        radio.ifPresent(r -> softAssertions.assertThat(r.isSelected()).isTrue());

        //8. Select in dropdown
        differentElementsPage.selectColor(colorExpected);
        softAssertions.assertThat(differentElementsPage.selectedColor().orElse(null))
                      .isEqualTo(colorExpected);

        //9. Assert that
        // 1) for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // 2) for radio button there is a log row and value is corresponded to the status of radio button
        // 3) for dropdown there is a log row and value is corresponded to the selected value.

        List<WebElement> logs = differentElementsPage.logs();
        checkboxesExpected.forEach(c -> {
            List<WebElement> checkboxLog = logs.stream().filter(log ->
                log.getText().contains(String.format(checkboxLogPattern, c))).collect(Collectors.toList());
            softAssertions.assertThat(checkboxLog).hasSize(1);
        });

        List<WebElement> radioLog = logs.stream().filter(log ->
            log.getText().contains(String.format(radioLogPattern, radioExpected))).collect(Collectors.toList());
        softAssertions.assertThat(radioLog).hasSize(1);

        List<WebElement> colorLog = logs.stream().filter(log ->
            log.getText().contains(String.format(colorLogPattern, colorExpected))).collect(Collectors.toList());
        softAssertions.assertThat(colorLog).hasSize(1);
        softAssertions.assertAll();
    }
}
