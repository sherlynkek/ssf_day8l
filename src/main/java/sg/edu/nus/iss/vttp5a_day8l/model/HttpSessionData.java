package sg.edu.nus.iss.vttp5a_day8l.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class HttpSessionData {
    private String name;

    // need to put this validation to use Date
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    // if use local date then no need to do the #dates in the sessionList.html

    public HttpSessionData() {
    }

    public HttpSessionData(String name, Date dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
}