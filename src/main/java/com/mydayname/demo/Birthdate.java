package com.mydayname.demo;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Birthdate extends Date{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=6)
    private String birthdayInput;

    @Column
 //   @Temporal(value=TemporalType.DATE)
//    @DateTimeFormat(pattern="MM-dd-yyyy")
    private String convertedBday;


    @Column
    @NotNull
    public String gender;


    public String dayName;

    public String dayInTheWeek;



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


    public String getConvertedBday() {
        return convertedBday;
    }

    public void setConvertedBday(String convertedBday) {
        this.convertedBday = convertedBday;
    }

    //Use this to get the input from "birthdate" and display it in String form
    @Override
    public String toString() {
        return "Birthdate{" +
//                "id='" + id + '\'' +
                "birthdayInput='" + birthdayInput + '\'' +
                "gender='" + gender + '\'' +
                '}';
    }



    public String getDateTimeFormatter() {

//        DateTimeFormatter longFormat = DateTimeFormatter.ofPattern("MMMM dd yyyy");
//        convertedBday = LocalDate.parse(getBirthdayInput(), longFormat);

        return convertedBday.toString();
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getDayInTheWeek() {
        return dayInTheWeek;
    }

    public void setDayInTheWeek(String dayInTheWeek) {
        this.dayInTheWeek = dayInTheWeek;
    }
}
