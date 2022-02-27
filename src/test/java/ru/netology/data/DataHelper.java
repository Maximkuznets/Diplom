package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));

    private DataHelper() {

    }


    static String month = String.valueOf(faker.number().numberBetween(10, 12));
    static String shortMonth = String.valueOf(faker.number().numberBetween(1, 9));
    static String year = String.valueOf(faker.number().numberBetween(22, 24));
    static String cvc = String.valueOf(faker.number().numberBetween(100, 999));

    static String incorrectMonth = String.valueOf(faker.number().numberBetween(12, 20));
    static String incorrectYear = String.valueOf(faker.number().numberBetween(40, 45));
    static String incorrectName = String.valueOf(faker.number().numberBetween(100, 999));
    static String incorrectCvc = String.valueOf(faker.number().numberBetween(10, 99));


    public static CardInfo getValidCardInfo() {

        return new CardInfo("4444 4444 4444 4441", month, year, faker.name().fullName(), cvc);
    }

    public static CardInfo getInvalidCardInfo() {
        return new CardInfo("4444 4444 4444 4442", month, year, faker.name().fullName(), cvc);
    }

    public static CardInfo getCardInfoEmptyFields() {

        return new CardInfo("", "", "", "", "");
    }

    public static CardInfo getCardInfoShortCardNumber() {
        return new CardInfo("4444 4444 4444 444", month, year, faker.name().fullName(), cvc);
    }

    public static CardInfo getCardInfoIncorrectMonth() {
        return new CardInfo("4444 4444 4444 4441", incorrectMonth, year, faker.name().fullName(), cvc);
    }

    public static CardInfo getCardInfoShortMonth() {
        return new CardInfo("4444 4444 4444 4441", shortMonth, year, faker.name().fullName(), cvc);
    }

    public static CardInfo getCardInfoMonthZero() {
        return new CardInfo("4444 4444 4444 4441", "00", year, faker.name().fullName(), cvc);
    }

    public static CardInfo getCardInfoIncorrectYear() {
        return new CardInfo("4444 4444 4444 4441", month, incorrectYear, faker.name().fullName(), cvc);
    }

    public static CardInfo getCardInfoIncorrectCVC() {
        return new CardInfo("4444 4444 4444 4441", month, year, faker.name().fullName(), incorrectCvc);
    }

    public static CardInfo getCardInfoIncorrectName() {
        return new CardInfo("4444 4444 4444 4441", month, year, incorrectName, cvc);
    }

    @Value
    public static class CardInfo {
        private String number;
        private String month;
        private String year;
        private String holder;
        private String cvc;
    }
}
