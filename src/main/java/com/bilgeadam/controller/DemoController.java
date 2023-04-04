package com.bilgeadam.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {
    @GetMapping("/getname")
    public ModelAndView demo(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("name","emre");
        modelAndView.setViewName("demo");
        return modelAndView;
    }
}
