package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = " //form/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]")
    WebElement userName;

    @FindBy(xpath = "//form/mat-form-field[2]/div[1]/div[1]/div[1]/input[1]")
    WebElement password;


    @FindBy(xpath = "//form//span[text()='Login']")
    WebElement loginbutton;

    @FindBy(xpath = "//strong[text()='New User? ']")
    WebElement text_for_not_login;
    public void enterUsername(String s) {
        userName.sendKeys(s);
    }
    public void enterPassword(String s) {
        password.sendKeys(s);
    }
    public void clickLoginAfterCredentials(){
        loginbutton.click();
    }
    public void checkNotlogin(){
      String s = text_for_not_login.getText();
        Assert.assertEquals(s,"New User?");
    }
}
