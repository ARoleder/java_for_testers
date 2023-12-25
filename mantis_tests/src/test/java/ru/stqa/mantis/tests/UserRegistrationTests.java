package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.UserData;

import java.time.Duration;

public class UserRegistrationTests extends TestBase {

    @Test
    void  canRegisterUser () {
        String username = CommonFunctions.randomString(8);
        var email = String.format("%s@localhost", username);
        //создать пользователя на почтовом сервере (jameshelper)
        app.jamesCli().addUser(email, "password");
        //заполняем форму создания и отправляем (браузер)
        app.session().signup(username, email);
        //ждем почту (mailhelper)
        //извлекаем ссылку из письма
        var messages = app.mail().receive(email, "password", Duration.ofSeconds(10));
        var text = messages.get(0).content();
        var url = CommonFunctions.extractUrl(text);
        //переходим по ссылке из письма и завершаем регистрацию (браузер)
        app.session().finishRegistration(url, username, "password");
        //проверяем, что пользователь может залогиниться(httpsessionhelper)
        app.session().login(username, "password");
        Assertions.assertTrue(app.session().isLoggedIn());
    }

    @Test
    void  canRegisterUserApi () {
        String username = CommonFunctions.randomString(8);
        var email = String.format("%s@localhost", username);
        //создание пользователя на почтовом сервере (jameshelper) с использованием REST API
        app.jamesApi().addUser(email, "password");
        //регистрация нового пользователя в Mantis, используя REST API
        app.rest().startRegistration(new UserData()
                .withUserName(username)
                .withEmail(email));
        //извлекаем ссылку из письма
        var messages = app.mail().receive(email, "password", Duration.ofSeconds(10));
        var text = messages.get(0).content();
        var url = CommonFunctions.extractUrl(text);
        //переходим по ссылке из письма и завершаем регистрацию (браузер)
        app.session().finishRegistration(url, username, "password");
        //проверяем, что пользователь может залогиниться(httpsessionhelper)
        app.http().login(username, "password");
        Assertions.assertTrue(app.http().isLoggedIn());
    }
}
