package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;

public class UserRegistrationTests extends TestBase {

    @Test
    void  canRegisterUser(String userName) {
        var email = String.format("%s@localhost", userName);
        //создать пользователя на почтовом сервере (jameshelper)
        //заполняем форму создания и отправляем (браузер)
        //ждем почту (mailhelper)
        //извлекаем ссылку из письма
        //переходим по ссылке из письма и завершаем регистрацию (браузер)
        //проверяем, что пользователь может залогиниться(httpsessionhelper)
    }
}
