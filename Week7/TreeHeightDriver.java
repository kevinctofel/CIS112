import ch07.trees.*;
import support.*;
import java.util.Random;

public class TreeHeightDriver <T> extends myHeight<T> {

   public static void main(String args[]) {
   
      myHeight<Integer> example = new myHeight<Integer>();
   
   // Note: The next 10 lines can be manually adjusted for testing different values
   
      example.add(1);
      example.add(2);
      example.add(3);
      example.add(4);
      example.add(5);
      example.add(6);
      example.add(7);
      example.add(8);
      example.add(9);
   
      System.out.println("The (recursive) height of the BST is: " + example.recHeight(example.root)); 
      System.out.println("The (iterative) height of the BST is: " + example.iterHeight(example.root));
   
      System.out.println("The fullness ratio of the BST is: " + example.fRatio(example.root));
   
   // Generate 10 random trees with 1,000 nodes (between 1 and 3,000)
      for (int j = 1; j <= 10; j++) {
         myHeight<Integer> tree = new myHeight<Integer>();
      
         Random number = new Random();
         int nodeValue;
      
         for (int i = 1; i <= 1000; i++) {  // generate a BST with 1,000 random nodes
         
            nodeValue = number.nextInt(3000);
            tree.add(nodeValue);
         }
      
         int numNodes = tree.size(); // get number of nodes for the BST
         double minHeight = (Math.log(numNodes)) / Math.log(2);  // log base 2 of N nodes = minimum height
      
         System.out.println("\nThe height of random tree" +j+ " is: " + tree.recHeight(tree.root));
         System.out.println("The optimal hieght of this tree is: " + (int)minHeight);
         System.out.println("The fullness ratio of this tree is: " + tree.fRatio(tree.root)); 
      }
   
      double k = 0.0; // Represents a percentage that a node should contain the value 42
      
      // Generate a random tree with a perctage (k) that a node value will be 42
      
      myHeight<Integer> tree = new myHeight<Integer>();
      
      Random number = new Random(); // Random node value generation
      int nodeValue;
      k = .2;
      
      for (int i = 1; i <= 1000; i++) {  // generate a BST with 1,000 random nodes
            
         Random percentage = new Random();  
         double percent = percentage.nextDouble();
         
         if (percent <= k) {
            tree.add(42);
         }
         else {
            nodeValue = number.nextInt(3000);
            tree.add(nodeValue);
         }
      }
         
      int numNodes = tree.size(); // get number of nodes for the BST
      double minHeight = (Math.log(numNodes)) / Math.log(2);  // log base 2 of N nodes = minimum height
      
      System.out.println("\nThe height of random tree with " + k*100 + " percent of values having 42 is: " + tree.recHeight(tree.root));
      System.out.println("The optimal hieght of this tree is: " + (int)minHeight);
      System.out.println("The fullness ratio of this tree is: " + tree.fRatio(tree.root)); 
      
   
   }  // end main
} // end class