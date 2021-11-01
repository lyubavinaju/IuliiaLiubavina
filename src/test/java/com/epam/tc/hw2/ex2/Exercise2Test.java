package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.AbstractExerciseTest;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exercise2Test extends AbstractExerciseTest {
    @DataProvider
    public static Object[][] exercise2Data() {
        return new Object[][] {
            {"Home Page", Map.of("name", "Roman", "pass", "Jdi1234"),
                "ROMAN IOVLEV", List.of("Water", "Wind"), "Selen", "Yellow"
            }
        };
    }

    @Test(dataProvider = "exercise2Data")
    void exercise2Test(String title, Map<String, String> credentials, String userName, List<String> checkbox,
                       String radio, String dropdown) {
        //1, 2, 3, 4. open site and login
        exercisesCommonStart(title, credentials, userName);

        //5. Open through the header menu Service -> Different Elements Page
        By serviceLocator =
            By.xpath("//*[contains(@class, 'dropdown-toggle') and contains(normalize-space(.), 'Service')]");
        By differentElementsLocator =
            By.xpath("//*[contains(@class, 'dropdown-menu')]/li/a[contains(normalize-space(.), 'Different elements')]");
        softAssertions.assertThatCode(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(serviceLocator));
            driver.findElement(serviceLocator).click();
            wait.until(ExpectedConditions.elementToBeClickable(differentElementsLocator));
            driver.findElement(differentElementsLocator).click();
            wait.until(ExpectedConditions.titleIs("Different Elements"));
        }).doesNotThrowAnyException();

        //6. Select checkboxes
        String checkboxXPath = "//*[contains(@class, 'label-checkbox') "
            + "and (contains(normalize-space(.), '%s') or contains(normalize-space(.), '%s'))]"
            + "/input[@type='checkbox']";
        By checkBoxLocator =
            By.xpath(String.format(checkboxXPath, checkbox.get(0), checkbox.get(1)));
        softAssertions.assertThatCode(() -> {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(checkBoxLocator));
        }).doesNotThrowAnyException();
        List<WebElement> checkboxWebElements = driver.findElements(checkBoxLocator);
        softAssertions.assertThat(checkboxWebElements).hasSize(checkbox.size());
        checkboxWebElements.forEach(WebElement::click);
        checkboxWebElements.forEach(element -> softAssertions.assertThat(element.isSelected()).isTrue());

        //7. Select radio
        By radioValueLocator =
            By.xpath("//*[contains(@class, 'label-radio') and contains(normalize-space(.), '" + radio
                + "')]/input[@type='radio']");
        softAssertions.assertThatCode(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(radioValueLocator));
            driver.findElement(radioValueLocator).click();
        }).doesNotThrowAnyException();
        List<WebElement> radioWebElements = driver.findElements(radioValueLocator);
        softAssertions.assertThat(radioWebElements).hasSize(1);
        radioWebElements.forEach(element -> softAssertions.assertThat(element.isSelected()).isTrue());

        //8. Select in dropdown
        By colorsLocator = By.cssSelector(".colors .uui-form-element");
        softAssertions.assertThatCode(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(colorsLocator));
            driver.findElement(colorsLocator).click();
        }).doesNotThrowAnyException();
        By dropdownValueLocator =
            By.xpath(
                "//*[contains(@class, 'colors')]/*[@class='uui-form-element']/*[contains(normalize-space(.), '"
                    + dropdown + "')]");
        softAssertions.assertThatCode(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(dropdownValueLocator));
            driver.findElement(dropdownValueLocator).click();
            softAssertions.assertThat(dropdown)
                          .isEqualTo(new Select(driver.findElement(colorsLocator)).getFirstSelectedOption().getText());
        }).doesNotThrowAnyException();

        //9. Assert that
        // 1) for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // 2) for radio button there is a log row and value is corresponded to the status of radio button
        // 3) for dropdown there is a log row and value is corresponded to the selected value.
        List<By> logLocators =
            List.of(
                By.xpath("//*[contains(@class, 'logs')]//li[contains(normalize-space(.), '" + checkbox.get(0)
                    + ": condition changed to true')]"),
                By.xpath("//*[contains(@class, 'logs')]//li[contains(normalize-space(.), '" + checkbox.get(1)
                    + ": condition changed to true')]"),
                By.xpath(
                    "//*[contains(@class, 'logs')]//li[contains(normalize-space(.), 'metal: value changed to " + radio
                        + "')]"),
                By.xpath(
                    "//*[contains(@class, 'logs')]//li[contains(normalize-space(.), 'Colors: value changed to "
                        + dropdown + "')]"));
        for (By logLocator : logLocators) {
            softAssertions.assertThatCode(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(logLocator)))
                          .doesNotThrowAnyException();
        }

        //10. Close Browser
        driver.close();

        softAssertions.assertAll();
    }
}
