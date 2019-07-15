import ch05.collections.*;
import support.LLNode;

public class MyLinkedCollection<T> extends LinkedCollection<T> {
   
   public String toString() {
   
      String output = "";
      LLNode<T> elements = head;
      
      while(elements != null) {
         output = output + elements.getInfo() + " ";
         elements = elements.getLink();
      }
      
      return output;
   
   } // end toString

   
   public int count(T target) {
   
      location = head;
      int numMatches = 0;

      while (location != null) 
      {
         if (location.getInfo().equals(target))  // if they match
            numMatches++;
         location = location.getLink();
       
      }
      return numMatches++;
   }  // end count of matches

   public void removeAll(T target) {
      
      LLNode<T> index = head;
            
        if (head == index && (index.getInfo().equals(target))) { 
            head = head.getLink();    // remove first node
            numElements--;
        }

        while (index != null) 
            {
               if (index.getInfo().equals(target)) { // if they match 
                  previous.setLink(index.getLink()); // remove node at location
                  numElements--;
                  }
               else {
                  previous = index;
                  index = index.getLink();
                }   
        }   
   
   }
   
//    public LinkedCollection<T> combine(LinkedCollection<T> other) {
//    
//       LinkedCollection<T> elements;
//       return elements;
//    }

}