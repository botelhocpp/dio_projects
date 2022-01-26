package br.com.ddbank.clientside.exceptions;

public class InsufficientBalanceException extends RuntimeException {
     public InsufficientBalanceException() {
          super("The account does not have enough balance to complete the transaction!");
     }

     public InsufficientBalanceException(String message) {
          super(message);
     }
}