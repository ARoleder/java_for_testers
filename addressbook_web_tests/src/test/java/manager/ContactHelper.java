package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openHomePage() {
        if (!manager.isElementPresent(By.id("maintable"))) {
            click(By.linkText("home"));
        }
    }

    public void openAddContactPage() {
        click(By.linkText("add new"));
    }

    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        openAddContactPage();
        fillContactForm(contact);
        submitContactCreation();
        openHomePage();
    }

    public void removeContact() {
        openHomePage();
        selectContact();
        removeSelectedContact();
        manager.driver.switchTo().alert().accept();
        openHomePage();
    }

    private void removeSelectedContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        type(By.name("company"), contact.company());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.homephone());
        type(By.name("mobile"), contact.mobilephone());
        type(By.name("work"), contact.workphone());
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());
        type(By.name("address2"), contact.secondaryaddress());
        type(By.name("phone2"), contact.home());
        type(By.name("notes"), contact.notes());
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }
}