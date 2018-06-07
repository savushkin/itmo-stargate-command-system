package me.savushkin.stargate.base.baseApp.page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage {

    private final WebDriver driver;

    @FindBy(css = "input[name=\"username\"]")
    private WebElement usernameInput;

    @FindBy(css = "input[name=\"password\"]")
    private WebElement passowrdInput;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement submitButton;

    @FindBy(css = ".mat-card-title")
    private WebElement title;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
}
