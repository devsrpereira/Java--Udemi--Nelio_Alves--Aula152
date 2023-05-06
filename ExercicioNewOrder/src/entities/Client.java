package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Client {
    private String name;
    private String email;
    private LocalDate birthDay;

    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Client(String name, String email, LocalDate birthDay) {
        this.name = name;
        this.email = email;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }


    @Override
    public String toString() {
        return "Client: "
                + name
                + " (" +dtf1.format(birthDay)+ ") - "
                + email;
    }



}
