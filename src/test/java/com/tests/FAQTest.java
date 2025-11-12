package com.example.tests;

import com.example.utils.BaseTest;
import com.example.pages.MainPage;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class FAQTest extends BaseTest {

    @Test
    public void testFAQSection() {
        MainPage mainPage = new MainPage(driver);

        // Проверяем несколько вопросов
        String[] expectedAnswers = {
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."
                // Добавь остальные ожидаемые ответы
        };

        for (int i = 0; i < expectedAnswers.length; i++) {
            mainPage.clickQuestion(i);
            String actualAnswer = mainPage.getAnswerText(i);
            assertTrue("Ответ не соответствует ожидаемому для вопроса " + i,
                    actualAnswer.contains(expectedAnswers[i]));
        }
    }
}