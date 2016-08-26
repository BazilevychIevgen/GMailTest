package com.gmail;

/**
 * Created by barocko on 8/22/2016.
 */
import com.codeborne.selenide.Configuration;
import com.gmail.pages.GMail;
import com.gmail.pages.Login;
import com.gmail.testconfigs.BaseTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static com.codeborne.selenide.Selenide.open;
import static com.gmail.pages.GMail.*;
import static com.gmail.pages.Login.*;
import static com.gmail.testdata.TestData.email;
import static com.gmail.testdata.TestData.password;
import static org.junit.Assert.assertEquals;

/**
 * Created by barocko on 8/17/2016.
 */
public class GMailTest extends BaseTest {

    @BeforeClass
    public static void config() {
        Configuration.timeout = 20000;
    }

    @Test
    public void  testLoginSendReceiveAndSearch() {

        GMail.visit();

        Login.login(email, password);

        String mailSubject = "Hi" + new Date().getTime();
        GMail.send(email, mailSubject);

        GMail.refresh();
        GMail.assertMail(0,mailSubject);

        GMail.goToSent();
        GMail.assertMail(0,mailSubject);

        GMail.goToInbox();
        GMail.search(mailSubject);
        GMail.assertMails(mailSubject);
    }

}


