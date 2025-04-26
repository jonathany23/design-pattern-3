package com.example.patterns_banking.services;

import com.example.patterns_banking.dtos.CustomerDTO;
import com.example.patterns_banking.models.Customer;
import com.example.patterns_banking.repositories.CustomerRepository;
import com.example.patterns_banking.repositories.ICustomerRepository;
import com.example.patterns_banking.services.proxy.IAccountOperations;
import com.example.patterns_banking.services.proxy.ICustomerOperations;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  private final ICustomerOperations proxy;

  public CustomerService(ICustomerOperations proxy) {
    this.proxy = proxy;
  }

  public Customer create(CustomerDTO customerDTO) {

    // Implementar proxy para verificar que el correo no sea del dominio yahoo
    return proxy.create(customerDTO);
  }
}
