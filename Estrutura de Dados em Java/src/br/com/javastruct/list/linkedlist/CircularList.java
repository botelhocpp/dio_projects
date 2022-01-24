package br.com.javastruct.list.linkedlist;

import br.com.javastruct.list.EmptyListException;
import br.com.javastruct.list.List;
import br.com.javastruct.node.Node;

/**
 * A Circulary-linked List!
 */
public class CircularList<E> implements List<E> {

     private Node<E> listHead;
     private Node<E> listTail;
     private int length;

     public CircularList() {

     }

     public CircularList(E value) {
          this.add(value);
     }

     @Override
     public void add(E value) {
          Node<E> newNode = new Node<>(value);
          if(this.isEmpty()) {
               this.listTail = this.listHead = newNode;
               this.listTail.setNext(this.listHead);
          }
          else {
               newNode.setNext(this.listHead);
               this.listTail.setNext(newNode);
               this.listTail = newNode;
          }
          this.length++;
     }

     @Override
     public void add(E value, int index) {
          if(this.isEmpty() || index >= this.length) {
               this.add(value);
          }
          else {
               Node<E> newNode = new Node<>(value);
               Node<E> previousNode;
               if(index == 0) {
                    previousNode = this.listTail;
                    this.listHead = newNode;
               }
               else {
                    previousNode = this.getNode(index - 1);  
               }
               newNode.setNext(previousNode.getNext());
               previousNode.setNext(newNode);
               this.length++;
          }
     }

     @Override
     public E get(int index) {
          return this.getNode(index).getContent();
     }

     @Override
     public E remove(int index) {
          this.validadeIndex(index);
          Node<E> targetNode;
          if(index == 0) {
               targetNode = this.listHead;
               this.listHead = targetNode.getNext();
               this.listTail.setNext(this.listHead);
          }
          else {
               Node<E> previousNode = this.getNode(index - 1);
               targetNode = previousNode.getNext();
               previousNode.setNext(targetNode.getNext());
               if(index == this.length - 1) {
                    previousNode.setNext(this.listHead);
                    this.listTail = previousNode;
               }
          }
          this.length--;
          return targetNode.getContent();
     }

     @Override
     public boolean isEmpty() {
          return this.length == 0;
     }

     @Override
     public int size() {
          return this.length;
     }

     @Override
     public String toString() {
          StringBuilder listElements = new StringBuilder("CircularList [ ");
          
          Node<E> currentNode = this.listHead;
          for(int i = 0; i < this.length; i++) {
               listElements.append(currentNode.getContent());
               currentNode = currentNode.getNext();
               if(currentNode != this.listHead) {
                    listElements.append(", ");
               }
          }
          return listElements.append(" ]").toString();
     }

     private Node<E> getNode(int index) {
          if(this.isEmpty()) {
               throw new EmptyListException();
          }
          
          if(index == 0) {
               return this.listHead;
          }

          Node<E> auxiliarNode = this.listHead;
          while(--index >= 0) {
               auxiliarNode = auxiliarNode.getNext();
          }

          return auxiliarNode;
     }

     private void validadeIndex(int index) throws EmptyListException, IndexOutOfBoundsException {
          if(this.isEmpty()) {
               throw new EmptyListException();
          }
          else if(index < 0 || index >= this.length) {
               throw new IndexOutOfBoundsException("Invalid index! Enter a index between 0 (inclusive) and " + this.length + " (exclusive).");
          }
     }
}