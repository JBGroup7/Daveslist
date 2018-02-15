package com.group7.daveslist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    RoomRepository roomRepository;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String mainPage(Model model){
        model.addAttribute("allrooms", roomRepository.findAll());
        return "Main";
    }


    @RequestMapping("/private")
    public String privatePage(Model model){
        model.addAttribute("allrooms", roomRepository.findAll());
        return "PrivateListing";
    }
    //processlogininfo

    @GetMapping("/form")
    public String newListing(Model model){
        model.addAttribute("room", new Room());
        return "Form";
    }


    @PostMapping("/form")
    public String processListing(@Valid @ModelAttribute("room") Room room, BindingResult result, Model model){
        if(result.hasErrors()){
            return "Form";
        }
        model.addAttribute("room", room);
        roomRepository.save(room);
        model.addAttribute("roomRepository", roomRepository);
        return "redirect:/";
    }

    @RequestMapping("/details/{id}")
    public String details(@PathVariable("id") long id, Model model) {
        Room room = roomRepository.findOne(id);
        model.addAttribute("room", room);
        return "Listing";
    }

    @RequestMapping("/update/{id}")
    public String updateListing(@PathVariable("id") long id, Model model) {
        Room room = roomRepository.findOne(id);
        model.addAttribute("room", room);
        return "Form";

    }


    @RequestMapping ("/rent/{id}")
    public String rentRoom(@PathVariable("id") long id, Model model){

        Room toberented=roomRepository.findOne(id);
        toberented.setRented(true);
        roomRepository.save(toberented);
        //model.addAttribute("room",roomRepository.findOne(id));
        return "redirect:/";
    }



    @RequestMapping ("/public/{id}")
    public String publicRoom(@PathVariable("id") long id, Model model){

        Room room =roomRepository.findOne(id);
        room.setListingType("public");
        roomRepository.save(room);
        //model.addAttribute("room",roomRepository.findOne(id));
        return "redirect:/";
    }


    @RequestMapping("/login")
    public String login(){
        return "Login";
    }


    @GetMapping("/registration")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "Registration";
    }


    @PostMapping("/registration")
    public String processUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "Registration";
        }
        userService.saveUser(user);
        return "redirect:/";
    }






}
