//---------------------------------------------------------------------------
// UseSortedABPriQ.java            by Dale/Joyce/Weems              Chapter 9
//
// Example use of the SortedABPriQ
//---------------------------------------------------------------------------
// package ch09.apps;
import ch09.priorityQueues.*;

public class UseBSTPriQu
{
  public static void main(String[] args)
  { 
    PriQueueInterface<String> pq = new BSTPriQ<String>();
    
    pq.enqueue("C");   pq.enqueue("O");   pq.enqueue("M");
    pq.enqueue("P");   pq.enqueue("U");   pq.enqueue("T");
    pq.enqueue("E");   pq.enqueue("R");
   
    // print queue 
    pq.printPriQ();

    System.out.println("\n"+ pq.dequeue().toString());
    System.out.println(pq.dequeue().toString());

    //print queue
    pq.printPriQ();
  }
}