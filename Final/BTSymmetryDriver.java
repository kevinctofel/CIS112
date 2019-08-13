public class BTSymmetryDriver {

   public static void main(String[] args) 
   
   { 
            
      Node a = new Node(1); 
      BinarySearchTree<Integer> bt = new BinarySearchTree(a); 
      bt.root = a;
      a = null;
      bt.root.left = new Node(2); 
      bt.root.right = new Node(2); 
      bt.root.left.left = new Node(3); 
      bt.root.left.right = new Node(4); 
      bt.root.right.left = new Node(4); 
      bt.root.right.right = new Node(3); 
      
   }
    
}