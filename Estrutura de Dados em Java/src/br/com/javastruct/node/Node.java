package br.com.javastruct.node;

/**
 * A node that encapsulate a generic-type value! Made
 * for the Cognizant Bootcamp.
 * 
 * @author Pedro M. Botelho
 */
public class Node<T> {
     
     private T content;
     private Node<T> nextNode;

     public Node() {
          
     }

     public Node(T content) {
          this.content = content;
     }

     public T getContent() {
          return this.content;
     }

     public void setContent(T content) {
          this.content = content;
     }

     public Node<T> getNext() {
          return this.nextNode;
     }

     public void setNext(Node<T> nextNode) throws IllegalArgumentException {
          this.nextNode = nextNode;
     }

     @Override
     public String toString() {
          return "Node [ Content = " + this.content + " ]";
     }
     
}