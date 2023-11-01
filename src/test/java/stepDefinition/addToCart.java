package stepDefinition;

import Hooks.driverInstance;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.Dashboard;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class addToCart extends driverInstance {


//    @Given("User navigates to bookcart apllication.")
//    public void user_navigates_to_bookcart_apllication() {
//        driver = new ChromeDriver();
//        driver.get("https://bookcart.azurewebsites.net/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//    }
    @And("User enters the {string} or {string} and click Login.")
    public void user_enters_the_or_and_click_login(String username, String pass) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(pass);
        loginPage.clickLoginAfterCredentials();
        Thread.sleep(2000);
    }
    @Given("User search for the {string}.")
    public void user_search_for_the(String bookName) throws InterruptedException {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.enterTextSearchBox(bookName);
        Thread.sleep(2000);
    }
    @When("User add the book to the cart.")
    public void user_add_the_book_to_the_cart() throws InterruptedException {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.AddToCart();
        Thread.sleep(2000);
    }
    @Then("AddToCart badge should be updated.")
    public void add_to_cart_badge_should_be_updated() {
        Dashboard dashboard = new Dashboard(driver);
        int count = dashboard.countTotalItems();
        Assert.assertEquals(count > 0,true);

    }
}
