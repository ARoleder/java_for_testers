package model;

public record ContactData(String firstname, String middlename, String lastname, String nickname, String company,
                          String address, String homephone, String mobilephone, String workphone, String email,
                          String email2, String email3, String secondaryaddress, String home, String notes) {
    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(firstname, this.middlename, this.lastname, this.nickname, this.company, this.address, this.homephone, this.mobilephone, this.workphone, this.email, this.email2, this.email3, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withMiddleName(String middlename) {
        return new ContactData(this.firstname, middlename, this.lastname, this.nickname, this.company, this.address, this.homephone, this.mobilephone, this.workphone, this.email, this.email2, this.email3, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.firstname, this.middlename, lastname, this.nickname, this.company, this.address, this.homephone, this.mobilephone, this.workphone, this.email, this.email2, this.email3, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withNickname(String nickname) {
        return new ContactData(this.firstname, this.middlename, this.lastname, nickname, this.company, this.address, this.homephone, this.mobilephone, this.workphone, this.email, this.email2, this.email3, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withCompany(String company) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, company, this.address, this.homephone, this.mobilephone, this.workphone, this.email, this.email2, this.email3, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.company, address, this.homephone, this.mobilephone, this.workphone, this.email, this.email2, this.email3, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withHomePhone(String homephone) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.company, this.address, homephone, this.mobilephone, this.workphone, this.email, this.email2, this.email3, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withMobilePhone(String mobilephone) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.company, this.address, this.homephone, mobilephone, this.workphone, this.email, this.email2, this.email3, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withWorkPhone(String workphone) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.company, this.address, this.homephone, this.mobilephone, workphone, this.email, this.email2, this.email3, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.company, this.address, this.homephone, this.mobilephone, this.workphone, email, this.email2, this.email3, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withEmail2(String email2) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.company, this.address, this.homephone, this.mobilephone, this.workphone, this.email, email2, this.email3, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withEmail3(String email3) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.company, this.address, this.homephone, this.mobilephone, this.workphone, this.email, this.email2, email3, this.secondaryaddress, this.home, this.notes);
    }

    public ContactData withSecondaryAddress(String secondaryaddress) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.company, this.address, this.homephone, this.mobilephone, this.workphone, this.email, this.email2, this.email3, secondaryaddress, this.home, this.notes);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.company, this.address, this.homephone, this.mobilephone, this.workphone, this.email, this.email2, this.email3, this.secondaryaddress, home, this.notes);
    }

    public ContactData withNotes(String notes) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.company, this.address, this.homephone, this.mobilephone, this.workphone, this.email, this.email2, this.email3, this.secondaryaddress, this.home, notes);
    }
}
