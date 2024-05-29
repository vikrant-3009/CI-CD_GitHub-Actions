package com.example.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorControllerTest {

    @Test
    public void testCalculateAddition() {
        ModelAndView mv = new CalculatorController().calculate(10, 20, "add");
        assertEquals("result", mv.getViewName());
        assertEquals(30.000, mv.getModel().get("result"));
    }

    @Test
    public void testCalculateSubtraction() {
        ModelAndView mv = new CalculatorController().calculate(20, 10, "subtract");
        assertEquals("result", mv.getViewName());
        assertEquals(10.0, mv.getModel().get("result"));
    }

    @Test
    public void testCalculateMultiplication() {
        ModelAndView mv = new CalculatorController().calculate(10, 20, "multiply");
        assertEquals("result", mv.getViewName());
        assertEquals(200.0, mv.getModel().get("result"));
    }

    @Test
    public void testCalculateDivision() {
        ModelAndView mv = new CalculatorController().calculate(20, 10, "divide");
        assertEquals("result", mv.getViewName());
        assertEquals(2.0, mv.getModel().get("result"));
    }

    @Test
    public void testCalculateDivisionByZero() {
        ModelAndView mv = new CalculatorController().calculate(10, 0, "divide");
        assertEquals("index", mv.getViewName());
        assertEquals("Cannot divide by zero", mv.getModel().get("error"));
    }

    @Test
    public void testCalculateInvalidOperation() {
        ModelAndView mv = new CalculatorController().calculate(10, 20, "invalid");
        assertEquals("index", mv.getViewName());
        assertEquals("Invalid operation", mv.getModel().get("error"));
    }
}