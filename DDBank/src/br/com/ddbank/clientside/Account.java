package br.com.ddbank.clientside;

import br.com.ddbank.clientside.exceptions.InsufficientBalanceException;

public abstract class Account {
     protected int agencyNumber;
     protected int accountNumber;
     protected double balance;
     
     public Account(int agencyNumber, int accountNumber, double initialBalance) {
          this.setAgencyNumber(agencyNumber);
          this.setAccountNumber(accountNumber);
          this.setBalance(initialBalance);
     }

     @Override
     public String toString() {
          return String.format("Agency Number: %04d%n" +
                              "Account Number: %08d%n" +
                              "Current Balance: $%.2f%n",
                              this.agencyNumber, this.accountNumber, this.balance);
     }

     // ------------------------------------------------------------------------
     // Agency Management
     // ------------------------------------------------------------------------

     public void withdraw(double value) throws IllegalArgumentException, InsufficientBalanceException {
          if(value <= 0) {
               throw new IllegalArgumentException("The value entered is invalid!");
          }
          else if(this.balance < value) {
               throw new InsufficientBalanceException();
          }
          this.balance -= value;
     }

     public void deposit(double value) throws IllegalArgumentException {
          if(value <= 0) {
               throw new IllegalArgumentException("The value entered is invalid!");
          }
          this.balance -= value;
     }

     public void transfer(Account target, double value) throws IllegalArgumentException, InsufficientBalanceException {
          this.withdraw(value);
          target.deposit(value);
     }

     // ------------------------------------------------------------------------
     // Getters
     // ------------------------------------------------------------------------

     public int getAgencyNumber() {
          return agencyNumber;
     }

     public int getAccountNumber() {
          return accountNumber;
     }

     public double getBalance() {
          return balance;
     }

     // ------------------------------------------------------------------------
     // Setters
     // ------------------------------------------------------------------------

     private void setAgencyNumber(int agencyNumber) {
          if(agencyNumber < 0) {
               throw new IllegalArgumentException("Invalid Agency Number!");
          }
          this.agencyNumber = agencyNumber;
     }

     private void setAccountNumber(int accountNumber) {
          if(accountNumber < 0) {
               throw new IllegalArgumentException("Invalid Account Number!");
          }
          this.accountNumber = accountNumber;
     }

     private void setBalance(double balance) {
          if(accountNumber < 0) {
               throw new IllegalArgumentException("Invalid Value for Balance!");
          }
          this.balance = balance;
     }

     
}
