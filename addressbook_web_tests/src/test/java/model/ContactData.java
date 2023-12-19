package model;

public record ContactData(String id,
                          String firstname,
                          String middlename,
                          String lastname,
                          String company,
                          String address,
                          String mobilephone,
                          String email,
                          String home,
                          String work,
                          String secondary,
                          String email2,
                          String email3,
                          String address2) {
    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename, this.lastname, this.company, this.address, this.mobilephone, this.email, this.home, this.work, this.secondary, this.email2, this.email3, this.address2);
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id, firstname, this.middlename, this.lastname, this.company, this.address, this.mobilephone, this.email, this.home, this.work, this.secondary, this.email2, this.email3, this.address2);
    }

    public ContactData withMiddleName(String middlename) {
        return new ContactData(this.id, this.firstname, middlename, this.lastname, this.company, this.address, this.mobilephone, this.email, this.home, this.work, this.secondary, this.email2, this.email3, this.address2);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, this.middlename, lastname, this.company, this.address, this.mobilephone, this.email, this.home, this.work, this.secondary, this.email2, this.email3, this.address2);
    }

    public ContactData withCompany(String company) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, company, this.address, this.mobilephone, this.email, this.home, this.work, this.secondary, this.email2, this.email3, this.address2);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.company, address, this.mobilephone, this.email, this.home, this.work, this.secondary, this.email2, this.email3, this.address2);
    }

    public ContactData withMobilePhone(String mobilephone) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.company, this.address, mobilephone, this.email, this.home, this.work, this.secondary, this.email2, this.email3, this.address2);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.company, this.address, this.mobilephone, email, this.home, this.work, this.secondary, this.email2, this.email3, this.address2);
    }

    //    public ContactData withPhoto(String photo) {
//        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.company, this.address, this.mobilephone, this.email, photo);
//    }
    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.company, this.address, this.mobilephone, this.email, home, this.work, this.secondary, this.email2, this.email3, this.address2);
    }

    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.company, this.address, this.mobilephone, this.email, this.home, work, this.secondary, this.email2, this.email3, this.address2);
    }

    public ContactData withSecondary(String secondary) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.company, this.address, this.mobilephone, this.email, this.home, this.work, secondary, this.email2, this.email3, this.address2);
    }

    public ContactData withEmail2(String email2) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.company, this.address, this.mobilephone, this.email, this.home, this.work, secondary, email2, this.email3, this.address2);
    }

    public ContactData withEmail3(String email3) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.company, this.address, this.mobilephone, this.email, this.home, this.work, secondary, this.email2, email3, this.address2);
    }

    public ContactData withAddress2(String address2) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.company, this.address, this.mobilephone, this.email, this.home, this.work, secondary, this.email2, this.email3, address2);
    }
}
