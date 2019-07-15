import ch04.queues.*;
import support.LLNode;

public class MyLinkedCollectionDriver {

   public static void main(String args[]) {
   
   MyLinkedCollection<Integer> myCollection;
   myCollection = new MyLinkedCollection<Integer>();
  
   myCollection.add(3);
   myCollection.add(12);
   myCollection.add(6);
   myCollection.add(10);
   myCollection.add(6);
   myCollection.add(1);
   
   System.out.println(myCollection.toString());
   
   System.out.println(myCollection.count(6));
   
   myCollection.removeAll(6);
   
   System.out.println(myCollection.toString());

   
   } // end main

}