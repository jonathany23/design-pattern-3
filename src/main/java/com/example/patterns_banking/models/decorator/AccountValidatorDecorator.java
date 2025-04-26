package com.example.patterns_banking.models.decorator;

import com.example.patterns_banking.models.Account;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class AccountValidatorDecorator extends AccountDecorator {
    public AccountValidatorDecorator(Account account) {
        super(account);
    }

    @Override
    public void withdraw(double amount) {
        if ((getBalance() - amount) < -20000) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        super.withdraw(amount);
    }
}
