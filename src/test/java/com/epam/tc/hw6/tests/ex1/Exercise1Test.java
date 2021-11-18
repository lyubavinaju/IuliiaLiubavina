package com.epam.tc.hw6.tests.ex1;

import com.epam.tc.hw6.pages.home.FrameWithButton;
import com.epam.tc.hw6.service.dataprovider.Exercise1Data;
import com.epam.tc.hw6.tests.AbstractExerciseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Feature("Home page")
@Story("Exercise1")
public class Exercise1Test extends AbstractExerciseTest {

    @Step("5. Assert that there are 4 items on the header section are displayed "
              + "and they have proper texts")
    void checkHeaderItems(String[] headerItemsText) {
        List<String> actualHeaderItemsText =
            homePage.header().items().stream().map(WebElement::getText).collect(Collectors.toList());
        softAssertions.assertThat(actualHeaderItemsText).isEqualTo(Arrays.asList(headerItemsText));
    }

    @Step("6. Assert that there are {imgCount} images on the Index Page and they are displayed")
    protected void checkImages(int imgCount) {
        List<WebElement> images = homePage.images();
        softAssertions.assertThat(images).hasSize(imgCount);
    }

    @Step("7. Assert that there are 4 texts on the Index Page under icons and they have proper text")
    protected void checkUnderImagesText(String[] underImagesText) {
        List<String> actualTextsUnderImages =
            homePage.textsUnderImages().stream().map(WebElement::getText).collect(Collectors.toList());
        softAssertions.assertThat(actualTextsUnderImages).isEqualTo(Arrays.asList(underImagesText));
    }

    @Step("8. Assert that there is the iframe with “Frame Button” exist")
    protected void checkIframeExists(FrameWithButton frame) {
        softAssertions.assertThat(frame.isVisible()).isTrue();
    }

    @Step("9. Switch to the iframe and check that there is “Frame Button” in the iframe")
    protected void switchToIframe(FrameWithButton frame) {
        softAssertions.assertThat(frame.switchToFrame().button()).isPresent();
    }

    @Step("10. Switch to original window back")
    protected void switchToOriginalWindow(FrameWithButton frame) {
        softAssertions.assertThatCode(frame::switchToHomePage).doesNotThrowAnyException();
    }

    @Step("11. Assert that there are 5 items in the Left Section are displayed and they have proper text")
    protected void checkLeftMenu(String[] leftMenuItemsText) {
        List<String> actualLeftMenuItemsText = homePage.leftMenu().items().stream().map(WebElement::getText)
                                                       .collect(Collectors.toList());
        softAssertions.assertThat(actualLeftMenuItemsText).isEqualTo(Arrays.asList(leftMenuItemsText));
    }

    @Test(dataProvider = "exercise1Data", dataProviderClass = Exercise1Data.class)
    void exercise1SuccessfulTest(String name, String password, String username,
                                 String homePageTitle,
                                 String[] headerItemsText,
                                 int imagesCount,
                                 String[] underImagesText,
                                 String[] leftMenuItemsText) {
        checkTitle(homePageTitle);
        performLogin(name, password);
        checkUsername(username);

        checkHeaderItems(headerItemsText);
        checkImages(imagesCount);
        checkUnderImagesText(underImagesText);

        FrameWithButton frame = homePage.frameWithButton();
        checkIframeExists(frame);
        switchToIframe(frame);
        switchToOriginalWindow(frame);

        checkLeftMenu(leftMenuItemsText);

        softAssertions.assertAll();
    }
}
