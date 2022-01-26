package br.com.ddbank.serverside.exceptions;

public class InexistentAgencyException extends RuntimeException {

     public InexistentAgencyException() {
          super("The informed agency doesn't exist!");
     }

     public InexistentAgencyException(String message) {
          super(message);
     }
}
