package com.mydayname.demo;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Birthdate {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=6)
    private String birthdayInput;

    @Column
    @Temporal(value=TemporalType.DATE)
//    @DateTimeFormat(pattern="MM-dd-yyyy")
    private Date convertedBday;



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


    public Date getConvertedBday() {
        return convertedBday;
    }

    public void setConvertedBday(Date convertedBday) {
        this.convertedBday = convertedBday;
    }

    //Use this to get the input from "birthdate" and display it in String form
    @Override
    public String toString() {
        return "Birthdate{" +
                "birthdayInput='" + birthdayInput + '\'' +
                '}';
    }
}
