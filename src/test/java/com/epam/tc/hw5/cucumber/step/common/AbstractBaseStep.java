package com.epam.tc.hw5.cucumber.step.common;

import com.epam.tc.hw5.cucumber.context.TestContext;
import com.epam.tc.hw5.pages.BasePage;
import com.epam.tc.hw5.pages.common.Header;
import com.epam.tc.hw5.pages.common.Log;
import com.epam.tc.hw5.pages.diffelements.DifferentElementsPage;
import com.epam.tc.hw5.pages.home.HomePage;
import com.epam.tc.hw5.pages.usertable.UserTablePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBaseStep {
    protected BasePage basePage;
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;
    protected Header header;
    protected Log log;

    public AbstractBaseStep() {
        WebDriver driver = TestContext.getInstance().getValue("driver", WebDriver.class);
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
        header = new Header(driver);
        log = new Log(driver);
    }
}
