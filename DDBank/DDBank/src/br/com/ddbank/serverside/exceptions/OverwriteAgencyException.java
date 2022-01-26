package br.com.ddbank.serverside.exceptions;

public class OverwriteAgencyException extends RuntimeException {
     public OverwriteAgencyException() {
          super("The informed account already exists!");
     }

     public OverwriteAgencyException(String message) {
          super(message);
     }
}
