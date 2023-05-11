package com.customer.serviceimpl;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import com.microservice.app.clients.comman.bean.NotificationRequest;
import com.microservice.app.clients.fraud.FraudClient;
import com.microservice.app.clients.notification.NotificationClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

    private final NotificationClient notificationClient;

    @Override
    public void customerRegister(Customer customer) {
       Customer customerObj= customerRepository.saveAndFlush(customer);
       log.info("fraud service calling ");

       // for now we not use restTemplate
       // boolean isPresent = restTemplate.getForObject("http://fraud/api/v1/faurd-check/"+customerObj.getId(), Boolean.class);

        //now we use fraudClient
        boolean response= fraudClient.IsFraudulentCustomer(customerObj.getId());

        if(response){

        }

        // notification service
        log.info("notification service calling ");
        notificationClient.setNotificationRequest(
                new NotificationRequest(
                        customerObj.getId(),
                        customerObj.getEmail(),
                        String.format("Hi %s welcome to microservices",customerObj.getFirstName()),
                        customerObj.getFirstName()
                )
        );
    }
}
