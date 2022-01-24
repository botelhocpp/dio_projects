package br.com.javastruct.list;

public class EmptyListException extends RuntimeException {
          
     public EmptyListException(){
          super("The list is empty.");
     }

     public EmptyListException(String message){
          super(message);
     }
}
