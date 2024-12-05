package sg.edu.nus.iss.vttp5a_day8l.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class SessionData {
    @NotEmpty(message = "First name is mandatory")
    @Size(min = 5, max = 60, message = "First name miust be between 5 to 60 characters")
    private String name;

    @Past(message = "birth date must be a past date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    
    public SessionData() {
        
    }

    public SessionData(String name, Date dob) {
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

    @Override
    public String toString() {
        return name + "," + dob;
    }
    
    
}
