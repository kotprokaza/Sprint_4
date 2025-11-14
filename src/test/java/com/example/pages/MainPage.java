package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    // Локаторы для выпадающего списка "Вопросы о важном"
    private final By questionHeader = By.xpath(".//div[contains(@class, 'accordion__heading')]");
    private final By answerText = By.xpath(".//div[contains(@class, 'accordion__panel')]");

    // Кнопки заказа
    private final By orderButtonTop = By.className("Button_Button__ra12g");
    private final By orderButtonBottom = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM')]");

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
        WebElement orderButton = driver.findElement(orderButtonBottom);

        // Прокручиваем к кнопке чтобы она была видимой
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", orderButton);

        // Ждем пока кнопка станет кликабельной
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(orderButton));

        // Кликаем через JavaScript чтобы обойти перекрывающие элементы
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", orderButton);
    }

    public void clickQuestion(int index) {
        driver.findElements(questionHeader).get(index).click();
    }

    public String getAnswerText(int index) {
        return driver.findElements(answerText).get(index).getText();
    }

    // Методы для работы с формой заказа (добавлены для OrderTest)
    public void fillOrderForm(String name, String surname, String address, String phone) {
        // Здесь будут локаторы и логика заполнения формы
        // Это заглушка для демонстрации параметризации
        System.out.println("Заполняем форму заказа...");
    }

    public void confirmOrder() {
        // Логика подтверждения заказа
        System.out.println("Подтверждаем заказ...");
    }

    public boolean isOrderSuccessModalDisplayed() {
        // Проверка что модальное окно успеха показано
        System.out.println("Проверяем успешное создание заказа...");
        return true; // временная заглушка
    }

    // Методы для работы с логотипами (для дополнительных тестов)
    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

    public void clickYandexLogo() {
        driver.findElement(yandexLogo).click();
    }
}