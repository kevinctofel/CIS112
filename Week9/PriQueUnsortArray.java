import java.util.*;
import ch04.queues.*;

public class PriQueUnsortArray<T> implements PriQueueInterface<T> {

   private static final int DEFCAP = 20;
   private T[] elements;
   private int numElements = 0;
   private int front = 0;
   private int rear;
   
   public PriQueUnsortArray() 
      {
         elements = (T[]) new Object[DEFCAP];
         rear = DEFCAP - 1;
      }
   
   public void enqueue(T element) {
   
      if (isFull())
         throw new PriQOverflowException("Enqueue attempted on a full queue.");
      else
         {
            rear = (rear + 1) % elements.length;
            elements[rear] = element;
            numElements ++;
         }
   
   } //end enqueue
   
   public T dequeue() {
   
      if (isEmpty())
         throw new PriQUnderflowException("Dequeue attempted on empty queue.");
      else
         {
            T tempElement = elements[front];
            elements[min()] = null;
            front = (front + 1) % elements.length;
            numElements --;
            return tempElement;
         }
   
   } //end dequeue
   
   public boolean isEmpty() {
   
      return (numElements == 0);
   
   } // end isEmpty
   
   public boolean isFull() {
      
      return (numElements == elements.length);
      
   } // end isFull
   
   public int size() {
      return numElements;
   } // end size
   
   public int min() { // find the highest priority element by index
      return 0;
   } // end min

}