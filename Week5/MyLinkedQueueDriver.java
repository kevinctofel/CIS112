import ch04.queues.*;
import support.LLNode;

public class MyLinkedQueueDriver {

   public static void main(String args[]) {
   
   MyLinkedQueue<Integer> queue;
   queue = new MyLinkedQueue<Integer>();
  
   queue.enqueue(3);
   queue.enqueue(12);
   queue.enqueue(6);
   queue.enqueue(10);
   queue.enqueue(1);
   
   System.out.println(queue.toString());
   
   queue.remove(1);
   
   System.out.println(queue.toString());
   
   queue.swapStart();
   
   System.out.println(queue.toString());
   
   queue.swapEnds();
   
   System.out.println(queue.toString());
   
   } // end main

}