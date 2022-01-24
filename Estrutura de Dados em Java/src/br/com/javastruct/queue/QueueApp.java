package br.com.javastruct.queue;

public class QueueApp {
     public static void main(String[] args) {
          Queue<String> queue = new Queue<>("Numbers?");
          queue.enqueue("First!");
          queue.enqueue("Second!");
          queue.enqueue("Third!");
          queue.enqueue("Fourth!");
          queue.enqueue("Fifth!");
          System.out.println(queue);

          System.out.println(queue.dequeue());
          System.out.println(queue.first());
          System.out.println(queue.isEmpty());
     }
}
