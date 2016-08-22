package com.gmail;

/**
 * Created by barocko on 8/22/2016.
 */
import org.junit.Test;

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


