package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    // Локаторы для выпадающего списка "Вопросы о важном"
    private final By questionHeader = By.xpath(".//div[contains(@class, 'accordion__heading')]");
    private final By answerText = By.xpath(".//div[contains(@class, 'accordion__panel')]");

    // Кнопки заказа
    private final By orderButtonTop = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By orderButtonBottom = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Логотипы
    private final By scooterLogo = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']");
    private final By yandexLogo = By.xpath(".//a[@class='Header_LogoYandex__3TSOI']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для работы с элементами
    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }

    public void clickOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
    }

    public void clickQuestion(int index) {
        driver.findElements(questionHeader).get(index).click();
    }

    public String getAnswerText(int index) {
        return driver.findElements(answerText).get(index).getText();
    }

    // Добавь остальные методы по мере необходимости
}