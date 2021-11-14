package com.epam.tc.hw4.pages.diffelements;

import com.epam.tc.hw4.pages.AbstractPage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DifferentElementsPage extends AbstractPage {
    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radios;

    @FindBy(css = ".colors .uui-form-element")
    private WebElement colorsDropDownList;

    @FindBy(css = ".colors .uui-form-element option")
    private List<WebElement> colors;

    @FindBy(css = ".logs li")
    private List<WebElement> logs;

    public DifferentElementsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    private List<WebElement> checkboxes() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(checkboxes));
            return checkboxes;
        } catch (Exception e) {
            return List.of();
        }
    }

    private List<WebElement> radios() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(radios));
            return radios;
        } catch (Exception e) {
            return List.of();
        }
    }

    public WebElement findCheckBox(String text) {
        return checkboxes().stream().filter(c -> c.getText().contains(text))
                           .map(c -> c.findElement(By.cssSelector("input"))).findFirst().orElse(null);
    }

    public WebElement findRadio(String text) {
        return radios().stream().filter(c -> c.getText().contains(text))
                       .map(c -> c.findElement(By.cssSelector("input"))).findFirst().orElse(null);
    }

    public DifferentElementsPage selectColor(String color) {
        wait.until(ExpectedConditions.elementToBeClickable(colorsDropDownList));
        colorsDropDownList.click();
        colors.stream().filter(c -> c.getText().contains(color)).findFirst().ifPresent(WebElement::click);
        return this;
    }

    public String selectedColor() {
        try {
            wait.until(ExpectedConditions.visibilityOf(colorsDropDownList));
            return new Select(colorsDropDownList).getFirstSelectedOption().getText();
        } catch (Exception e) {
            return null;
        }
    }

    public List<WebElement> logs() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(logs));
            return logs;
        } catch (Exception e) {
            return List.of();
        }
    }
}
