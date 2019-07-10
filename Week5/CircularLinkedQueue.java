//---------------------------------------------------------------------------
// CircularLinkedQueue.java            by Dale/Joyce/Weems                  Chapter 4
//                                     Modified by Kevin C. Tofel
// Implements QueueInterface using a circular linked list.
//---------------------------------------------------------------------------

import ch04.queues.*;
import support.LLNode;

public class CircularLinkedQueue<T> implements QueueInterface<T>
{
  // protected LLNode<T> front;     // reference to the front of this queue : REMOVED
  protected LLNode<T> rear;      // reference to the rear of this queue
  protected int numElements = 0; // number of elements in this queue

  public CircularLinkedQueue()
  {
    // front = null; : REMOVED
    rear = null;
  }

  public void enqueue(T element)
  // Adds element to the rear of this queue.
  { 
    LLNode<T> newNode = new LLNode<T>(element);
    if (rear == null) 
    {
      rear = newNode; // adding to the rear
      numElements++;
    }
    else
    { 
      if (rear.getLink() == null) 
      {
         rear.setLink(newNode);
         newNode.setLink(rear);
         rear = newNode;
         numElements++;
      }
      else
      {
         newNode.setLink(rear.getLink());
         rear.setLink(newNode);
         rear = newNode;
         numElements++;
         }
   } 
  }    

   public T dequeue()
   // Throws QueueUnderflowException if this queue is empty;
   // otherwise, removes front element from this queue and returns it.
   {
    if (rear == null)
      throw new QueueUnderflowException("Dequeue attempted on empty queue.");
    else
    {
      T element;
      element = rear.getLink().getInfo(); // Get front node info
      rear.setLink(rear.getLink().getLink());
      
      if (rear.getLink() == null)  
         rear = null;

      numElements--;
      return element;
     }
   }

  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {              
    return (rear == null);
  }
  
  public boolean isFull()
  // Returns false - a linked queue is never full.
  {              
    return false;
  }

  public int size()
  // Returns the number of elements in this queue.
  {
    return numElements;
  }

}

