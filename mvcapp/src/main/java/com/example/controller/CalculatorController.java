package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    public String showForm() {
        return "index";
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public ModelAndView calculate(
            @RequestParam("num1") double num1,
            @RequestParam("num2") double num2,
            @RequestParam("operation") String operation) {

        ModelAndView mv = new ModelAndView();
        double result = 0;

        switch (operation) {
            case "add" -> result = num1 + num2;
            case "subtract" -> result = num1 - num2;
            case "multiply" -> result = num1 * num2;
            case "divide" -> {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    mv.addObject("error", "Cannot divide by zero");
                    mv.setViewName("index");
                    return mv;
                }
            }
            default -> {
                mv.addObject("error", "Invalid operation");
                mv.setViewName("index");
                return mv;
            }
        }

        mv.addObject("result", result);
        mv.setViewName("result");
        return mv;
    }
}