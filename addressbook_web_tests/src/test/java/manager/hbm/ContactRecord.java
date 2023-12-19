package manager.hbm;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

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
    public String home;
    public String work;
    public String fax = new String();
    public String email2;
    public String email3;
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
    public String address2;
    public String phone2;
    public String notes = new String();
    //  public Date deprecated = new Date();

    @ManyToMany
    @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    public List<GroupRecord> groups;

    public ContactRecord() {
    }

    public ContactRecord(int id, String firstname, String middlename, String lastname, String company, String address, String mobile, String email, String home, String work, String phone2, String email2, String email3, String address2) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.company = company;
        this.address = address;
        this.mobilephone = mobile;
        this.email = email;
        this.home = home;
        this.work = work;
        this.phone2 = phone2;
        this.email2 = email2;
        this.email3 = email3;
        this.address2 = address2;
    }
}
