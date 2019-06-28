import support.*;

public class RecursiveEvens {

   public static void main (String args[]) {
   
      // Popuplate values into linked list nodes
     
      
      LLNode<Integer> num1 = new LLNode<Integer>(3);
      LLNode<Integer> num2 = new LLNode<Integer>(6);
      LLNode<Integer> num3 = new LLNode<Integer>(6);
      LLNode<Integer> num4 = new LLNode<Integer>(9);
      LLNode<Integer> num5 = new LLNode<Integer>(12);
      LLNode<Integer> num6 = new LLNode<Integer>(15);
      LLNode<Integer> num7 = new LLNode<Integer>(18);
      LLNode<Integer> num8 = new LLNode<Integer>(19);
      LLNode<Integer> num9 = new LLNode<Integer>(19);
      LLNode<Integer> num10 = new LLNode<Integer>(20);
   
      // Connect linked list nodes
      
      LLNode<Integer> values = num1;
      num1.setLink(num2);
      num2.setLink(num3);
      num3.setLink(num4);
      num4.setLink(num5);
      num5.setLink(num6);
      num6.setLink(num7);
      num7.setLink(num8);
      num8.setLink(num9);
      num9.setLink(num10);
      //num10.setLink(null);
      
      System.out.println(numEvens(values));
   
   }
   
   
   public static int numEvens(LLNode<Integer> list) {
   
     
      // If list is not empty read through and update count for even values
      if(list != null) {
         if (list.getInfo()%2 == 0) { // Even case
            return 1 + numEvens(list.getLink());
            }
         else
            return numEvens(list.getLink());
         }
      else
         return 0;
   }
   
}