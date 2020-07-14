package com.recruitment.exercise.service.impl;

import com.recruitment.exercise.dto.NumberDTO;
import com.recruitment.exercise.exception.EntityNotFoundException;
import com.recruitment.exercise.model.Number;
import com.recruitment.exercise.repository.NumberRepository;
import com.recruitment.exercise.service.NumberService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NumberServiceImpl implements NumberService {

    private Random random = new Random();

    private NumberRepository numberRepository;

    public NumberServiceImpl(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    @Override
    public NumberDTO getRandomNumber(long id) {
        Number number = numberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Number"));
        return prepareResponse(number);
    }

    private NumberDTO prepareResponse(Number number) {
        NumberDTO numberDTO = new NumberDTO();
        long randomNumber = random.nextLong();
        numberDTO.setNumberFromDatabase(number.getValue());
        numberDTO.setRandomNumber(randomNumber);
        numberDTO.setSum(number.getValue() + randomNumber);
        return numberDTO;
    }

}
