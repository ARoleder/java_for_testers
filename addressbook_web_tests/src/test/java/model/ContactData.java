package model;

public record ContactData(String firstname, String middlename, String lastname, String nickname, String company,
                          String address, String mobilephone, String email,
                          String secondaryaddress, String home, String notes) {
    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(firstname, this.middlename, this.lastname, this.nickname, this.company, this.address, this.mobilephone, this.email, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withMiddleName(String middlename) {
        return new ContactData(this.firstname, middlename, this.lastname, this.nickname, this.company, this.address, this.mobilephone, this.email, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.firstname, this.middlename, lastname, this.nickname, this.company, this.address, this.mobilephone, this.email, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withNickname(String nickname) {
        return new ContactData(this.firstname, this.middlename, this.lastname, nickname, this.company, this.address, this.mobilephone, this.email, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withCompany(String company) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, company, this.address, this.mobilephone, this.email, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.company, address, this.mobilephone, this.email, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withMobilePhone(String mobilephone) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.company, this.address, mobilephone, this.email, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.company, this.address, this.mobilephone, email, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withSecondaryAddress(String secondaryaddress) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.company, this.address, this.mobilephone, this.email, secondaryaddress, this.home, this.notes);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.company, this.address, this.mobilephone, this.email, this.secondaryaddress, home, this.notes);
    }

    public ContactData withNotes(String notes) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.company, this.address, this.mobilephone, this.email, this.secondaryaddress, this.home, notes);
    }
}
