package com.kata.arithmetic.controller;

import com.kata.arithmetic.models.ArithmeticResponse;
import com.kata.arithmetic.models.AritmeticRequest;
import com.kata.arithmetic.service.ArithmeticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="*", allowedHeaders="*")
public class ArithmeticController {
    @Autowired
    ArithmeticService arithmeticService;
    @PostMapping("/calculate")
    public ResponseEntity<ArithmeticResponse> calculate(@RequestBody AritmeticRequest expression){
        String result = arithmeticService.calculate(expression.getExpression());
        ArithmeticResponse arithmeticResponse = new ArithmeticResponse();
        arithmeticResponse.setResponse(result);
        if (result.equals("Invalid record error")){
            return new ResponseEntity<ArithmeticResponse>(arithmeticResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ArithmeticResponse>(arithmeticResponse, HttpStatus.OK);
    }
}
