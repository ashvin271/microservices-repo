package com.fraud.serviceimpl;

import com.fraud.model.FraudCheckHistory;
import com.fraud.repository.FraudRepository;
import com.fraud.service.FraudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Service
public class FraudServiceImpl implements FraudService {

    private final FraudRepository fraudRepository;

    @Autowired
    public FraudServiceImpl(FraudRepository fraudRepository) {
        this.fraudRepository = fraudRepository;
    }

    @Override
    public boolean IsFraudulentCustomer(Long customerId) {
        fraudRepository.save(
                FraudCheckHistory.builder()
                        .fraudster(false)
                        .customerId(customerId)
                        .CreatedAt(new Date())
                        .build()
        );
        return false;
    }
}
