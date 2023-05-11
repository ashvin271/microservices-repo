package com.fraud.controller;

import com.fraud.service.FraudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public class FraudController {

    private final FraudService fraudService;

    @Autowired
    public FraudController(FraudService fraudService) {
        this.fraudService = fraudService;
    }

    @GetMapping("{customerId}")
    public ResponseEntity<Boolean> IsFraudulentCustomer(@PathVariable Long customerId){
        log.info("fraud service ",customerId);
        return new ResponseEntity<Boolean>(fraudService.IsFraudulentCustomer(customerId), HttpStatus.OK);
    }
}
