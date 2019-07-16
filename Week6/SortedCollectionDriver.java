import ch05.collections.*;
import support.LLNode;

public class SortedCollectionDriver {

   public static void main(String args[]) {
   
   SortedLinkedCollection<Integer> myCollection;
   myCollection = new SortedLinkedCollection<Integer>();
  
   myCollection.add(3);
   myCollection.add(3);
   myCollection.add(6);
   myCollection.add(5);
   myCollection.add(6);
   myCollection.add(4);
   
   System.out.println(myCollection.toString());
   
   
   } // end main

}