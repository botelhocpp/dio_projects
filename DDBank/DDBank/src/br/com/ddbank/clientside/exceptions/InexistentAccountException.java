package br.com.ddbank.clientside.exceptions;

public class InexistentAccountException extends RuntimeException {

     public InexistentAccountException() {
          super("The informed account doesn't exist!");
     }

     public InexistentAccountException(String message) {
          super(message);
     }
}
