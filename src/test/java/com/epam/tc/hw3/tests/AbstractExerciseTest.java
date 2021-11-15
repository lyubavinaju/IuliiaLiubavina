package com.epam.tc.hw3.tests;

import com.epam.tc.hw3.pages.home.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractExerciseTest {
    private static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private static final int EXPLICIT_WAIT_IN_MILLIS = 1500;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssertions softAssertions;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofMillis(EXPLICIT_WAIT_IN_MILLIS));
        softAssertions = new SoftAssertions();
        //1. Open test site by URL
        driver.navigate().to(URL);
        homePage = new HomePage(driver, wait);
    }

    @AfterMethod
    public void tearDown() {
        // Close Browser
        driver.quit();
        softAssertions = null;
    }

    protected void exercisesCommonStart(String title, String name, String pass, String username) {
        //2. Assert Browser title
        softAssertions.assertThatCode(() -> wait.until(ExpectedConditions.titleIs(title))).doesNotThrowAnyException();

        //3. Perform login
        homePage.openLoginMenu().login(name, pass);
        softAssertions.assertThat(homePage.username()).isPresent();

        //4. Assert Username is logged in
        softAssertions.assertThat(homePage.username().orElse(null)).isEqualTo(username);
    }
}
