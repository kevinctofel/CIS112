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
      
      location = head;
            
        if (head == location && (head.getInfo().equals(target))) { 
            head = head.getLink();    // remove first node
            numElements--;
        }

        while (location != null) 
            {
               if (location.getInfo().equals(target)) { // if they match 
                  previous.setLink(location.getLink()); // remove node at location
                  location = location.getLink();
                  numElements--;
                  }
               else {
                  previous = location;
                  location = location.getLink();
                }   
        }   
   
   }
   
   public MyLinkedCollection<T> combine(MyLinkedCollection<T> other) {
   
      MyLinkedCollection<T> combined;
      combined = new MyLinkedCollection<T>(); // This will be the combined collection
      
      LLNode<T> first = this.head; // This is a holder to iterate through the first collection
      LLNode<T> second = other.head; // This is a holder to iterate through the other collection
      
      while (first.getLink() != null) {
         combined.add(first.getInfo());
         first = first.getLink();
      }
         combined.add(first.getInfo()); // Accounting for the last node
      
      while (second.getLink() != null) {
         combined.add(second.getInfo());
         second = second.getLink();
      }
         combined.add(second.getInfo()); // Accounting for the last node
         
      return combined;
   }

}