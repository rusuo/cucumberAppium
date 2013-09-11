package com.saucelabs.appium;

import org.openqa.selenium.*;
import java.util.List;

public class AndroidContactsPage {
    private WebDriver webDriver;

    public AndroidContactsPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void addContact(){
        WebElement el;
        el = webDriver.findElement(By.name("Add Contact"));
        el.click();
        List<WebElement> textFieldsList = webDriver.findElements(By.tagName("textfield"));
        textFieldsList.get(0).sendKeys("Some Name");
        textFieldsList.get(2).sendKeys("Some@example.com");
        webDriver.findElement(By.name("Save")).click();
    }
}
