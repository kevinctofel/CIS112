import ch07.trees.*;
import support.*;

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
   
//     public int iterHeight (BSTNode<T> node) {  // iterative height method
// 
//    int count = 0;
//    
//    if (node == null)
//       return 0; // empty tree
//    while (node != null) {
//       
//       
//    
//    
//    
//    }

} 