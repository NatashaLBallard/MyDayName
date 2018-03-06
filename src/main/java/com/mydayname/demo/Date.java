package com.mydayname.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Date {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=6)
    private String birthdayInput;

    public String getBirthdayInput() {
        return birthdayInput;
    }

    public void setBirthdayInput(String birthdayInput) {
        this.birthdayInput = birthdayInput;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
