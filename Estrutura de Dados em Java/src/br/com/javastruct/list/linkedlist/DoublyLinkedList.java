package br.com.javastruct.list.linkedlist;

import br.com.javastruct.list.EmptyListException;
import br.com.javastruct.list.List;
import br.com.javastruct.node.DoubleNode;

/**
 * A Doubly-linked List! Made for the Cognizant Bootcamp.
 * 
 * @author Pedro M. Botelho
 */
public class DoublyLinkedList<E> implements List<E> {

     private DoubleNode<E> listHead;
     private DoubleNode<E> listTail;
     private int length;

     public DoublyLinkedList() {

     }

     public DoublyLinkedList(E value) {
          this.add(value);
     }

     /**
      * Append the value at the final of the list.
      */
     @Override
     public void add(E value) {
          DoubleNode<E> node = new DoubleNode<>(value);
          node.setPrevious(this.listTail);

          // If the list is empty.
          if(this.listHead == null) {
               this.listHead = node;
          }

          // If the list is not empty.
          if(this.listTail != null) {
               this.listTail.setNext(node);
          }

          this.listTail = node;
          this.length++;
     }

     @Override
     public void add(E value, int index) {
          DoubleNode<E> auxiliarNode = this.getNode(index);      // Node at the specified index.
          DoubleNode<E> newNode = new DoubleNode<>(value);
          newNode.setNext(auxiliarNode);                         // The new node is placed before the node at the index.

          // The node was not placed at the end of the list.
          if(newNode.getNext() != null) {
               newNode.setPrevious(auxiliarNode.getPrevious());
               auxiliarNode.setPrevious(newNode);
          }
          // The node was placed at the end of the list.
          else {
               newNode.setPrevious(this.listTail);
               this.listTail = newNode;
          }

          // The node was placed at the start of the list.
          if(index == 0 || this.size() == 0) {
               this.listHead = newNode;
          }
          // The node was not placed at the start of the list.
          else {
               newNode.getPrevious().setNext(newNode);
          }

          this.length++;
     }

     @Override
     public E get(int index) {
          this.validateIndex(index);
          return this.getNode(index).getContent();
     }

     @Override
     public E remove(int index) throws EmptyListException, IndexOutOfBoundsException {
          this.validateIndex(index);
          DoubleNode<E> targetNode;
          if(index == 0) {
               targetNode = this.listHead;
               this.listHead = this.listHead.getNext();
               if(this.listHead != null) {
                    this.listHead.setPrevious(null);
               }
          }
          else {
               targetNode = this.getNode(index);
               targetNode.getPrevious().setNext(targetNode.getNext());
               if(targetNode != this.listTail) {
                    targetNode.getNext().setPrevious(targetNode.getPrevious());
               }
               else {
                    this.listTail = targetNode.getPrevious();

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

     public E head() {
          return this.listHead.getContent();
     }

     public E tail() {
          return this.listTail.getContent();
     }

     @Override
     public String toString() {
          StringBuilder listElements = new StringBuilder("DoublyLinkedList [ ");
          
          DoubleNode<E> currentNode = this.listHead;
          while(currentNode != null) {
               listElements.append(currentNode.getContent());
               currentNode = currentNode.getNext();
               if(currentNode != null) {
                    listElements.append(", ");
               }
          }
          return listElements.append(" ]").toString();
     }

     private DoubleNode<E> getNode(int index) throws IndexOutOfBoundsException {
          if(index < 0){
               throw new IndexOutOfBoundsException("A negative number is not a valid index.");
          }
          DoubleNode<E> auxiliarNode = this.listHead;
          while(--index >= 0 && auxiliarNode != null){
               auxiliarNode = auxiliarNode.getNext();
          }
          return auxiliarNode;
     }

     private void validateIndex(int index) throws EmptyListException, IndexOutOfBoundsException {
          if(this.isEmpty()) {
               throw new EmptyListException();
          }
          if(index < 0 && index >= this.size()){
               throw new IndexOutOfBoundsException("Invalid index! Enter a index between 0 (inclusive) and " + this.length + " (exclusive).");
          }
     }
     
}
