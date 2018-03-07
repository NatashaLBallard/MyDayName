package com.mydayname.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)


public class HoroscopeDayValue {

    private Date date;
    private String horoscope;
    private String sunsign;

    private String convertTodaysDate;


    public HoroscopeDayValue() {
    }


    public Date getDate() {
//        DateTimeFormatter dMY = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//        Date dateForDailyHoroscope = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
//        System.out.println(simpleDateFormat.format(dMY));
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }

    public String getSunsign() {
        return sunsign;
    }

    public void setSunsign(String sunsign) {
        this.sunsign = sunsign;
    }


    @Override
    public String toString(){
        return "Value{" +
                "date='" + date +'\'' +
                "horoscope='" + horoscope +'\'' +
                "sunsign='" + sunsign +'\'' +
                '}';
    }

    public String getConvertTodaysDate() {
        return convertTodaysDate;
    }

    public void setConvertTodaysDate(String convertTodaysDate) {
        this.convertTodaysDate = convertTodaysDate;
    }

    public String getDateTimeFormatter() {


        return convertTodaysDate.toString();
    }

}


