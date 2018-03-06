package com.mydayname.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


@Controller
public class MainController {

    @Autowired
    DateRepository dateRepository;



    @RequestMapping("/")
    public String getBirthday(Model model) {
        model.addAttribute("dates", dateRepository.findAll());
        return "index";

    }


    @GetMapping("/add")
    public String bdayForm(Model model){
        model.addAttribute("date", new Date());
        return "bdayform";
    }

    @PostMapping("/process")
    public String processInput(@Valid Date date, BindingResult result){
        if (result.hasErrors()){
            return "bdayform";
        }

        dateRepository.save(date);
        return "redirect:/";
    }








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


        }






