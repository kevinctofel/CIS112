import java.util.* ; 


public class Node<T>  
{ 
   public T info;             // The node info
   public Node<T> left;       // A link to the left child node
   public Node<T> right;      // A link to the right child node

   public Node(T info)
   {
      this.info = info;
      left = null;
      right = null;
   }
  
   public void setInfo(T info)
   {
      this.info = info;
   }
      
   public T getInfo()
   {
      return info;
   }
   
   public void setLeft(Node<T> link)
   {
      left = link;
   }
   
   public void setRight(Node<T> link)
   {
      right = link;
   }
   
   public Node<T> getLeft()
   {
      return left;
   }
   
   public Node<T> getRight()
   {
      return right;
   }      
}