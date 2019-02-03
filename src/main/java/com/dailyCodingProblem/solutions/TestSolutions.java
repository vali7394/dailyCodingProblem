package com.dailyCodingProblem.solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by mshaik on 12/23/18.
 */
public class TestSolutions {

  public static void main(String[] args) {

   /* LinkedListOne one = new LinkedListOne();
    one.addNode(1);
    one.addNode(2);
    one.addNode(3);
    one.addNode(9);

   // one.iterate(one.head);

    LinkedListOne two = new LinkedListOne();

    two.addNode(2);
    two.addNode(3);
    two.addNode(9);

    LinkedListOne finalList = addTwoLinkedList(one,two);

    finalList.iterate(finalList.head);*/

   // MergeSortedArrays sortedArrays = new MergeSortedArrays();
  //  int[][] array = {{1,5,7},{3,4,8},{2,6}};
  //  sortedArrays.mergeKSortedArrays(array);

   // int[] denom = {3,5};
   // System.out.println(minCoinChangeProblem(denom,9));
   // permuteHelper("abb");

  //  int[] x = {1, 3};
   // int[] y = {2};

   // findMedianOfTwoSortedArrays(x,y);

    test();

  }

// 9321
 // 932

  public static LinkedListOne addTwoLinkedList(LinkedListOne one, LinkedListOne two){

    if(one == null) return two;
    if(two== null) return one;

    if(one == null && two==null) return null;

    Node tempOne = one.head;
    Node tempTwo = two.head;

    int carry = 0;

    LinkedListOne finalList = new LinkedListOne();

    while(tempOne!=null && tempTwo!=null) {

      int sum = carry + tempOne.value + tempTwo.value;
      int digit = sum%10;
      carry = sum/10;

      finalList.addFirst(digit);
      tempOne = tempOne.next;
      tempTwo = tempTwo.next;
    }

    if(tempOne!=null) {

      int sum = carry + tempOne.value;

      int digit = sum%10;

      carry =sum/10;

      finalList.addFirst(digit);

    }

    if(tempTwo!=null) {

      int sum = carry + tempTwo.value;
      int digit = sum%10;
      carry = sum/10;
      finalList.addFirst(digit);
    }


    if(carry!=0) finalList.addFirst(carry);

    return finalList;
  }


  public static int findRotataionInTheSortedArray(int[] array , int k) {




return 0;

  }

  private static int coinChangeProblem(int[] deno , int amount) {

    int[] ways = new int[amount+1];

    ways[0] = 1;

    for(int denom : deno) {
      int i;
      for(i=1 ; i<ways.length ; i++) {

        if(denom <= i) {
          ways[i]+=ways[i-denom];
        }


      }



    }

    return ways[amount];



  }


  private static int minCoinChangeProblem(int[] denoms , int n) {

    int ways[] = new int[n+1];
    Arrays.fill(ways,Integer.MAX_VALUE);

    int toCompare = 0;

    ways[0] = 0;

    for(int denom : denoms) {

      for(int amount=0 ; amount<ways.length;amount++) {
        if(denom <= amount) {

          if(ways[amount-denom]==Integer.MAX_VALUE) {
            toCompare = ways[amount-denom];
          } else {
            toCompare = ways[amount-denom]+1;
          }

          ways[amount] = Math.min(ways[amount],toCompare);

        }



      }



    }

    return ways[n];
  }


  public static void permuteHelper(String s) {
    generatePermutations(s,"");
  }

  public static void generatePermutations(String s , String finalString) {

    if(s.length()==0){
      System.out.println(finalString);
    }

    for(int i=0; i<s.length();i++) {
      generatePermutations(new StringBuilder(s).deleteCharAt(i).toString(),finalString+s.charAt(i));

    }


  }



  public static void findMedianOfTwoSortedArrays(int[] input1 , int[] input2) {

    if(input1.length < input2.length) System.out.println(findMedianHelper(input1,input2));
    else System.out.println(findMedianHelper(input2,input1));

  }


  public static double findMedianHelper(int[] input1 , int[] input2) {

    int x = input1.length;
    int y = input2.length;

    int start = 0;
    int end = x;



    while(start<=end) {

      int partionX = (start+end)/2;
      int partiony = (x+y+1)/2 - partionX;

      int maxLeft = partionX==0 ? Integer.MIN_VALUE : input1[partionX-1];
      int minRight = partionX==x ? Integer.MAX_VALUE : input1[partionX];

      int maxRight = partiony==0 ? Integer.MAX_VALUE: input2[partiony-1];
      int minLeft = partiony==y? Integer.MIN_VALUE:input2[partiony];

      if(maxLeft<=minRight && maxRight<=minLeft) {

        if((x+y)%2==0){
          return (double) (Math.max(maxLeft,maxRight)+Math.min(minLeft,minRight)/2);
        }else {
            return (double) Math.max(maxLeft,maxRight);
        }


      } else if(maxLeft > minRight) {
        end = partionX-1;
      } else {
        start = partionX+1;
      }


    }

    return -1;
  }



  public static void test(){

    Map<Integer,Character> map = new HashMap<>();
    for (int i = 97; i < 123; i++) {
      map.put(i-96, (char) i);
    }
    map.put(0,'z');

    String s="abc";
    int k = 2;

    StringBuffer sb = new StringBuffer();

    for(char c  : s.toCharArray()) {
      sb.append(map.get( (c-96+k)%26));

    }


    for(Map.Entry entry : map.entrySet()) {
      System.out.println(entry.getKey() + "  " + entry.getValue());
    }
  }

}
