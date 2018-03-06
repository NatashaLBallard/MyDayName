package com.mydayname.demo;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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

//    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern="MM-dd-yyyy")
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
}
