import ch04.queues.*;
import support.LLNode;

public class MyLinkedQueue<T> extends LinkedQueue<T> {

   public String toString() {
   
      String output = "";
      LLNode<T> elements = front;
      
      while(elements != null) {
         output = output + elements.getInfo() + " ";
         elements = elements.getLink();
      }
      
      return output;
   
   } // end toString
   
   public void remove (int count) throws QueueUnderflowException {
   
   if (count > numElements)
      throw new QueueUnderflowException("Can't remove that many elements.");
   else 
      while (count > 0)
         {
            T element;
            element = front.getInfo();
            front = front.getLink();
            if (front == null)
               rear = null;
            numElements--;
            count --;
         }
   
   } // end remove
   
   public boolean swapEnds() {
   
      if (numElements < 2)
         return false;
      else
         {
            LLNode<T> temp = front;
            for (int i = 1; i < (numElements - 1); i++)
               {
                  temp = temp.getLink();
               }
            rear.setLink(front.getLink());
            rear = front;
            front = temp.getLink();
            temp.setLink(rear);
            rear.setLink(null);
            return true;
         }
   
   } 
   
   public boolean swapStart() {
   
      if (numElements < 2)
         return false;
      else 
         {
            LLNode<T> temp = front;
            front = front.getLink();
            temp.setLink(front.getLink());
            front.setLink(temp);
            return true;
         }
   
   } // end swapStart

}