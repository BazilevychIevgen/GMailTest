package com.gmail.pages;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by barocko on 8/22/2016.
 */
public class Login{

    public static void login(String login, String password){
        $("#Email").val(login).pressEnter();
        $("#Passwd").val(password).pressEnter();
    }
}
