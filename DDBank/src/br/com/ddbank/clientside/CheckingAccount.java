package br.com.ddbank.clientside;

import br.com.ddbank.clientside.exceptions.InsufficientBalanceException;

public class CheckingAccount extends Account {

     private final double ACCOUNT_DISCOUNT = 0.50;

     public CheckingAccount(int agencyNumber, int accountNumber) {
          super(agencyNumber, accountNumber, 0);
     }

     public CheckingAccount(int agencyNumber, int accountNumber, double initialBalance) {
          super(agencyNumber, accountNumber, initialBalance);
     }

     @Override
     public void withdraw(double value) throws IllegalArgumentException, InsufficientBalanceException {
          super.withdraw(value);
          this.balance -= ACCOUNT_DISCOUNT;
     }

     @Override
     public String toString() {
          return "Checking Account:\n" + super.toString();
     }
     
}