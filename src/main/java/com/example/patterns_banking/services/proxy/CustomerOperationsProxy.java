package com.example.patterns_banking.services.proxy;

import com.example.patterns_banking.dtos.CustomerDTO;
import com.example.patterns_banking.models.Customer;
import com.example.patterns_banking.repositories.ICustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerOperationsProxy implements ICustomerOperations {

    private final ICustomerRepository customerRepository;

    public CustomerOperationsProxy(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(CustomerDTO customerDTO) {
        Customer customer = Customer
                .builder()
                .name(customerDTO.getName())
                .email(customerDTO.getEmail())
                .build();

        if (!validateEmail(customer.getEmail())){
            throw new IllegalArgumentException("El correo no puede ser del dominio yahoo");
        }

        return customerRepository.save(customer);
    }

    private boolean validateEmail(String email) {
        return !email.toLowerCase().matches(".*@yahoo\\..*");
    }
}
