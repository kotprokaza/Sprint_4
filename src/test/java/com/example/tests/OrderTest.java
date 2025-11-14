package com.example.tests;

import com.example.utils.BaseTest;
import com.example.pages.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final boolean useTopButton;

    public OrderTest(String name, String surname, String address, String phone, boolean useTopButton) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.useTopButton = useTopButton;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getOrderData() {
        return Arrays.asList(new Object[][] {
                {"Иван", "Иванов", "ул. Ленина, д.1", "+79991112233", true},
                {"Мария", "Петрова", "пр. Мира, д.25", "+79994445566", false}
        });
    }

    @Test
    public void testSuccessfulOrder() {
        MainPage mainPage = new MainPage(driver);

        if (useTopButton) {
            mainPage.clickOrderButtonTop();
        } else {
            mainPage.clickOrderButtonBottom();
        }

        System.out.println("Тест заказа запущен с данными:");
        System.out.println("Имя: " + name);
        System.out.println("Фамилия: " + surname);
        System.out.println("Адрес: " + address);
        System.out.println("Телефон: " + phone);
        System.out.println("Кнопка: " + (useTopButton ? "верхняя" : "нижняя"));
    }
}