//import ch07.trees.*;
import java.lang.Math.*;
import support.*;
import java.util.Iterator;

public class myHeight<T> extends BinarySearchTree<T> {

   public int recHeight (BSTNode<T> node) {  // recursive height method
   
      if (node == null)
         return 0; // Reached the end
       else {
         int leftSide = recHeight(node.getLeft());
         int rightSide = recHeight(node.getRight());
         
         if (leftSide > rightSide)
            return leftSide + 1;
         else
            return rightSide + 1;
         
       }
   }
   
    public int iterHeight (BSTNode<T> node) {  // iterative height method

      int count = 0; // needed to track the height
   
      if (node == null)
         return 0; // empty tree, height of zero
   
      MyLinkedQueue<BSTNode> nodeTraversal;
      nodeTraversal = new MyLinkedQueue<BSTNode>(); // if node != null 
   
      nodeTraversal.enqueue(node);
      
      while (true)  
        {  
            int numNodes = nodeTraversal.size(); 
            if (numNodes == 0) 
                return count; // Once queue is empty, we've traversed tree
            count++; 
   
            while (numNodes > 0)  
            { 
                BSTNode<T> nextNode = nodeTraversal.dequeue(); // Dequeue to move through BST
                if (nextNode.getLeft() != null) 
                    nodeTraversal.enqueue(nextNode.getLeft()); 
                if (nextNode.getRight() != null) 
                    nodeTraversal.enqueue(nextNode.getRight()); 
                numNodes--; 
            } 
        } 
   }
   
   public double fRatio (BSTNode<T> origNode) {
         
         double minHeight = 0, originalHeight = 0;
         
         originalHeight = recHeight(origNode);
         
         int numNodes = this.size(); // get number of nodes for the BST
         
         minHeight = (Math.log(numNodes)) / Math.log(2);  // log base 2 of N nodes = minimum height
         
         return (int)minHeight / originalHeight; // casting to int on minHeight to drop the fraction
   
   }
 

} 