package com.recruitment.exercise.controller;

import com.recruitment.exercise.dto.NumberDTO;
import com.recruitment.exercise.service.NumberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numbers")
public class NumberController {

    private NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<NumberDTO> getRandomNumber(@PathVariable long id) {
        NumberDTO numberDTO = numberService.getRandomNumber(id);
        return new ResponseEntity<>(numberDTO, HttpStatus.OK);
    }
}
