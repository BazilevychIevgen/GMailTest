package com.gmail;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import com.sun.xml.internal.ws.dump.LoggingDumpTube;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;


/**
 * Created by barocko on 8/17/2016.
 */
public class BaseTest {

    @BeforeClass
    public static void openGmail(){
        open("http://gmail.com");
    }

    @BeforeClass
    public static void config() {
        Configuration.timeout = 20000;
    }

    @After
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }

}
