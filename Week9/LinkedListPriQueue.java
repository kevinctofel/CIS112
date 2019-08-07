import support.LLNode;
import java.util.Comparator;

public class LinkedListPriQueue<T> implements PriQueueInterface<T>
{

   protected LLNode<T> front;
   protected LLNode<T> rear;
   protected int numElements = 0;
   // protected Comparator<T> comp; Need to REMOVE this after adding compare
   
   public LinkedListPriQueue()
   {
      front = null;
      rear = null;
   }
   
   public void enqueue(T element) 
   {
   // Throws PriQOverflowException if this priority queue is full;
   // otherwise, adds element to this priority queue.
   
      LLNode<T> newNode = new LLNode<T>(element);
      rear.setLink(newNode);
   
      if (rear == null)
         front = newNode;
      else
         rear.setLink(newNode);
   
      rear = newNode;
      numElements++;
   
   } // end enqueue

   public T dequeue()
   {
   // Throws PriQUnderflowException if this priority queue is empty;
   // otherwise, removes element with highest priority from this 
   // priority queue and returns it.
   
   if (isEmpty())
         throw new PriQUnderflowException("Dequeue attempted on empty queue.");
      else
      {
         T element = front.getInfo();
         front = front.getLink();
         if (front == null)
            rear = null;
         numElements--;
         return element;
         // Above code needs to remove not front but highest priority
      }

   
   } // end dequeue;
  
   public boolean isEmpty()
   {
   // Returns true if this priority queue is empty; otherwise, returns false.
      
      if (front == rear)
         return true;
      else
         return false;
         
   } // end isEmpty
   
   public boolean isFull() 
   {
   // Returns true if this priority queue is full; otherwise, returns false.
   
      return false; // LL is never full
   
   } // end isFull
 
   public int size()
   {
   // Returns the number of elements in this priority queue.
   
      return numElements;
      
   } // end size
  
} // end LinkedListPriQueue