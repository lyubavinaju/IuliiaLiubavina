package com.epam.tc.hw7;

import static com.epam.tc.hw7.JdiSite.homePage;
import static com.epam.tc.hw7.JdiSite.metalsColorsPage;
import static com.epam.tc.hw7.pages.BasePage.header;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.dataprovider.TestData;
import com.epam.tc.hw7.entities.HeaderMenuData;
import com.epam.tc.hw7.entities.MetalsColorsFormData;
import com.epam.tc.hw7.entities.ResultData;
import com.epam.tc.hw7.entities.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MetalsAndColorsFormTest {
    @BeforeSuite(alwaysRun = true)
    public void beforeClass() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterClass() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @BeforeMethod
    public void setUp() {
        homePage.shouldBeOpened();
    }

    @AfterMethod
    public void tearDown() {
        JdiSite.logout();
    }

    @Test(dataProvider = "metalsAndColorsFormData", dataProviderClass = TestData.class)
    public void userCanSubmitForm(MetalsColorsFormData formData, ResultData resultData) {

        User defaultUser = new User();
        JdiSite.login(defaultUser);
        header.userName.is().text(defaultUser.getFullName());

        header.navigation.select(HeaderMenuData.METALS_COLORS);
        metalsColorsPage.checkOpened();

        if (formData.getVegetablesSelectedByDefault() != null) {
            metalsColorsPage.form.vegetables.select(formData.getVegetablesSelectedByDefault());
        }

        metalsColorsPage.form.fill(formData);
        metalsColorsPage.form.submit();

        metalsColorsPage.form.check(formData);
        metalsColorsPage.result.is().values(resultData.result);
    }
}
