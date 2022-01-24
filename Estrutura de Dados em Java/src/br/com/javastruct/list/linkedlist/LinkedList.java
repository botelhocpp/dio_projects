package br.com.javastruct.list.linkedlist;

import br.com.javastruct.list.EmptyListException;
import br.com.javastruct.list.List;
import br.com.javastruct.node.Node;

/**
 * A Singly-linked List! Made for the Cognizant Bootcamp.
 * 
 * @author Pedro M. Botelho
 */
public class LinkedList<E> implements List<E> {
     
     /**
      * The list entry reference. Refers to the first
      * node in the list.
      */
     Node<E> listHead;

     /**
      * Constructs an empty list.
      */
     public LinkedList() {
          
     }

     /**
      * Constructs a list with the specified value.
      *
      * @param headValue Value to be placed in the start
      * of the list.
      */
     public LinkedList(E headValue) {
          this.listHead = new Node<E>(headValue);     
     }

     @Override
     public void add(E value) {
          if(this.isEmpty()) {
               this.listHead = new Node<E>(value);
          }
          else {
               Node<E> auxiliarNode = this.listHead;
               while(auxiliarNode.getNext() != null) {
                    auxiliarNode = auxiliarNode.getNext();
               }
               auxiliarNode.setNext(new Node<E>(value));
          }
     }

     @Override
     public void add(E value, int index) {

          //Add to the end of the list.
          if(index == this.size()) {
               this.add(value);
          }
          
          else if(!this.validateIndex(index)) {
               throw new IndexOutOfBoundsException("Invalid index! Enter a index between 0 and " + (this.size() - 1));
          }
          else {
               Node<E> auxiliarNode = this.listHead;
               while(--index >= 0) {
                    auxiliarNode = auxiliarNode.getNext();
               }
               auxiliarNode.setNext(new Node<E>(value));
          }
     }

     @Override
     public E get(int index) {
          return this.getNode(index).getContent();
     }

     @Override
     public E remove(int index) {
          if(this.isEmpty()) {
               throw new EmptyListException();
          }
          else if(!this.validateIndex(index)) {
               throw new IndexOutOfBoundsException("Invalid index! Enter a index between 0 and " + (this.size() - 1));
          }

          Node<E> targetNode = this.getNode(index);
          if(index == 0) {
               this.listHead = targetNode.getNext();
          }
          else {
               Node<E> previousNode = this.getNode(index - 1);
               previousNode.setNext(targetNode.getNext());
          }
          return targetNode.getContent();
     }

     @Override
     public boolean isEmpty() {
          return this.listHead == null;
     }

     @Override
     public int size() {
          int listSize = 0;
          Node<E> auxiliarNode = this.listHead;
          while(auxiliarNode != null) {
               listSize++;
               auxiliarNode = auxiliarNode.getNext();
          }
          return listSize;
     }

     @Override
     public String toString() {
          StringBuilder listElements = new StringBuilder("List [ ");
          
          Node<E> currentNode = this.listHead;
          while(currentNode != null) {
               listElements.append(currentNode.getContent());
               currentNode = currentNode.getNext();
               if(currentNode != null) {
                    listElements.append(", ");
               }
          }
          return listElements.append(" ]").toString();
     }

     private Node<E> getNode(int index) {
          if(!this.validateIndex(index)) {
               throw new IndexOutOfBoundsException("Invalid index! Enter a index between 0 and " + (this.size() - 1));
          }
          Node<E> indexNode = this.listHead;
          while(--index >= 0) {
               indexNode = indexNode.getNext();
          }

          return indexNode;
     }

     private boolean validateIndex(int index) {
          return index >= 0 && index < this.size();
     }
}
