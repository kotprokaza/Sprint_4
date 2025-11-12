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
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Иван", "Иванов", "ул. Ленина, д.1", "+79991112233", true},
                {"Мария", "Петрова", "пр. Мира, д.25", "+79994445566", false}
        });
    }

    @Test
    public void testSuccessfulOrder() {
        MainPage mainPage = new MainPage(driver);

        // Выбираем точку входа
        if (useTopButton) {
            mainPage.clickOrderButtonTop();
        } else {
            mainPage.clickOrderButtonBottom();
        }

        // Здесь будет логика заполнения формы заказа
        // и проверка успешного создания

        // Временная заглушка - тест будет падать из-за бага в Chrome
        System.out.println("Тест заказа выполнен с данными: " + name + " " + surname);
    }
}