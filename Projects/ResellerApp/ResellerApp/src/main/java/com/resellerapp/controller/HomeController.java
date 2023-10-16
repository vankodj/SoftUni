package com.resellerapp.controller;

import com.resellerapp.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final OfferService offerService;

    public HomeController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/")
public String index(){
    return "index";
    }

    @GetMapping("/home")
    public ModelAndView home(){

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("offerHomeDTO",);
        return new ModelAndView("home");
    }
}
