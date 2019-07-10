import ch04.queues.*;
import support.LLNode;

public class CircularLinkedQueueDriver {

   public static void main(String args[]) {
   
   CircularLinkedQueue<Integer> queue;
   queue = new CircularLinkedQueue<Integer>();
  
   queue.enqueue(1);
   queue.enqueue(2);
   queue.enqueue(3);
   queue.enqueue(4);
   
   queue.dequeue();
   queue.dequeue();
   
   queue.enqueue(5);
   queue.enqueue(6);
   
   } // end main

}