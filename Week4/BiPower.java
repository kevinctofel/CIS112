import java.util.Scanner;

public class BiPower {

   public static void main (String args[]) {
   
   int n = 0;
   Scanner input = new Scanner(System.in);
   
   System.out.println("Enter a non-negative integer and I will calculate BiPower(N): ");
   n = input.nextInt();
   
   System.out.println("2 to the power of " + n +" is: " + twoToN(n));
   
   }


   public static int twoToN(int n){
   
      if (n == 0)
         return 1;
      else
         return 2 * (twoToN(n - 1));

   }

}