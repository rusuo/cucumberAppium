package com.saucelabs.appium;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;

public class ContactsStepDef {

    private WebDriver webDriver;

    private AndroidContactsPage androidContactsPage;

    public ContactsStepDef (){
        androidContactsPage = new AndroidContactsPage(webDriver);
    }

    @Before
    public void setUp() throws Exception {
        // set up appium
        File app = new File("/Users/oanarusu/Documents/appium/sample-code/apps/ContactManager", "ContactManager.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(CapabilityType.VERSION, "4.2");
        capabilities.setCapability(CapabilityType.PLATFORM, "MAC");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("app-package", "com.example.android.contactmanager");
        capabilities.setCapability("app-activity", ".ContactManager");
        webDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Given("^I am on add user page$")
    public void I_am_on_add_user_page() throws Throwable {
        androidContactsPage.addContact();
    }

    @Then("^I add a new contact$")
    public void I_add_a_new_contact() throws Throwable {
     //   androidContactsPage.addContact();
    }

    @After
    public void tearDown() throws Exception {
        webDriver.quit();
    }
}
