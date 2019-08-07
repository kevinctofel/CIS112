import support.LLNode;
import java.util.Comparator;

public class LinkedListPriQueue<T> implements PriQueueInterface<T>
{

   public LLNode<T> front = null;
   protected LLNode<T> rear = null;
   protected int numElements = 0;
   protected Comparator<T> comp;
   
   public LinkedListPriQueue()
{
    comp = new Comparator<T>()
    {
       public int compare(T element1, T element2)
       {
         return ((Comparable)element1).compareTo(element2);
       }
    };
  }
   
   public void enqueue(T element) 
   {
   // Throws PriQOverflowException if this priority queue is full;
   // otherwise, adds element to this priority queue.
   
      LLNode<T> newNode = new LLNode<T>(element);
   
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
         LLNode<T> priElement = front;
         LLNode<T> previous = front;
         LLNode<T> temp = null;
         LLNode<T> node = front;
         for (int i = 1; i < numElements - 1; i++)
         {
            if (comp.compare(node.getInfo(), node.getLink().getInfo()) > 0)
            {
               priElement = node;
               previous = node;            
               node = node.getLink();
            }
            else 
            {
               previous = node;
               node = node.getLink();
            }
          }     
         temp = priElement;
         if (priElement == front)
            front = front.getLink();
         else if (priElement.getLink() == null)
            previous.setLink(null);
         else
            previous.setLink(priElement.getLink());
         
         numElements--;

         return temp.getInfo();
      
      
//          T element = front.getInfo();
//          front = front.getLink();
//          if (front == null)
//             rear = null;
//          numElements--;
//          return element;
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
   
   public void printPriQ() // Traverse and print the queue
   {
      LLNode<T> currNode = front;
      while (currNode.getLink() != null)
      {
         System.out.print(currNode.getInfo());
         currNode = currNode.getLink();
      }
         System.out.print(currNode.getInfo()); // Sloppy but prints last node
      
   } // end printPriQ
  
} // end LinkedListPriQueue