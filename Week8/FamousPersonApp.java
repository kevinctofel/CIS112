import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class FamousPersonApp {

   public static void main (String args[]) throws FileNotFoundException {
   
      //First, last, year, fact
      // Need array for person objects
      
      FamousPerson2 [] people = new FamousPerson2[23];
      int [] hashCodes = new int[23];
      int [] hashCodes1000 = new int[23];
      int [] hashCodes100 = new int[23];
      int [] hashCodes10 = new int[23];
      File file = new File("FamousCS.txt");
      Scanner reader = new Scanner(file);
      reader.useDelimiter(",");
      String fName = "", lName = "", personFact = "";
      int count = 0;
      int birthYear = 0;
      
      while (reader.hasNext()) { // loop through text file, create person objects and add to array
         fName = reader.next();
         lName = reader.next();
         birthYear = reader.nextInt();
         personFact = reader.nextLine();
         FamousPerson2 newPerson = new FamousPerson2(fName, lName, birthYear, personFact);
         people[count] = newPerson;
         hashCodes[count] = newPerson.hashCode();
         count++;
   
      } // end while 
   
      Arrays.sort(hashCodes);
      
      for (int i=0; i < hashCodes.length; i++) { // Print sorted hash codes
         System.out.println(hashCodes[i]);
      } // end for loop
      
      for (int i=0; i < hashCodes.length; i++) { // Mod hashes
         hashCodes1000[i] = hashCodes[i] % 1000;
         hashCodes100[i] = hashCodes[i] % 100;
         hashCodes10[i] = hashCodes[i] % 10;
      } // end mod hashes
      
      Arrays.sort(hashCodes1000);
      Arrays.sort(hashCodes100);
      Arrays.sort(hashCodes10);
      
      for (int i=0; i < hashCodes1000.length; i++) { // Print sorted hash codes mod 1000
         System.out.println(hashCodes1000[i]);
      } // end for loop
      
      for (int i=0; i < hashCodes100.length; i++) { // Print sorted hash codes mod 100
         System.out.println(hashCodes100[i]);
      } // end for loop
      
      for (int i=0; i < hashCodes10.length; i++) { // Print sorted hash codes mod 10
         System.out.println(hashCodes10[i]);
      } // end for loop
   
   }

}