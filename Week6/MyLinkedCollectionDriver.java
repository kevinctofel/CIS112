import ch04.queues.*;
import support.LLNode;

public class MyLinkedCollectionDriver {

   public static void main(String args[]) {
   
   MyLinkedCollection<Integer> myCollection;
   myCollection = new MyLinkedCollection<Integer>();
  
   myCollection.add(3);
   myCollection.add(8);
   myCollection.add(6);
   myCollection.add(5);
   myCollection.add(6);
   myCollection.add(1);
   
   System.out.println(myCollection.toString());
   
   System.out.println(myCollection.count(6));
   
   myCollection.removeAll(6);
   
   System.out.println(myCollection.toString());
   
   MyLinkedCollection<Integer> otherCollection;
   otherCollection = new MyLinkedCollection<Integer>();
   
   otherCollection.add(42);
   otherCollection.add(31);
   otherCollection.add(60);
   otherCollection.add(102);
   otherCollection.add(99);
   otherCollection.add(73);
   
   System.out.println(otherCollection.toString());
   
   MyLinkedCollection<Integer> combined;
   combined = new MyLinkedCollection<Integer>();

   combined = myCollection.combine(otherCollection);
   System.out.println(combined.toString());
   
   } // end main

}