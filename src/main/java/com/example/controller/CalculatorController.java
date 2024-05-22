package com.example.controller;

import com.example.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/addition")
    public ResponseEntity<?> getAddition(
            @RequestParam double a,
            @RequestParam double b) {

        String additionResponse = calculatorService.getAddition(a, b);
        return ResponseEntity.ok(additionResponse);
    }

    @GetMapping("/subtraction")
    public ResponseEntity<?> getSubtraction(
            @RequestParam double a,
            @RequestParam double b) {

        String subtractionResponse = calculatorService.getSubtraction(a, b);
        return ResponseEntity.status(HttpStatus.OK).body(subtractionResponse);
    }

    @GetMapping("/multiplication")
    public ResponseEntity<?> getMultiplication(
            @RequestParam double a,
            @RequestParam double b) {

        String multiplicationResponse = calculatorService.getMultiplication(a, b);
        return ResponseEntity.status(HttpStatus.OK).body(multiplicationResponse);
    }

    @GetMapping("/division")
    public ResponseEntity<?> getDivision(
            @RequestParam double a,
            @RequestParam double b) {

        String divisionResponse = calculatorService.getDivision(a, b);
        return ResponseEntity.status(HttpStatus.OK).body(divisionResponse);
    }

}
