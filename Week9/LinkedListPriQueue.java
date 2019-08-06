import support.LLNode;
import java.util.Comparator;

public class LinkedListPriQueue<T> implements PriQueueInterface<T>
{

   protected LLNode<T> front;
   protected LLNode<T> rear;
   protected int numElements = 0;
   // protected Comparator<T> comp; Need to REMOVE this after adding compare
   
   pubic LinkedListPriQueue()
   {
      front = null;
      rear = null;
   }
   
  public void enqueue(T element) 
  {
  // Throws PriQOverflowException if this priority queue is full;
  // otherwise, adds element to this priority queue.
  
  } // end enqueue

  public T dequeue()
  {
  // Throws PriQUnderflowException if this priority queue is empty;
  // otherwise, removes element with highest priority from this 
  // priority queue and returns it.
   
  } // end dequeue;
  
  public boolean isEmpty()
  {
  // Returns true if this priority queue is empty; otherwise, returns false.
   } // end isEmpty
   
  public boolean isFull() 
  {
  // Returns true if this priority queue is full; otherwise, returns false.
  
  } // end isFull
 
  public int size()
  {
  // Returns the number of elements in this priority queue.
  } // end size
  
} // end LinkedListPriQueue