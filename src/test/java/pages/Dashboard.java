package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Dashboard {
    WebDriver driver;

    public Dashboard(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()=' Abcxyz123 ']")
    WebElement id;

    @FindBy(xpath = "//form/input[1]")
    WebElement searchBox;

    @FindBy(xpath = "(//button[@color='primary']//span)[1]")
    WebElement addToCart;

    @FindBy(id = "mat-badge-content-0")
    WebElement totalItems;
    public void checkValidId(){
        String s = id.getText();
        Assert.assertEquals(s,"account_circle Abcxyz123 arrow_drop_down","Id does not match");
    }
    public void enterTextSearchBox(String s){
        searchBox.sendKeys(s);
        searchBox.click();
    }

    public void AddToCart() {
        addToCart.click();
    }

    public int countTotalItems() {
       return Integer.parseInt(totalItems.getText());
    }
}
