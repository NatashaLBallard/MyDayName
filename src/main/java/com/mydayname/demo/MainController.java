package com.mydayname.demo;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


@Controller
public class MainController {

    @Autowired
    BirthdateRepository birthdateRepository;


    @RequestMapping("/")
    public String getBirthday(Model model) {
        model.addAttribute("birthdates", birthdateRepository.findAll());
        return "index";

    }


    @GetMapping("/add")
    public String bdayForm(Model model) {
        model.addAttribute("birthdate", new Birthdate());
        return "bdayform";
    }

//    @PostMapping("/process")
//    public String processInput(@Valid @ModelAttribute("birthdate") Birthdate birthdate, BindingResult result){
//        if (result.hasErrors()){
//            return "bdayform";
//        }
//
//
//        dateRepository.save(birthdate);
//        System.out.println(birthdate);
//
//        return "redirect:/";
//
//    }

    @PostMapping("/process")
    public String processInput(@Valid @ModelAttribute("birthdate") Birthdate birthdate, BindingResult result) {
        if (result.hasErrors()) {
            return "bdayform";
        }

        DateTimeFormatter longFormat = DateTimeFormatter.ofPattern("MMMM dd yyyy");
        LocalDate convertedBday = LocalDate.parse(birthdate.getBirthdayInput(), longFormat);


        birthdateRepository.save(birthdate);
//        System.out.println(birthdate);
//        System.out.println(convertedBday);

        LocalDate localDate = LocalDate.of(convertedBday.getYear(), convertedBday.getMonth(), convertedBday.getDayOfMonth());
        java.time.DayOfWeek dayofWeek = localDate.getDayOfWeek();
        birthdate.setDayInTheWeek(dayofWeek.name());
       //System.out.println(dayofWeek);
        birthdateRepository.save(birthdate);


//        Birthdate textDayOfWeek = birthdateRepository.findById(id);

        //        birthdateRepository.save(dayofWeek);

////        Prints out today's day
//        Date dayOfTheWeek = new Date();
//        SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("EEEE");
//        System.out.println(simpleDateFormat.format(dayOfTheWeek));

        return "redirect:/";
    }


    @RequestMapping("/dayname/{id}")
    public String findDayName(@PathVariable("id") long id, Model model) {
        model.addAttribute("birthdate", birthdateRepository.findById(id));

        Birthdate birthdate = birthdateRepository.findById(id);

        //MONDAY
        {
            if (birthdate.getDayInTheWeek().equalsIgnoreCase("MONDAY") && birthdate.getGender().equalsIgnoreCase("Male")) {
                birthdate.setDayName("Kojo");
                model.addAttribute("adddayname", birthdateRepository.findById(id));
            } else if (birthdate.getDayInTheWeek().equalsIgnoreCase("MONDAY") && birthdate.getGender().equalsIgnoreCase("Female")){
                birthdate.setDayName("Adoja");
                model.addAttribute("adddayname", birthdateRepository.findById(id));
            }
            else if (birthdate.getDayInTheWeek().equalsIgnoreCase("TUESDAY") && birthdate.getGender().equalsIgnoreCase("Male")) {
                birthdate.setDayName("Kwabena");
                model.addAttribute("adddayname", birthdateRepository.findById(id));
            } else if (birthdate.getDayInTheWeek().equalsIgnoreCase("TUESDAY") && birthdate.getGender().equalsIgnoreCase("Female")){
                birthdate.setDayName("Abena");
                model.addAttribute("adddayname", birthdateRepository.findById(id));
            }
            else {
                System.out.println("nada");
            }
        }


//        //TUESDAY
//        {
//            if (birthdate.getDayInTheWeek().equalsIgnoreCase("TUESDAY") && birthdate.getGender().equalsIgnoreCase("Male")) {
//                birthdate.setDayName("Kwabena");
//                model.addAttribute("adddayname", birthdateRepository.findById(id));
//            } else {
//                birthdate.setDayName("Abena");
//                model.addAttribute("adddayname", birthdateRepository.findById(id));
//            }
//        }

        birthdate.setDayInTheWeek(birthdate.dayInTheWeek);
        birthdate.setDayName(birthdate.dayName);
        birthdateRepository.save(birthdate);


        System.out.println(birthdate);

        return  "redirect:/";

        }





        }




//    @RequestMapping("/gendermale/{id}")
//    public String findDayName(@PathVariable("id") long id,Model model){
//        model.addAttribute("birthdate",birthdateRepository.findById(id));
//
//        Birthdate birthdate=birthdateRepository.findById(id);
//
//        birthdate.setGender("Male");
//
//        model.addAttribute("anItem", birthdateRepository.findById(id));
//        birthdateRepository.save(birthdate);
//        birthdateRepository.save(gender);
//
//
//
//        if (dayofWeek == DayOfWeek.MONDAY ) {
//            System.out.println("Kojo");
//
//        }
//
//        return "redirect:/";
//    }




//
//        if (dayofWeek == DayOfWeek.MONDAY && birthdate.getGender == "Male") {
//        System.out.println("Kojo");
//        model.addAttribute()
//
//    }
//        else {
//        System.out.println("Adoja");





        //    public static void main(String[] args) {
        //Get the current time
//        LocalDateTime rightNow = LocalDateTime.now();
//        //Date from the user
//        LocalDate userDate = null;

        //Set up formatters so that you can use them later
//        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//        DateTimeFormatter shortMonthFormat = DateTimeFormatter.ofPattern("MMM dd yyyy");
//        DateTimeFormatter longFormat = DateTimeFormatter.ofPattern("MMMM dd yyyy");

        //Time formatter (time only)
//        DateTimeFormatter hr24 = DateTimeFormatter.ofPattern("kk:m");

        //Output today's date in formats that have been preset
//            System.out.println("The current date is: " + rightNow.format(longFormat));
//            System.out.println("This is the current date and time unformatted: " + rightNow);

        //Output the current time in formats that have been preset
//            System.out.println("This is the current system time: " + LocalTime.now());
//            System.out.println("This is the current system time (24 h format): " + LocalTime.now().format(hr24));


//        do {
////            System.out.println("Enter a date in the past(dd/mm/yyyy)");
//            try {
//
//                userDate = LocalDate.parse(getBirthday().nextLine(), dTF);
//
//            } catch (Exception e) {
//                if (userDate.isAfter(LocalDate.now()) && userDate != null)
//                    System.out.println("The date must be in the past");
//
//                System.out.println("Unable to convert the string you entered to date. Please try again!");
//
//            }
//        } while (userDate == null);


//
//            String inputBday = "";
//            String birthday = "";

//            Scanner keyboard = new Scanner(System.in);
//            System.out.println("Enter birthday in MM/DD/YYYY format: " + birthday);
//            birthday = keyboard.next();
//
//            System.out.println("Your birthday is : " + userDate.format(shortMonthFormat));
//
//            return birthday ;











