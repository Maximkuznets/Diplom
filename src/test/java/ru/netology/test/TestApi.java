package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.netology.data.DataHelper;
import ru.netology.data.RestApi;

import static org.junit.jupiter.api.Assertions.*;

public class TestApi {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    public void shouldStatusValidDebitCard() {
        val validCardInformation = DataHelper.getValidCardInfo();
        String response = RestApi.paymentDebitCard(validCardInformation);
        assertEquals("APPROVED", response);

    }

    @Test
    public void shouldStatusInvalidDebitCard() {
        val invalidCardInformation = DataHelper.getInvalidCardInfo();
        String response = RestApi.paymentDebitCard(invalidCardInformation);
        assertEquals("DECLINED", response);
    }

    @Test
    public void shouldStatusValidCreditCard() {
        val validCardInformation = DataHelper.getValidCardInfo();
        String response = RestApi.paymentCreditCard(validCardInformation);
        assertEquals("APPROVED", response);
    }

    @Test
    public void shouldStatusInvalidCreditCard() {
        val invalidCardInformation = DataHelper.getInvalidCardInfo();
        String response = RestApi.paymentCreditCard(invalidCardInformation);
        assertEquals("DECLINED", response);
    }
}

