package manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "addressbook")
public class ContactRecord {

    @Id
    public int id;
    public String firstname;
    public String middlename;
    public String lastname;
    public String company;
    public String address;
    @Column(name = "mobile")
    public String mobilephone;
    public String email;
    public String nickname = new String();
    public String title = new String();
    public String home = new String();
    public String work = new String();
    public String fax = new String();
    public String email2 = new String();
    public String email3 = new String();
    public String im = new String();
    public String im2 = new String();
    public String im3 = new String();
    public String homepage = new String();
    public Integer bday = 0;
    public String bmonth = new String();
    public String byear = new String();
    public Integer aday = 0;
    public String amonth = new String();
    public String ayear = new String();
    public String address2 = new String();
    public String phone2 = new String();
    public String notes = new String();
  //  public Date deprecated = new Date();

    public ContactRecord() {
    }

    public ContactRecord(int id, String firstname, String middlename, String lastname, String company, String address, String mobile, String email) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.company = company;
        this.address = address;
        this.mobilephone = mobile;
        this.email = email;
    }
}
