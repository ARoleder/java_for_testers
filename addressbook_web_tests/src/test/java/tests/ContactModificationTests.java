package tests;

import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData().withId("").withFirstName("FirstName").withLastName("LastName").withMobilePhone("8932435455"));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withFirstName("modified first name");
        app.contacts().modifyContact(oldContacts.get(index), testData);
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    void canAddContactInGroup() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData().withId("").withFirstName("FirstName").withLastName("LastName").withMobilePhone("8932435455"));
        }
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var contact = oldContacts.get(index);
        var group = app.hbm().getGroupList().get(0);
        var expectedContactListInGroup = new ArrayList<>(oldContacts);
        if (app.hbm().isContactInGroup(group, contact)) {
            app.contacts().removeContactFromGroup(contact, group);//если рандомный контакт уже добавлен в группу, то удаляем его из группы
        }
        app.contacts().addContactInGroup(group, contact);
        var newContacts = app.hbm().getContactList();
        var newContactListInGroup = new ArrayList<>(newContacts);

        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        expectedContactListInGroup.sort(compareById);
        newContactListInGroup.sort(compareById);

        Assertions.assertEquals(expectedContactListInGroup, newContactListInGroup);

    }

    @Test
    void canRemoveContactFromGroup() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData().withId("").withFirstName("FirstName").withLastName("LastName").withMobilePhone("8932435455"));
        }
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var contact = oldContacts.get(index);
        var group = app.hbm().getGroupList().get(0);
        var expectedContactListInGroup = new ArrayList<>(oldContacts);
        if (!app.hbm().isContactInGroup(group, contact)) {
            app.contacts().addContactInGroup(group, contact); //если контакт не добавлен в группу, то добавить его в группу
        }
        app.contacts().removeContactFromGroup(contact, group);
        var newContacts = app.hbm().getContactList();
        var newContactListInGroup = new ArrayList<>(newContacts);

        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        expectedContactListInGroup.sort(compareById);
        newContactListInGroup.sort(compareById);

        Assertions.assertEquals(expectedContactListInGroup, newContactListInGroup);

    }
}
