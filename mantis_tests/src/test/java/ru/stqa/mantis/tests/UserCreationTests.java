package ru.stqa.mantis.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.DeveloperMailUser;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserCreationTests extends  TestBase {

    DeveloperMailUser user;

    @Test
    void canCreateUser () {
        var password = "password";
        user = app.developerMail().addUser();
        var email = String.format("%s@developermail.com", user.name());

//        app.session().signup(username, email);
//
//        var messages = app.mail().receive(email, "password", Duration.ofSeconds(10));
//        var text = messages.get(0).content();
//        var pattern = Pattern.compile("http://\\S*");
//        var matcher = pattern.matcher(text);
//        var url = "";
//        if (matcher.find()) {
//            url = text.substring(matcher.start(), matcher.end());
//        }
//
//        app.session().finishRegistration(url, username, "password");
//        app.http().login(username, "password");
//        Assertions.assertTrue(app.http().isLoggedIn());
    }
    @AfterEach
    void deleteMailUser(){

        app.developerMail().deleteUser(user);
    }
}
