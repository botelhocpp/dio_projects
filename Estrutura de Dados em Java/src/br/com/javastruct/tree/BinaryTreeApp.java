package br.com.javastruct.tree;

import java.util.Objects;

public class BinaryTreeApp {
     public static void main(String[] args) {
          BinaryTree<Payload> tree = new BinaryTree<>(new Payload(13));
          tree.insert(new Payload(10));
          tree.insert(new Payload(2));
          tree.insert(new Payload(12));
          tree.insert(new Payload(11));
          tree.insert(new Payload(13));
          tree.insert(new Payload(25));
          tree.insert(new Payload(20));
          tree.insert(new Payload(31));
          tree.insert(new Payload(29));
          tree.insert(new Payload(32));
          tree.traverseInOrder();

          tree.remove(new Payload(13));
          tree.traverseInOrder();

          tree.remove(new Payload(25));
          tree.traverseInOrder();
     }
}

class Payload implements TreePayload<Payload> {
     private Integer load;

     public Payload(Integer load) {
          this.load = load;
     }

     @Override
     public int hashCode() {
          return Objects.hash(this.load);
     }

     @Override
     public boolean equals(Object obj) {
          if(this == obj) {
               return true;
          }
          if(obj == null) {
               return false;
          }
          if(getClass() != obj.getClass()) {
               return false;
          }
          Payload other = (Payload) obj;
          if(load == null) {
               if (other.load != null) {
                    return false;
               }
          }
          else if(!load.equals(other.load)) {
               return false;
          }
          return true;
     }

     @Override
     public int compareTo(Payload reference) {
          return (this.load > reference.load) ? 1 :
                 ((this.load < reference.load)) ? -1 : 0;
     }

     @Override
     public String toString() {
          return this.load.toString();
     }
}

interface TreePayload<T> extends Comparable<T> {
     boolean equals(Object reference);
     int hashCode();
     int compareTo(T reference);
     String toString();
}