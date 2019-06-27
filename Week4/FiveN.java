import java.util.Scanner;

public class FiveN {

   public static void main (String args[]) {
   
   int n = 0;
   Scanner input = new Scanner(System.in);
   
   System.out.println("Enter a non-negative integer and I will calculate 5(N): ");
   n = input.nextInt();
   
   System.out.println("5 times " + n +" is: " + fiveN(n));
   
   }


   public static int fiveN(int n){
   
      if (n == 0)
         return 0;
      else
         return 5 + (fiveN(n - 1));
   }

}