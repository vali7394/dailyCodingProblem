package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by mshaik on 10/9/18.
 */
public class DailyCodingProblemMainTest {

  public  static void main(String args[]) {




//    StringProblems.longestCommonSubString();

    //ArrayProblems.squareMatrix();


    for(int i=0 ; i<10;i++) {
      System.out.println(SampleSingleton.getInstance().num);
    }


   // int[] s = {-9, -2, 0, 2, 3};
   // ArrayProblems.squareAndSortedList(s)

    /* int[] nos = {10, 15, 3, 7};
    long[] result = SumProblems.productArray(nos);
    Arrays.stream(SumProblems.productArray(nos,nos.length)).forEach(System.out::println);

    if(result != null) {
      Arrays.stream(result).forEach(System.out::println);
    }*/

   //System.out.println(StringProblems.isPalinDrum("ragnar"));
   // StringProblems.printBinary(43);
  //  StringProblems.readFile("/Users/mshaik/Desktop/Coding Challenges/dailyCodingProblem","");
  //  int[] nos = {4, 2, 4, 5, 2, 3, 3};
   // SumProblems.findRepeatingNos(nos).forEach(System.out::println);
   // System.out.println(StringProblems.funnyString("acxz"));
   // SumProblems.findDuplicates(nos).forEach(System.out::println);
  // BackTracking.sumLists();
  //  ArrayProblems.maxJumpsToReachEndArray();
  //  BackTracking.stringPermuteTest("vali");

 //  int[] arr = {5,5, 5, 5,8,8, 8, 8,4};
  // System.out.print(SumProblems.findDuplicates(arr,4));

   /* int[][] mat =  {   { 2, 6, 7, 11},
                               { 3, 8, 10, 12},
                               { 4, 9, 11, 13},
                               { 5, 15, 16, 18}
                               };

        MatrixProblems.searchSortedMartix(mat, 15);*/
   // int[] array = {1,2,3,4,5};
   // int[] a = {13, 18, 25, 2, 8, 10};
  //  SortingImpl.bubbleSort(a);
   // ArrayProblems.rorateArrayUsingReverse(array,8);
   // int[] arrayA = {-3, 5, 7,  10,  11};
   //        int[] arrayB = {-1, 2, 6, 12};
    //       ArrayProblems.mergeSortedArrays(arrayA,arrayB);
 //   ArrayProblems.mergeTwoSortedArrays(arrayA,arrayB);
// int[] a = {13, 18, 25, 2;, 8, 10};
  //  System.out.println(BinarySearch.findInRotatedArray(a,10));
//
/*
    boolean a = true | false;
    int c = 'A';
    StringBuffer sb = new StringBuffer();
    sb.append((char) (c+2));
    System.out.println( sb.toString());*/

  //  System.out.println(SumProblems.power(2,-2));
    //System.out.println(SumProblems.powerIterative(2,10));

   // System.out.println(ArrayProblems.balancedParenthesis("))))()"));

    //StringProblems.findLongestPlaindrumSubString("forgeeksskeegfor");
    //StringProblems.superReducedString
      //  ("zztqooauhujtmxnsbzpykwlvpfyqijvdhuhiroodmuxiobyvwwxupqwydkpeebxmfvxhgicuzdealkgxlfmjiucasokrdznmtlwh");

//    StringProblems.learnParallelStream(30);

   // long t = System.currentTimeMillis();
    //long sum = 0L;

   // System.out.println("total:" +  LongStream.rangeClosed(1,Integer.MAX_VALUE).parallel().reduce(0,Long::sum));
   // System.out.println("processing time: " + (System.currentTimeMillis() - t) + " ms") ;

  //  int arr[] =  {1, 9, 3, 10, 4, 20, 2};
    ;
   // System.out.println(" Array size is " + ArrayProblems.findLongSubSet(arr));

//    QueueUsingLinkedList queue = new QueueUsingLinkedList();
//    queue.enQueue(10);
//    queue.enQueue(12);
//    queue.enQueue(20);
//    queue.enQueue(2);
//    System.out.println(queue.peek());
//    queue.deQueue();
//    System.out.println(queue.peek());
//    queue.deQueue();
//    System.out.println(queue.peek());
//    queue.deQueue();
//
//    System.out.println(queue.peek());

   // ArrayProblems.missingNo();

  //  StringProblems.nonRepCharcter("Leetcode");

   /* DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
    doubleLinkedList.addNodeFirst(1);
    doubleLinkedList.addNodeFirst(2);
    doubleLinkedList.addNodeFirst(3);
    doubleLinkedList.addNodeFirst(2);
    doubleLinkedList.addNodeFirst(3);

    doubleLinkedList.printReverse(doubleLinkedList.start);*/
   // System.out.println(doubleLinkedList.isItPalinDrum(doubleLinkedList.start));
   // ArrayProblems.maxProfit();

  }


  public static long measureSumPerf(Function<Long, Long> adder, long n) {
    long fastest = Long.MAX_VALUE;
    for (int i = 0; i < 10; i++) {
      long start = System.nanoTime();
      long sum = adder.apply(n);
      long duration = (System.nanoTime() - start) / 1_000_000;
      System.out.println("Result: " + sum);
      if (duration < fastest) fastest = duration;
    }
    return fastest;
  }

}
