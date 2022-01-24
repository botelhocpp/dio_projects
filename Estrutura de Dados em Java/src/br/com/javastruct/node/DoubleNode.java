package br.com.javastruct.node;

public class DoubleNode<T> {

     private T content;
     private DoubleNode<T> nextNode;
     private DoubleNode<T> previousNode;

     public DoubleNode(){
          
     }

     public DoubleNode(T content){
          this.content = content;
     }

     public T getContent() {
          return this.content;
     }

     public void setContent(T content) {
          this.content = content;
     }

     public DoubleNode<T> getNext() {
          return this.nextNode;
     }

     public void setNext(DoubleNode<T> nextNode) throws IllegalArgumentException {
          this.nextNode = nextNode;
     }

     public DoubleNode<T> getPrevious() {
          return this.previousNode;
     }

     public void setPrevious(DoubleNode<T> previousNode) throws IllegalArgumentException {
          this.previousNode = previousNode;
     }

     @Override
     public String toString() {
          return "DoubleNode [ Content = " + this.content + " ]";
     }
}