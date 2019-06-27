import java.util.Scanner;

public class Sum {

   public static void main (String args[]) {
   
   int n = 0;
   Scanner input = new Scanner(System.in);
   
   System.out.println("Enter a non-negative integer and I will calculate Sum(N): ");
   n = input.nextInt();
   
   System.out.println("Sum(" + n +") is: " + summarize(n));
   
   }


   public static int summarize(int n){
   
      if (n == 0)
         return 0;
      else
         return n + summarize(n - 1);

   }

}