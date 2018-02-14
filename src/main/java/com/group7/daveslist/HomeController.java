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

    @RequestMapping("/")
    public String mainPage(Model model){
        model.addAttribute("allrooms", roomRepository.findAll());
        return "Main";
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

    @RequestMapping("/login")
    public String login(){
        return "Login";
    }



}
