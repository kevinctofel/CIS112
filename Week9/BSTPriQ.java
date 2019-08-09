import ch04.queues.*;
import ch07.trees.*;
import java.util.*;
import support.*;

public class BSTPriQ<T> extends BinarySearchTree<T> implements PriQueueInterface<T> 
{

  public void enqueue(T element)
  // Adds element propertly sorted into the queue.
  { 
    this.add(element);
  }     

  public T dequeue()
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.
  {
    if (isEmpty())
      throw new PriQUnderflowException("Dequeue attempted on empty queue.");
    else
    {
      T temp = (this.max());
      this.remove(this.max());
      return temp;
    }
  }

  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {              
    return (root == null);
  }
  
  public boolean isFull()
  // Returns false - a linked queue is never full.
  {              
    return false;
  }

  public int size()
  // Returns the number of elements in this queue.
  {
    return this.size();
  }
 
  public void printPriQ()
  {
    Iterator<T> iter;
    iter = this.getIterator(BSTInterface.Traversal.Inorder);
    while (iter.hasNext())
      System.out.print(iter.next());
  }

}

