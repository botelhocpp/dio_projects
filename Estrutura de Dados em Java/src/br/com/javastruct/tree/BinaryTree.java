package br.com.javastruct.tree;

import br.com.javastruct.node.BinaryNode;

public class BinaryTree<E extends Comparable<E>> {

     private BinaryNode<E> treeRoot;

     public BinaryTree() {

     }

     public BinaryTree(E firstValue) {
          this.treeRoot = new BinaryNode<>(firstValue);
     }

     public void insert(E content) {
          BinaryNode<E> newNode = new BinaryNode<>(content);
          this.treeRoot = insert(this.treeRoot, newNode);
     }

     private BinaryNode<E> insert(BinaryNode<E> currentNode, BinaryNode<E> newNode) {
          if(currentNode == null) {
               return newNode;
          }
          else if(newNode.getContent().compareTo(currentNode.getContent()) < 0) {
               currentNode.setLeft(this.insert(currentNode.getLeft(), newNode));
          }
          else {
               currentNode.setRight(this.insert(currentNode.getRight(), newNode));
          }
          return currentNode;
     }

     public boolean remove(E content) {
          try {
               BinaryNode<E> currentNode = this.treeRoot;
               BinaryNode<E> parentNode = null;
               BinaryNode<E> childNode = null;
               BinaryNode<E> temporaryNode = null;

               // Search for the target node
               while(currentNode != null && !currentNode.getContent().equals(content)) {
                    parentNode = currentNode;
                    if(content.compareTo(currentNode.getContent()) < 0) {
                         currentNode = currentNode.getLeft();
                    }
                    else {
                         currentNode = currentNode.getRight();
                    }
               }

               // A terminal node was reached or the tree is empty
               if(currentNode == null) {
                    return false;
               }

               // Removing the root 
               if(parentNode == null) {
                    if(currentNode.getRight() == null) {
                         this.treeRoot = currentNode.getLeft();
                    }
                    else if(currentNode.getLeft() == null) {
                         this.treeRoot = currentNode.getRight();
                    }
                    else {
                         // Traverse the tree after the biggest left-leaf of the target
                         for(temporaryNode = currentNode, childNode = currentNode.getLeft();
                         childNode.getRight() != null;
                         temporaryNode = childNode, childNode = childNode.getRight());
                         
                         if(childNode != currentNode.getLeft()) {
                              temporaryNode.setRight(childNode.getLeft());
                              childNode.setLeft(this.treeRoot.getLeft());
                         }
                         
                         childNode.setRight(this.treeRoot.getRight());
                         this.treeRoot = childNode;
                    }
               }

               // There are no greater nodes than the target node
               // Replaces target with the left child of the target
               else if(currentNode.getRight() == null) {
                    if(parentNode.getLeft() == currentNode) {
                         parentNode.setLeft(currentNode.getLeft());
                    }
                    else {
                         parentNode.setRight(currentNode.getLeft());
                    }
               }

               // There are no lesser nodes than the target node
               // Replaces target with the right child of the target
               else if(currentNode.getLeft() == null) {
                    if(parentNode.getLeft() == currentNode) {
                         parentNode.setLeft(currentNode.getRight());
                    }
                    else {
                         parentNode.setRight(currentNode.getRight());
                    }
               }
               else {
                    // Traverse the tree after the biggest left-leaf of the target
                    for(temporaryNode = currentNode, childNode = currentNode.getLeft();
                    childNode.getRight() != null;
                    temporaryNode = childNode, childNode = childNode.getRight());
                    
                    if(childNode != currentNode.getLeft()) {
                         temporaryNode.setRight(childNode.getLeft());
                         childNode.setLeft(currentNode.getLeft());
                    }
                    childNode.setRight(currentNode.getRight());
                    if(parentNode.getLeft() == currentNode) {
                         parentNode.setLeft(childNode);
                    }
                    else {
                         parentNode.setRight(childNode);
                    }
               }
          }
          catch(NullPointerException e) {
               return false;
          }
          return true;
     }

     public void traverseInOrder() {
          System.out.print("BinaryTree [ ");
          traverseInOrder(this.treeRoot);
          System.out.println("]");
     }

     private void traverseInOrder(BinaryNode<E> currentNode) {
          if(currentNode != null) {
               this.traverseInOrder(currentNode.getLeft());
               System.out.print(currentNode.getContent() + " ");
               this.traverseInOrder(currentNode.getRight());
          }
     }

     public void traversePreOrder() {
          System.out.print("BinaryTree [ ");
          traversePreOrder(this.treeRoot);
          System.out.println("]");
     }

     private void traversePreOrder(BinaryNode<E> currentNode) {
          if(currentNode != null) {
               System.out.print(currentNode.getContent() + " ");
               this.traversePreOrder(currentNode.getLeft());
               this.traversePreOrder(currentNode.getRight());
          }
     }

     public void traversePostOrder() {
          System.out.print("BinaryTree [ ");
          traversePostOrder(this.treeRoot);
          System.out.println("]");
     }

     private void traversePostOrder(BinaryNode<E> currentNode) {
          if(currentNode != null) {
               this.traversePostOrder(currentNode.getLeft());
               this.traversePostOrder(currentNode.getRight());
               System.out.print(currentNode.getContent() + " ");
          }
     }
}