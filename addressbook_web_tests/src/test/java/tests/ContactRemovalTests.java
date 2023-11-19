package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData().withFirstName("FirstName").withLastName("LastName").withMobilePhone("8932435455"));
        }
        app.contacts().removeContact();
    }
}
