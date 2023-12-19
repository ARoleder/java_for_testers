package tests;

import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {

    @Test //тест для проверки всех телефонов. Сравниваются телефоны с главной страницы и из БД
    void testAllPhonesOnHomePage() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData()
                    .withFirstName(CommonFunctions.randomString(10))
                    .withLastName(CommonFunctions.randomString(10))
                    .withHome("102394")
                    .withWork("9988374")
                    .withMobilePhone("123456"));
        }
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
            Stream.of(contact.home(), contact.mobilephone(), contact.work(), contact.secondary())
                    .filter(s -> s != null && !"".equals(s)) //пропускаем пустые телефоны
                    .collect(Collectors.joining("\n"))
        ));
        var phones = app.contacts().getPhones();
        Assertions.assertEquals(expected,phones);
    }

    @Test //дз 16
    void testOneContactOnHomePage() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData()
                    .withFirstName(CommonFunctions.randomString(10))
                    .withLastName(CommonFunctions.randomString(10))
                    .withEmail("g@mmaio")
                    .withEmail2("dkdj@test")
                    .withHome("102394")
                    .withWork("9988374")
                    .withAddress("dda")
                    .withAddress2("jjs du")
                    .withMobilePhone("123456"));
        }
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var phonesOnHomePage = app.contacts().getPhones(contact);
        var phonesInEditForm = app.contacts().getPhonesFromEditForm(contact);
        Assertions.assertEquals(phonesOnHomePage, phonesInEditForm); //сравнение телефонов на главной и в форме ввода

        var emailsOnHomePage = app.contacts().getEmails(contact);
        var emailsInEditForm = app.contacts().getEmailsFromEditForm(contact);
        Assertions.assertEquals(emailsOnHomePage, emailsInEditForm); //сравнение емейла на главной странице и в форме ввода

        var addressesInEditForm = app.contacts().getAddressesFromEditForm(contact);
        var expectedAddressesFromDb =  Stream.of(contact.address(), contact.address2())
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining()); //переноса на другую строку не требуется, так как в получении адреса из формы ввода getAddressesFromEditForm добавлено удаление переносов
        Assertions.assertEquals(expectedAddressesFromDb, addressesInEditForm); //сравнение обоих адресов с теми, что в БД и с формой ввода. Так как оба адреса нельзя сравнить с адресами на главной

        var addressOnHomePage = app.contacts().getAddress(contact);
        var addressInEditForm = app.contacts().getAddressFromEditForm(contact);
        Assertions.assertEquals(addressOnHomePage, addressInEditForm);//сравнение одного адреса на главной и в форме ввода
    }


    @Test //оставила для себя самый начальный вариант
    void testEmails() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData()
                    .withFirstName(CommonFunctions.randomString(10))
                    .withLastName(CommonFunctions.randomString(10))
                    .withEmail("g@mmaio")
                    .withEmail2("dda")
                    .withMobilePhone("123456"));
        }
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var email = app.contacts().getEmails(contact);
        var expected = Stream.of(contact.email(), contact.email2(), contact.email3())
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, email);
    }
}
