package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.AbstractExerciseTest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exercise1Test extends AbstractExerciseTest {

    @DataProvider
    public static Object[][] exercise1Data() {
        return new Object[][] {
            {"Home Page", Map.of("name", "Roman", "pass", "Jdi1234"),
                "ROMAN IOVLEV",
                List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"),
                List.of(
                    List.of("To include good practices", "and ideas from successful", "EPAM project").stream().collect(
                        Collectors.joining(System.lineSeparator())),
                    List.of("To be flexible and", "customizable").stream()
                        .collect(Collectors.joining(System.lineSeparator())),
                    List.of("To be multiplatform").stream().collect(Collectors.joining(System.lineSeparator())),
                    List.of("Already have good base", "(about 20 internal and", "some external projects),",
                        "wish to get more…").stream().collect(Collectors.joining(System.lineSeparator()))
                ),
                List.of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs")
            }
        };
    }

    @Test(dataProvider = "exercise1Data")
    void exercise1Test(String title, Map<String, String> credentials, String userName,
                       List<String> headerMenuItemsText, List<String> underImagesText,
                       List<String> sideBarMenuLeftItemsText) {
        //1, 2, 3, 4. open site and login
        exercisesCommonStart(title, credentials, userName);

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        By headerMenuItemsLocator = By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li > a");
        softAssertions.assertThatCode(() -> {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(headerMenuItemsLocator));
        }).doesNotThrowAnyException();
        List<String> headerMenuItems =
            driver.findElements(headerMenuItemsLocator).stream().map(WebElement::getText).collect(
                Collectors.toList());
        softAssertions.assertThat(headerMenuItems).isEqualTo(headerMenuItemsText);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        By imgLocator = By.className("icons-benefit");
        softAssertions.assertThatCode(() -> {
            wait.until(driver -> ExpectedConditions.visibilityOfAllElementsLocatedBy(imgLocator));
        }).doesNotThrowAnyException();
        List<WebElement> images = driver.findElements(imgLocator);
        softAssertions.assertThat(images).hasSize(4);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        By textUnderImgLocator =
            By.xpath(
                "//*[contains(@class, 'icons-benefit')]/../following-sibling::*[contains(@class, 'benefit-txt')]");
        softAssertions.assertThatCode(() -> {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(textUnderImgLocator));
        }).doesNotThrowAnyException();
        List<String> texts = driver.findElements(textUnderImgLocator).stream().map(WebElement::getText).collect(
            Collectors.toList());
        softAssertions.assertThat(texts).isEqualTo(underImagesText);

        //8. Assert that there is the iframe with “Frame Button” exist
        By iframeLocator = By.id("frame");
        softAssertions.assertThatCode(() -> {
            wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLocator));
        }).doesNotThrowAnyException();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssertions.assertThatCode(() -> {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[value='Frame Button']")));
        }).doesNotThrowAnyException();

        //10. Switch to original window back
        softAssertions.assertThatCode(() -> {
            driver.switchTo().defaultContent();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frame")));
        }).doesNotThrowAnyException();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        By sideBarMenuLeftLocator = By.cssSelector(".sidebar-menu.left > li > a");
        softAssertions.assertThatCode(() -> {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sideBarMenuLeftLocator));
        }).doesNotThrowAnyException();
        List<String> sideBarMenuLeftItems =
            driver.findElements(sideBarMenuLeftLocator).stream().map(WebElement::getText)
                  .collect(Collectors.toList());
        softAssertions.assertThat(sideBarMenuLeftItems).isEqualTo(sideBarMenuLeftItemsText);

        //12. Close Browser
        driver.close();

        softAssertions.assertAll();
    }
}
