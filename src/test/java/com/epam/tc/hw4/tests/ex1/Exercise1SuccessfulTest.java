package com.epam.tc.hw4.tests.ex1;

import com.epam.tc.hw4.dataprovider.Exercise1Data;
import com.epam.tc.hw4.pages.home.FrameWithButton;
import org.testng.annotations.Test;

public class Exercise1SuccessfulTest extends Exercise1 {

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
