package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.contacts().createContact(new ContactData("Ivanov", "Ivanovich", "Ivan", "Ivashka", "Innovative", "Address", "5674", "89992435443", "858584333", "gsf@mail.ru", "hhh@gmail.com", "trew@yandex.ru", "secondary address", "home", "notes"));
    }

    @Test
    public void canCreateEmptyContact() {

        app.contacts().createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithFirstNameOnly() {

        app.contacts().createContact(new ContactData().withFirstName("FirstName"));
    }

    @Test
    public void canCreateContactWithMainFields() {

        app.contacts().createContact(new ContactData().withFirstName("FirstName").withLastName("LastName").withMobilePhone("89990876655"));
    }
}
