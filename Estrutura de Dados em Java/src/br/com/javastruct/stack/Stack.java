package br.com.javastruct.stack;

import br.com.javastruct.node.Node;

public class Stack<E> {

     private Node<E> stackTop;

     public Stack() {

     }

     public Stack(E firstElement) {
          this.stackTop = new Node<E>(firstElement);
     }

     public void push(E value) {
          Node<E> node = new Node<E>(value);
          node.setNext(stackTop);
          this.stackTop = node;
     }

     public E pop() {
          try {
               Node<E> stackTop = this.stackTop;
               this.stackTop = this.stackTop.getNext();
               return stackTop.getContent();
          }
          catch(NullPointerException e) {
               throw new EmptyStackException();
          }
     }

     public E top() {
          if(this.isEmpty()) {
               throw new EmptyStackException();
          }
          return this.stackTop.getContent();
     }

     public boolean isEmpty() {
          return this.stackTop == null;
     }

     @Override
     public String toString() {
          StringBuilder stackElements = new StringBuilder("Stack [ ");

          Node<E> currentNode = this.stackTop;
          while(currentNode != null) {
               stackElements.append(currentNode.getContent() + ", ");
               currentNode = currentNode.getNext();
          }

          return stackElements
          .replace(stackElements.length() - 2, stackElements.length() - 1, " ]")
          .toString();
     }
}