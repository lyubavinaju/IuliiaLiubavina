package com.epam.tc.hw4.tests;

import com.epam.tc.hw4.listeners.ScreenShotListener;
import com.epam.tc.hw4.pages.home.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import java.time.Duration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(ScreenShotListener.class)
public abstract class AbstractExerciseTest {
    private static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private static final int EXPLICIT_WAIT_IN_MILLIS = 1500;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssertions softAssertions;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        context.setAttribute("driver", driver);
        wait = new WebDriverWait(driver, Duration.ofMillis(EXPLICIT_WAIT_IN_MILLIS));
        softAssertions = new SoftAssertions();
        homePage = new HomePage(driver, wait);
        openTestSite();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        closeBrowser();
        softAssertions = null;
    }

    @Step("1. Open test site by URL")
    private void openTestSite() {
        driver.navigate().to(URL);
    }

    @Step("2. Assert Browser title")
    protected void checkTitle(String title) {
        softAssertions.assertThatCode(() -> wait.until(ExpectedConditions.titleIs(title))).doesNotThrowAnyException();
    }

    @Step("3. Perform login")
    protected void performLogin(String name, String pass) {
        homePage.openLoginMenu().login(name, pass);
        softAssertions.assertThat(homePage.username()).isPresent();
    }

    @Step("4. Assert {username} is logged in")
    protected void checkUsername(String username) {
        softAssertions.assertThat(homePage.username().orElse(null)).isEqualTo(username);
    }

    @Step("Close Browser")
    private void closeBrowser() {
        driver.quit();
    }
}
