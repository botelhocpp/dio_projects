package br.com.javastruct.stack;

public class StackApp {
     public static void main(String[] args) {
          Stack<Integer> stack = new Stack<>();
          stack.push(1);
          stack.push(2);
          System.out.println("Top: " + stack.top()); 

          stack.push(3);
          stack.push(4);
          stack.push(5);
          System.out.println(stack);

          stack.pop();
          System.out.println("Last Top: " + stack.pop());
     }
}
