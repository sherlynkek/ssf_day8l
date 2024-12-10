package sg.edu.nus.iss.vttp5a_day8l.model;

import java.util.Date;

public class Person {
    private Integer id;
    private String fullName;
    private String email;
    private String phone;
    private Date date;

    public Person() {
    }

    public Person(Integer id, String fullName, String email, String phone, Date date) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return id + "," + fullName + "," + email + "," + phone + "," + date;
    }

}
