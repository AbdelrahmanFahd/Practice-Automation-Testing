package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Hooks {
    public static WebDriver driver;

    public void homePage() {
        driver.get("http://practice.automationtesting.in/");
    }


    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("src/main/resources/Extensions/AdBlock.crx"));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        homePage();
    }

    @Given("Close adsBlocker Extension")
    public void closeTab() {
        String[] windowsHandles = new String[driver.getWindowHandles().size()];
        windowsHandles = driver.getWindowHandles().toArray(windowsHandles);
        driver.switchTo().window(windowsHandles[1]);
        driver.close();
        driver.switchTo().window(windowsHandles[0]);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }


}
