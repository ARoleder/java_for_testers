package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openHomePage() {
        //if (!manager.isElementPresent(By.id("maintable"))) {
        click(By.linkText("home"));
        //}
    }

    public void openAddContactPage() {
        click(By.linkText("add new"));
    }

    public void createContact(ContactData contact) {
        openAddContactPage();
        fillContactForm(contact);
        submitContactCreation();
        openHomePage();
    }

    public void createContact(ContactData contact, GroupData group) {
        openAddContactPage();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        openHomePage();
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    private void selectGroupForAdd(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
    }

    private void selectGroupFilter(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        removeSelectedContacts();
        closeAlert();
        openHomePage();
    }

    public void removeAllContacts() {
        openHomePage();
        selectAllContacts();
        removeSelectedContacts();
        closeAlert();
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openHomePage();
        initContactModification(contact);
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToHomePage();
    }

    private void removeSelectedContacts() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    private void initContactModification(ContactData contact) {
        click(By.cssSelector(String.format("a[href='edit.php?id=%s']", contact.id())));
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    private void removeSelectedContactFromGroup() {
        click(By.name("remove"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("company"), contact.company());
        type(By.name("address"), contact.address());
        type(By.name("mobile"), contact.mobilephone());
        type(By.name("email"), contact.email());
        //   attach(By.name("photo"), contact.photo());
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    public int getCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    private void selectAllContacts() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }

    private void closeAlert() {
        manager.driver.switchTo().alert().accept();
    }

    public List<ContactData> getList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var entries = manager.driver.findElements(By.name("entry"));
        for (var entry : entries) {
            var firstname = entry.findElement(By.cssSelector("td:nth-child(3)")).getText();
            var lastname = entry.findElement(By.cssSelector("td:nth-child(2)")).getText();
            var checkbox = entry.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname));
        }
        return contacts;
    }

    public void addContactInGroup(GroupData group, ContactData contact) {
        openHomePage();
        selectGroupForAdd(group);
        selectContact(contact);
        submitAddContactInGroup();
        openHomePage();
    }

    private void submitAddContactInGroup() {
        click(By.xpath("//input[@name='add']"));
    }

    public void removeContactFromGroup(ContactData contact, GroupData group) {
        openHomePage();
        selectGroupFilter(group);
        selectContact(contact);
        removeSelectedContactFromGroup();
    }

    public String getPhones(ContactData contact) {
        openHomePage();
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText().replace("\n","");
    }

    public String getEmails(ContactData contact) {
        openHomePage();
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[5]", contact.id()))).getText().replace("\n","");
    }

    public String getAddress(ContactData contact) {
        openHomePage();
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[4]", contact.id()))).getText().replace("\n","");
    }

    public Map<String, String> getPhones() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var phones = row.findElements(By.tagName("td")).get(5).getText();
            result.put(id, phones);
        }
        return result;
    }

    public String getEmailsFromEditForm(ContactData contact) {
        openHomePage();
        initContactModification(contact);
        var email = manager.driver.findElement(By.name("email")).getAttribute("value");
        var email2 = manager.driver.findElement(By.name("email2")).getAttribute("value");
        var email3 = manager.driver.findElement(By.name("email3")).getAttribute("value");
        var emailResult = email + email2  + email3;
        return emailResult;
    }
    public String getAddressesFromEditForm(ContactData contact) {
        openHomePage();
        initContactModification(contact);
        var address = manager.driver.findElement(By.name("address")).getAttribute("value");
        var address2 = manager.driver.findElement(By.name("address2")).getAttribute("value");
        var addressResult = address + address2 ;
        return addressResult;
    }

    public Object getPhonesFromEditForm(ContactData contact) {
        openHomePage();
        initContactModification(contact);
        var home = manager.driver.findElement(By.name("home")).getAttribute("value");
        var mobile = manager.driver.findElement(By.name("mobile")).getAttribute("value");
        var work = manager.driver.findElement(By.name("work")).getAttribute("value");
        var phone2 = manager.driver.findElement(By.name("phone2")).getAttribute("value");
        var emailResult = home + mobile + work + phone2;
        return emailResult;
    }

    public String getAddressFromEditForm(ContactData contact) {
        openHomePage();
        initContactModification(contact);
        var address = manager.driver.findElement(By.name("address")).getAttribute("value");
        return address;
    }
}