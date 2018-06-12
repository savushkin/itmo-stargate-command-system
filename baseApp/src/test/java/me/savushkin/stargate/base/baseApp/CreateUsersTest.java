package me.savushkin.stargate.base.baseApp;

import me.savushkin.stargate.base.baseApp.helpers.SeleniumTest;
import me.savushkin.stargate.base.baseApp.page.LoginPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "server.port=8081", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@SeleniumTest(driver = ChromeDriver.class, baseUrl = "http://localhost:8081/")
public class CreateUsersTest {
    private final String USERNAME = "admin";
    private final String PASSWORD = "derparol";
    private final String URL = "http://localhost:8081/";
    @Autowired
    private WebDriver driver;
    WebDriverWait wait;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        wait = new WebDriverWait(driver, 30);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        login();
        driver.get(URL+"user");
    }

    @Test
    public void createUser() throws InterruptedException {
        assertTrue(loginPage.getTitle().getText().contains("Список пользователей"));
        WebElement addUser = driver.findElement(By.cssSelector("button[routerlink=\"/user/create\"]"));
        addUser.click();
        wait.until((WebDriver d) ->
                d.findElement(By.cssSelector(".mat-card"))
        );
        assertTrue(loginPage.getTitle().getText().contains("Создание пользователя"));
        WebElement username = driver.findElement(By.cssSelector("input[formcontrolname=\"username\"]"));
        username.sendKeys("Lada1");
        WebElement name = driver.findElement(By.cssSelector("input[formcontrolname=\"name\"]"));
        name.sendKeys("kalina");
        WebElement surname = driver.findElement(By.cssSelector("input[formcontrolname=\"surname\"]"));
        surname.sendKeys("91");
        driver.findElement(By.cssSelector("input[formcontrolname=\"rank\"]")).sendKeys("Адмирал");
        driver.findElement(By.cssSelector("input[formcontrolname=\"password\"]")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("div.mat-select-arrow-wrapper")).click();
        driver.findElement(By.xpath("//mat-option[@id='mat-option-6']/mat-pseudo-checkbox")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }
    //mat-button-wrapper.span:contains("Сохранить")]
    ///html/body/sgc-root/div/mat-sidenav-container/mat-sidenav-content/sgc-user-create-page/div/mat-card/mat-card-content/sgc-user-form/form/button
    void login(){
        driver.get(URL+"login");
        wait.until((WebDriver d) ->
                d.findElement(By.cssSelector(".mat-card.login-card"))
        );
        loginPage.getUsernameInput().clear();
        loginPage.getUsernameInput().sendKeys(USERNAME);
        loginPage.getPassowrdInput().clear();
        loginPage.getPassowrdInput().sendKeys(PASSWORD);
        loginPage.getSubmitButton().click();

        wait.until((WebDriver d) ->
                d.findElement(By.cssSelector(".mat-card:not(.login-card)"))
        );
    }

}
