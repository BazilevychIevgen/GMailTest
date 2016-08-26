package com.gmail.pages;

import com.codeborne.selenide.ElementsCollection;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.hasText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by barocko on 8/22/2016.
 */

public class GMail{

    public static ElementsCollection mails = $$("[role='main'] .zA");

    @Step
    public static void send(String email, String subject) {
        $(byText("COMPOSE")).click();
        $(byName("to")).setValue(email);
        $(byName("subjectbox")).setValue(subject);
        $(byText("Send")).click();
    }

    @Step
    public static void assertMail(int index,String mailText) {
        mails.get(index).shouldHave(text(mailText));
    }

    @Step
    public static void goToSent() {
        $(byTitle("Sent Mail")).click();
    }

    @Step
    public static void search(String text) {
        $(byName("q")).setValue(text).pressEnter();
    }

    @Step
    public static void goToInbox() {
        $(byTitle("Inbox")).click();
    }

    @Step
    public static void assertMails(String... mailTexts){
        mails.shouldHave(texts(mailTexts));
    }

    @Step
    public static void refresh() {
        $(".asf").click();
    }

    @Step
    public static void visit() {
        open("http://gmail.com");
    }
}


