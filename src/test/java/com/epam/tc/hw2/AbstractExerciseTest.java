package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class AbstractExerciseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssertions softAssertions;
    private static final int EXPLICIT_WAIT_IN_MILLIS = 1500;
    private static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofMillis(EXPLICIT_WAIT_IN_MILLIS));
    }

    @BeforeMethod
    public void setUp() {
        softAssertions = new SoftAssertions();
    }

    @AfterMethod
    public void tearDown() {
        softAssertions = null;
    }

    protected void exercisesCommonStart(String title, Map<String, String> credentials, String username) {
        //1. Open test site by URL
        driver.navigate().to(URL);

        //2. Assert Browser title
        softAssertions.assertThatCode(() -> {
            wait.until(ExpectedConditions.titleIs(title));
        }).doesNotThrowAnyException();

        //3. Perform login
        By uuiProfileMenuLocator = By.className("uui-profile-menu");
        softAssertions.assertThatCode(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(uuiProfileMenuLocator));
            driver.findElement(uuiProfileMenuLocator).click();
        }).doesNotThrowAnyException();
        By nameLocator = By.id("name");
        softAssertions.assertThatCode(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(nameLocator));
            driver.findElement(nameLocator).sendKeys(credentials.get("name"));
        }).doesNotThrowAnyException();
        By passwordLocator = By.id("password");
        softAssertions.assertThatCode(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(passwordLocator));
            driver.findElement(passwordLocator).sendKeys(credentials.get("pass"));
        }).doesNotThrowAnyException();
        By uuiButton = By.className("uui-button");
        softAssertions.assertThatCode(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(uuiButton));
            driver.findElement(uuiButton).click();
        }).doesNotThrowAnyException();
        By usernameLocator = By.id("user-name");
        softAssertions.assertThatCode(() -> {
            wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
        }).doesNotThrowAnyException();

        //4. Assert Username is logged in
        List<WebElement> usernameList = driver.findElements(usernameLocator);
        softAssertions.assertThat(usernameList).hasSize(1);
        usernameList.forEach(un -> softAssertions.assertThat(un.getText()).isEqualTo(username));
    }
}
