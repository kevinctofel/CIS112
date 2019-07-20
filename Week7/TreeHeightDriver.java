import ch07.trees.*;
import support.*;

public class TreeHeightDriver <T> extends myHeight<T> {

   public static void main(String args[]) {
   
   myHeight<Integer> example = new myHeight<Integer>();
   
   //Iterator<Integer> iter;
   
   example.add(3);
   example.add(5);
   example.add(1);
   example.add(17);
   example.add(42);
   example.add(-2);
   example.add(99);
   example.add(4);
   example.add(2);
   
   System.out.println("The height of the BST is: " + example.recHeight(example.root));
   
   }

}