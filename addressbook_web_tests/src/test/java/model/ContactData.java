package model;

public record ContactData(String id, String firstname, String middlename, String lastname, String company,
                          String address, String mobilephone, String email, String photo
) {
    public ContactData() {
        this("", "", "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename, this.lastname, this.company, this.address, this.mobilephone, this.email, this.photo);
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id, firstname, this.middlename, this.lastname, this.company, this.address, this.mobilephone, this.email, this.photo);
    }

    public ContactData withMiddleName(String middlename) {
        return new ContactData(this.id, this.firstname, middlename, this.lastname, this.company, this.address, this.mobilephone, this.email, this.photo);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, this.middlename, lastname, this.company, this.address, this.mobilephone, this.email, this.photo);
    }

    public ContactData withCompany(String company) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, company, this.address, this.mobilephone, this.email, this.photo);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.company, address, this.mobilephone, this.email, this.photo);
    }

    public ContactData withMobilePhone(String mobilephone) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.company, this.address, mobilephone, this.email, this.photo);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.company, this.address, this.mobilephone, email, this.photo);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.company, this.address, this.mobilephone, this.email, photo);
    }
}
