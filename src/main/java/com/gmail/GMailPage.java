package com.gmail;

import com.codeborne.selenide.ElementsCollection;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.hasText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by barocko on 8/22/2016.
 */

public class GMailPage {

    public static ElementsCollection mails = $$("[role='main'] .zA");

    @Step
    public static void sendMail(String email, String text) {
        $(byText("COMPOSE")).click();
        $(byName("to")).val(email);
        $(byName("subjectbox")).setValue(text);
        $(byText("Send")).click();
    }

    @Step
    public static void assertMail(int index, String mailText) {
        mails.get(index).shouldHave(text(mailText));
    }

    @Step
    public static void goToSent() {
        $(byTitle("Sent Mail")).click();
    }

    @Step
    public static void search(String text) {
        $(byName("q")).val(text).pressEnter();
    }

    @Step
    public static void assertSearchResultEqual(int number) {
        mails.shouldHaveSize(number);
    }

    public static void goToInbox() {
        $(byTitle("Inbox")).click();
    }
}


