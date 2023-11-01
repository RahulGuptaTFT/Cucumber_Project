package stepDefinition;

import Hooks.driverInstance;
import io.cucumber.java.en.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Dashboard;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class loginSteps extends driverInstance {



//    @Given("User navigate to bookcart apllication.")
//    public void user_navigate_to_bookcart_apllication() {
//        driver = new ChromeDriver();
//        driver.get("https://bookcart.azurewebsites.net/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }

    @And("User clicks on login button.")
    public void user_clicks_on_login_button() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();
    }

//    @And("User enters the username.")
//    public void user_enters_the_username() {
////      username = Abcxyz123
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterUsername("Abcxyz123");
//    }
//
//    @And("user enters the password.")
//    public void user_enters_the_password() {
////      password = AbcXyz123
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterPassword("AbcXyz123");
//    }

    @When("click login button.")
    public void click_login_button() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginAfterCredentials();
    }

    @Then("Login should be success.")
    public void login_should_be_success() {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.checkValidId();
    }
//    @And("User enters the wrong username.")
//    public void user_enters_the_wrong_username() {
//    //      username = Abcxyz1234
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterUsername("Abcxyz1234");
//    }
//    @And("user enters the wrong password.")
//    public void user_enters_the_wrong_password() {
//        //      password = AbcXyz1234
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterPassword("AbcXyz1234");
//    }
    @But("Login should be fail.")
    public void login_should_be_fail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkNotlogin();

    }

    @And("User enters the username as {string}.")
    public void user_enters_the_username_as(String string) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(string);
    }
    @And("user enters the password {string}.")
    public void user_enters_the_password(String string) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword(string);
    }
}
