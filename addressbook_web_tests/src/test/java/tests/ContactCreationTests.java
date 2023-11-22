package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "first name")) {
            for (var middlename : List.of("", "middle name")) {
                for (var lastname : List.of("", "last name")) {
                    for (var nickname : List.of("", "nikname")) {
                        for (var company : List.of("", "company")) {
                            for (var address : List.of("", "address")) {
                                for (var mobilephone : List.of("", "mobilephone", "89098765551")) {
                                    for (var email : List.of("", "email")) {
                                        for (var secondaryaddress : List.of("", "secondaryaddress")) {
                                            for (var home : List.of("", "nikname")) {
                                                for (var notes : List.of("", "notes")) {
                                                    result.add(new ContactData(firstname, middlename, lastname, nickname, company, address, mobilephone, email, secondaryaddress, home, notes));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData().withFirstName(randomString(i * 5)).withLastName(randomString(i * 5)).withMobilePhone("89990876655"));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("first name'", "", "", "", "", "", "", "", "", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContacts(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount, newContactCount);
    }
}
