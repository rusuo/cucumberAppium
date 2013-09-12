package cucumber.test;

import java.net.URL;
import java.util.List;

import cucumber.annotation.*;
import cucumber.annotation.en.*;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddContactStepDefs {

    private WebDriver driver;


    /**
     * setUp() method to be run before running the test for mobile
     * the same adnotation appears in the .feature file
     */
    @Before("@android")
    public void setUpAndroid()  throws Throwable
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("app", "/Users/oanarusu/Documents/appium/sample-code/apps/ContactManager/ContactManager.apk");
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("version", "4.2");
        capabilities.setCapability("app-package", "com.example.android.contactmanager");
        capabilities.setCapability("app-activity", ".ContactManager");

        //Create an instance of RemoteWebDriver and connect to the Appium server.
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    /**
     * setUp() method to be run before running the test for web
     */
    @Before ("@web")
    public void setUpWeb() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("file:///Users/oanarusu/Documents/AddContactWebsite/index.html");
        waitUntilElementDisplayed("Add Contact");
    }

    @Given("^I am on add user page$")
    public void I_am_on_add_user_page() throws Throwable {
        WebElement el = driver.findElement(By.name("Add Contact"));
        el.click();

        waitUntilElementDisplayed("Save");
    }

    /**
     * You can add more tests here, like typing something in the textboxes before clicking on Save button
     * @throws Throwable
     */
    @Then("^I add a new contact$")
    public void I_add_a_new_contact() throws Throwable {
      driver.findElement(By.name("Save")).click();
    }

    public void waitUntilElementDisplayed(String element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(element)));
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

}



