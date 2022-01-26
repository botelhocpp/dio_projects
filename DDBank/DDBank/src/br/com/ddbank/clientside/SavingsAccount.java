package br.com.ddbank.clientside;

public class SavingsAccount extends Account  {

     private final double ACCOUNT_INCOME = 0.05;

     public SavingsAccount(int agencyNumber, int accountNumber) {
          super(agencyNumber, accountNumber, 0);
     }

     public SavingsAccount(int agencyNumber, int accountNumber, double initialBalance) {
          super(agencyNumber, accountNumber, initialBalance);
     }

     @Override
     public void deposit(double value) throws IllegalArgumentException {
          super.deposit(value);
          this.balance *= ACCOUNT_INCOME;
     }

     @Override
     public String toString() {
          return "Savings Account:\n" + super.toString();
     }
     
}
