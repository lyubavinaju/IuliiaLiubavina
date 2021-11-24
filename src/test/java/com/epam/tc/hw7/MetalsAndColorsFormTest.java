package com.epam.tc.hw7;

import static com.epam.tc.hw7.JdiSite.header;
import static com.epam.tc.hw7.JdiSite.homePage;
import static com.epam.tc.hw7.JdiSite.metalsColorsPage;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.dataprovider.TestData;
import com.epam.tc.hw7.entities.HeaderMenuData;
import com.epam.tc.hw7.entities.MetalsColorsFormData;
import com.epam.tc.hw7.entities.User;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.hamcrest.core.StringContains;
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
    public void userCanSubmitForm(MetalsColorsFormData formData) {
        User defaultUser = new User();
        JdiSite.login(defaultUser);
        JdiSite.userName.is().text(defaultUser.getFullName());

        header.navigation.select(HeaderMenuData.METALS_COLORS);
        metalsColorsPage.checkOpened();

        if (formData.vegetablesSelectedByDefault != null) {
            metalsColorsPage.form.vegetables.select(formData.vegetablesSelectedByDefault);
        }
        metalsColorsPage.form.fill(formData);
        metalsColorsPage.form.submit();

        metalsColorsPage.form.customRadioOdd.is().selected(formData.customRadioOdd);
        metalsColorsPage.form.customRadioEven.is().selected(formData.customRadioEven);
        metalsColorsPage.form.colors.is().selected(formData.colors);
        metalsColorsPage.form.metals.is().selected(formData.metals);
        metalsColorsPage.form.elements.is().checked(formData.elements);
        metalsColorsPage.form.vegetables.is()
                                        .text(StringContains
                                            .containsString(String.join(", ", formData.vegetables)));
        List<String> result = metalsColorsPage.result.map(UIElement::text);
        Assertions.assertThat(result).isEqualTo(formData.result);
    }
}
