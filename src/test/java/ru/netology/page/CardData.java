package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CardData {
    private SelenideElement numberCard = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement month = $("[placeholder='08']");
    private SelenideElement year = $("[placeholder='22']");
    private SelenideElement holderCard = $$(".input__inner").find(Condition.text("Владелец")).$(".input__control");
    private SelenideElement cvcCode = $("[placeholder='999']");
    private SelenideElement buttonContinue = $$(".button__text").find(Condition.text("Продолжить"));
    private SelenideElement successNotification = $(withText("Успешно"));
    private SelenideElement errorNotification = $(withText("Ошибка"));

    private SelenideElement wrongNotification = $(".input__sub");

    public void cardAllInfo(DataHelper.CardInfo cardInfo) {
        numberCard.setValue(cardInfo.getNumber());
        month.setValue(cardInfo.getMonth());
        year.setValue(cardInfo.getYear());
        holderCard.setValue(cardInfo.getHolder());
        cvcCode.setValue(cardInfo.getCvc());
        buttonContinue.click();
    }

    public void paymentSuccess() {
        successNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void paymentNoSuccess() {
        errorNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void wrongerrorNotification() {
        wrongNotification.shouldBe(Condition.visible);
    }


}
