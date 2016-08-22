package com.gmail;

/**
 * Created by barocko on 8/22/2016.
 */
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Date;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.gmail.GMailPage.*;
import static com.gmail.LoginPage.*;
import static com.gmail.TestData.email;
import static com.gmail.TestData.password;
import static org.junit.Assert.assertEquals;

/**
 * Created by barocko on 8/17/2016.
 */
public class GMailSendAndReceiveTest extends BaseTest {

    @Test
    public void testGmail() {

        openGmail();

        login(email,password);

        sendMail(email, "Hello");

        goToInbox();
        assertMail(0, "Hello");

        goToSent();

        assertMail(0,"Hello");

        goToInbox();
        search("Hello");

        assertSearchResultEqual(1);
        assertMail(0, "Hello");
    }

}


