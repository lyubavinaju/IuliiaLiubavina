package com.epam.tc.hw4.pages.diffelements;

import com.epam.tc.hw4.pages.AbstractPage;
import java.util.List;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
        return waitForVisibilityOf(checkboxes);
    }

    private List<WebElement> radios() {
        return waitForVisibilityOf(radios);
    }

    private List<WebElement> colors() {
        return waitForVisibilityOf(colors);
    }

    public List<WebElement> logs() {
        return waitForVisibilityOf(logs);
    }

    public Optional<WebElement> findCheckBox(String text) {
        return checkboxes().stream().filter(c -> c.getText().contains(text))
                           .map(c -> c.findElement(By.cssSelector("input"))).findFirst();
    }

    public Optional<WebElement> findRadio(String text) {
        return radios().stream().filter(c -> c.getText().contains(text))
                       .map(c -> c.findElement(By.cssSelector("input"))).findFirst();
    }

    public DifferentElementsPage selectColor(String color) {
        click(colorsDropDownList);
        colors().stream().filter(c -> c.getText().contains(color)).findFirst()
                .ifPresent(this::click);
        return this;
    }

    public Optional<String> selectedColor() {
        return waitForVisibilityOf(colorsDropDownList).map(Select::new).map(Select::getFirstSelectedOption)
                                                    .map(WebElement::getText);
    }
}
