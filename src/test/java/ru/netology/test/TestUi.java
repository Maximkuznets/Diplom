package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.DbInteraction;
import ru.netology.page.TripPage;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUi {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setUp() {
        open("http://localhost:8080/");
    }


    @Test
    void shouldSuccessValidDebitCard() throws SQLException {
        val tripPage = new TripPage();
        val CardData = tripPage.selectDebitCard();
        val validCardInformation = DataHelper.getValidCardInfo();
        CardData.cardAllInfo(validCardInformation);
        CardData.paymentSuccess();
        var paymentId = DbInteraction.getPaymentId();
        var statusActual = DbInteraction.getStatusDebitCard(paymentId);
        assertEquals("APPROVED", statusActual);

    }

    @Test
    void shouldSuccessValidCreditCard() throws SQLException {
        val tripPage = new TripPage();
        val CardData = tripPage.selectCreditCard();
        val validCardInformation = DataHelper.getValidCardInfo();
        CardData.cardAllInfo(validCardInformation);
        CardData.paymentSuccess();
        var paymentId = DbInteraction.getPaymentId();
        var statusActual = DbInteraction.getStatusCreditCard(paymentId);
        assertEquals("APPROVED", statusActual);
    }

    @Test
    void shouldNotSuccessInvalidDebitCard() throws SQLException {
        val tripPage = new TripPage();
        val CardData = tripPage.selectDebitCard();
        val invalidCardInformation = DataHelper.getInvalidCardInfo();
        CardData.cardAllInfo(invalidCardInformation);
        CardData.paymentNoSuccess();
        var paymentId = DbInteraction.getPaymentId();
        var statusActual = DbInteraction.getStatusDebitCard(paymentId);
        assertEquals("DECLINED", statusActual);
    }

    @Test
    void shouldNotSuccessInvalidCreditCard() throws SQLException {
        val tripPage = new TripPage();
        val CardData = tripPage.selectCreditCard();
        val validCardInformation = DataHelper.getInvalidCardInfo();
        CardData.cardAllInfo(validCardInformation);
        CardData.paymentNoSuccess();
        var paymentId = DbInteraction.getPaymentId();
        var statusActual = DbInteraction.getStatusCreditCard(paymentId);
        assertEquals("DECLINED", statusActual);
    }
//-------------------------------------------------------------------

    @Test
    public void shouldNotSuccessEmptyField() {
        val tripPage = new TripPage();
        val CardData = tripPage.selectDebitCard();
        val invalidCardInfo = DataHelper.getCardInfoEmptyFields();
        CardData.cardAllInfo(invalidCardInfo);
        CardData.wrongerrorNotification();
    }

    @Test
    public void shouldNotSuccessShortCardNumber() {
        val tripPage = new TripPage();
        val CardData = tripPage.selectDebitCard();
        val invalidCardInfo = DataHelper.getCardInfoShortCardNumber();
        CardData.cardAllInfo(invalidCardInfo);
        CardData.wrongerrorNotification();

    }

    @Test
    public void shouldNotSuccessIncorrectMonth() {
        val tripPage = new TripPage();
        val CardData = tripPage.selectDebitCard();
        val invalidCardInfo = DataHelper.getCardInfoIncorrectMonth();
        CardData.cardAllInfo(invalidCardInfo);
        CardData.wrongerrorNotification();

    }

    @Test
    public void shouldNotSuccessMonthZero() {
        val tripPage = new TripPage();
        val CardData = tripPage.selectDebitCard();
        val invalidCardInfo = DataHelper.getCardInfoMonthZero();
        CardData.cardAllInfo(invalidCardInfo);
        CardData.wrongerrorNotification();

    }

    @Test
    public void shouldNotSuccessShortMonth() {
        val tripPage = new TripPage();
        val CardData = tripPage.selectDebitCard();
        val invalidCardInfo = DataHelper.getCardInfoShortMonth();
        CardData.cardAllInfo(invalidCardInfo);
        CardData.wrongerrorNotification();

    }

    @Test
    public void shouldNotSuccessIncorrectYear() {
        val tripPage = new TripPage();
        val CardData = tripPage.selectDebitCard();
        val invalidCardInfo = DataHelper.getCardInfoIncorrectYear();
        CardData.cardAllInfo(invalidCardInfo);
        CardData.wrongerrorNotification();

    }

    @Test
    public void shouldNotSuccessIncorrectCvc() {
        val tripPage = new TripPage();
        val CardData = tripPage.selectDebitCard();
        val invalidCardInfo = DataHelper.getCardInfoIncorrectCVC();
        CardData.cardAllInfo(invalidCardInfo);
        CardData.wrongerrorNotification();

    }

    @Test
    public void shouldNotSuccessIncorrectName() {
        val tripPage = new TripPage();
        val CardData = tripPage.selectDebitCard();
        val invalidCardInfo = DataHelper.getCardInfoIncorrectName();
        CardData.cardAllInfo(invalidCardInfo);
        CardData.wrongerrorNotification();

    }

}
