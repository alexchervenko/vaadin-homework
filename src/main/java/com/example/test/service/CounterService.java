package com.example.test.service;

import com.example.test.model.Counter;
import com.example.test.repository.CounterRepository;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
    private final CounterRepository counterRepository;

    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public void save(Counter counter){
        counterRepository.save(counter);
    }
}
