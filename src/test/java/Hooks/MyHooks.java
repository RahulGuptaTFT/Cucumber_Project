package Hooks;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.time.Duration;

public class MyHooks extends driverInstance {
    @Before
    public void before(Scenario scenario){
//        System.out.println(scenario.getName());
        driver = new ChromeDriver();
        driver.get("https://bookcart.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void after(Scenario scenario) throws InterruptedException {
        Boolean failed = scenario.isFailed();
        System.out.println(failed);
        if (failed){
            TakesScreenshot ts = (TakesScreenshot) driver;

            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
        Thread.sleep(3000);
        driver.quit();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario){

    }

    @AfterStep
    public void afterStep(Scenario scenario){

    }
}
