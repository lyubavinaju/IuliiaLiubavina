package com.epam.tc.hw3.tests.ex1;

import com.epam.tc.hw3.dataprovider.Exercise1Data;
import com.epam.tc.hw3.pages.home.FrameWithButton;
import com.epam.tc.hw3.tests.AbstractExerciseTest;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1Test extends AbstractExerciseTest {

    @Test(dataProvider = "exercise1Data", dataProviderClass = Exercise1Data.class)
    void exercise1Test(String name, String password, String userName,
                       String title,
                       List<String> headerItemsText,
                       int imagesCount,
                       List<String> underImagesText,
                       List<String> leftMenuItemsText) {
        //1, 2, 3, 4. open site and login
        exercisesCommonStart(title, name, password, userName);

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> actualHeaderItemsText =
            homePage.header().items().stream().map(WebElement::getText).collect(Collectors.toList());
        softAssertions.assertThat(actualHeaderItemsText).isEqualTo(headerItemsText);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = homePage.images();
        softAssertions.assertThat(images).hasSize(imagesCount);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> actualTextsUnderImages =
            homePage.textsUnderImages().stream().map(WebElement::getText).collect(Collectors.toList());
        softAssertions.assertThat(actualTextsUnderImages).isEqualTo(underImagesText);

        //8. Assert that there is the iframe with “Frame Button” exist
        FrameWithButton frame = homePage.frameWithButton();
        softAssertions.assertThat(frame.isVisible()).isTrue();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssertions.assertThat(frame.switchToFrame().button()).isPresent();

        //10. Switch to original window back
        softAssertions.assertThatCode(frame::switchToHomePage).doesNotThrowAnyException();
        softAssertions.assertThat(frame.isVisible()).isTrue();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> actualLeftMenuItemsText = homePage.leftMenu().items().stream().map(WebElement::getText)
                                                       .collect(Collectors.toList());
        softAssertions.assertThat(actualLeftMenuItemsText).isEqualTo(leftMenuItemsText);
        softAssertions.assertAll();
    }
}
