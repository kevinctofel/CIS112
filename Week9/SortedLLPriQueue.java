//---------------------------------------------------------------------------
// LinkedQueue.java            by Dale/Joyce/Weems                  Chapter 4
//
// Implements QueueInterface using a linked list.
//---------------------------------------------------------------------------

// package ch04.queues;

import support.LLNode;
import java.util.Comparator;

public class SortedLLPriQueue<T> implements PriQueueInterface<T>
{
  protected LLNode<T> front;     // reference to the front of this queue
  protected LLNode<T> rear;      // reference to the rear of this queue
  protected int numElements = 0; // number of elements in this queue
  
  protected Comparator<T> comp;

  public SortedLLPriQueue()
  {
    front = null;
    rear = null;
    comp = new Comparator<T>()
    {
       public int compare(T element1, T element2)
       {
         return ((Comparable)element1).compareTo(element2);
       }
    };
  }
  
 

  public void enqueue(T element)
  // Adds element propertly sorted into the queue.
  { 
    LLNode<T> newNode = new LLNode<T>(element);
    LLNode<T> current = front;
    LLNode<T> previous = null;
    
    if (isEmpty()) // When queue is empty
      {
         front = newNode;
         newNode.setLink(null);
      }   
    else if (comp.compare(newNode.getInfo(), front.getInfo()) > 0) // When new is > first node in queue
      {
         newNode.setLink(front);
         front = newNode;
      }
    else
      { 
         previous = front;
         current = current.getLink();
         
       while (comp.compare(newNode.getInfo(), current.getInfo()) < 0) // traverse queue and compare nodes
          {  
            previous = current;
            current = current.getLink();
            
          }
          
          newNode.setLink(current); 
          previous.setLink(newNode);
           

//        if (comp.compare(newNode.getInfo(), rear.getInfo()) > 0) // Got through queue with newNode
//             {
//                rear.setLink(newNode);
//                newNode.setLink(null);
//             }
          }
    numElements++;
  }     

  public T dequeue()
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.
  {
    if (isEmpty())
      throw new PriQUnderflowException("Dequeue attempted on empty queue.");
    else
    {
      T element;
      element = front.getInfo();
      front = front.getLink();
      if (front == null)
        rear = null;
      numElements--;
      return element;
    }
  }

  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {              
    return (front == null);
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
  
  public void printPriQ()
  // Added to print contents of linked list queue.
  {
      LLNode<T> currNode = front;
      while (currNode.getLink() != null)
      {
         System.out.print(currNode.getInfo());
         currNode = currNode.getLink();
      }
         System.out.print(currNode.getInfo()); // Sloppy but prints last node
      
   } // end printPriQ


}

