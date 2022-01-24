package br.com.javastruct.queue;

import br.com.javastruct.node.Node;

/** 
 * The queue organization is defined belllow:
 *  
 * (queueEntrance) -> | lastNode | -> ... -> | firstNode | -> (null)
 */
public class Queue<E> {

     /**
      * The queue entry reference. Refers to the last
      * node in the queue, as well as where a new node
      * will be placed.
      */
     private Node<E> queueEntrance;

     public Queue() {

     }

     public Queue(E firstElement) {
          this.queueEntrance = new Node<E>(firstElement);
     }

     public void enqueue(E value) {
          Node<E> node = new Node<E>(value);
          node.setNext(this.queueEntrance);
          this.queueEntrance = node;
     }

     public E dequeue() {
          try {
               Node<E> queueNode = this.queueEntrance;
               Node<E> auxiliarNode = this.queueEntrance;
               while(queueNode.getNext() != null){
                    auxiliarNode = queueNode;
                    queueNode = queueNode.getNext();
               }
               auxiliarNode.setNext(null);
               return queueNode.getContent();
          }
          catch(NullPointerException e) {
               throw new EmptyQueueException();
          }
     }

     public E first() {
          try {
               Node<E> queueNode = this.queueEntrance;
               while(queueNode.getNext() != null){
                    queueNode = queueNode.getNext();
               }
               return queueNode.getContent();
          }
          catch(NullPointerException e) {
               throw new EmptyQueueException();
          }
     }

     public boolean isEmpty() {
          return this.queueEntrance == null;
     }

     @Override
     public String toString() {
          StringBuilder queueElements = new StringBuilder("Queue [ ");

          Node<E> currentNode = this.queueEntrance;
          while(currentNode != null) {
               queueElements.append(currentNode.getContent());
               currentNode = currentNode.getNext();
               if(currentNode != null){
                    queueElements.append(", ");
               }
          }

          return queueElements.append(" ]").toString();
     }

     
}
