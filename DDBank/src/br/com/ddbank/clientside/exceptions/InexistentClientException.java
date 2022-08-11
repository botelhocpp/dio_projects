package br.com.ddbank.clientside.exceptions;

public class InexistentClientException extends RuntimeException {

     public InexistentClientException() {
          super("The informed client doesn't exist!");
     }

     public InexistentClientException(String message) {
          super(message);
     }
}
