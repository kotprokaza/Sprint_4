package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    
    private final By orderButtonTop = By.className("Button_Button__ra12g");
    private final By orderButtonBottom = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM')]");
    
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }
    
    public void clickOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
    }
}
