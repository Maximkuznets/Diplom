package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class TripPage {
    private SelenideElement buttonDebit = $$(".button__text").find(Condition.text("Купить"));
    private SelenideElement buttonCredit = $$(".button__text").find(Condition.text("Купить в кредит"));

    public CardData selectDebitCard() {
        buttonDebit.click();
        return new CardData();
    }

    public CardData selectCreditCard() {
        buttonCredit.click();
        return new CardData();
    }
}
