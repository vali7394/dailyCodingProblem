package com.dailyCodingProblem.algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by mshaik on 1/28/19.
 */
public class Graphs {


  public static void main(String[] args) {

    Node node = new Node("A");

    Node nodeB = new Node("B");

    Node nodeC = new Node("C");
    Node nodeD = new Node("D");

    node.addChild(nodeB);
    node.addChild(nodeC);
    node.addChild(nodeD);

    Node nodeE = new Node("E");

    Node nodeF = new Node("F");
    Node nodeG = new Node("G");

    nodeB.addChild(nodeE);
    nodeB.addChild(nodeF);
    nodeB.addChild(nodeG);


   // node.depthFirstSearch(node, new ArrayList<String>()).forEach(System.out::println);
    System.out.println("BFS");
  //  node.BFS(node,new ArrayList<String>()).forEach(System.out::println);

    //int[][] temp = {{1,0,0,1,0},{1,0,1,0,0},{0,0,1,0,1},{1,0,1,0,1},{1,0,1,1,0}};
  //  RiverProblem(temp);

  //  Graphs graphs = new Graphs();

 //   long[] cache = new long[1000];
  //  System.out.println(graphs.findFibWithCahce(50,cache));
  //  System.out.println(graphs.findFibWithOutCahce(50));

    int val[] = {60, 100, 120};
    int wt[] = {10, 20, 30};
    int  W = 50;
    int[][] cache = new int[W+1][val.length+1];
   // System.out.println(kanpSack(wt,val,W,wt.length,cache));
    int[] temp = {0,1,2,21,33,45,45,45,45,45,45,45,45};
    for (int i : searchForRange(temp,45)) {
      System.out.println(i);
    }
  }


  public static void RiverProblem(int[][] matrix) {


    ArrayList<Integer> list = new ArrayList<>();

    if(matrix==null || matrix.length==0 || matrix[0].length==0) System.out.println("Invalid");

    int[][] visited = new int[matrix.length][matrix[0].length];

    for(int i=0 ; i<matrix.length;i++) {

      for(int j=0 ; j<matrix[i].length; j++) {
        if(visited[i][j]==1) {
          continue;
        }
        int count = countRevers(matrix,visited,i,j,0);
        if(count > 0) list.add(count);

      }

    }





  }


  public static int countRevers(int[][] matrix, int[][] visited , int i , int j , int count) {

    if(i>=matrix.length || i<0 || j>=matrix[0].length || j<0) return count;

    if(visited[i][j]==1) {
      return count;
    }

    visited[i][j] = 1;
    if(matrix[i][j]==0) {
      return count;
    }

    count++;
     count+=countRevers(matrix,visited,i-1,j,0) + countRevers(matrix,visited,i,j-1,0) +
        countRevers(matrix,visited,i+1,j,0) + countRevers(matrix,visited,i,j+1,0);
    return count;

  }


  public long findFibWithCahce(int n , long[] cache) {

    if(n<=1) return 0;

    if(n == 2) return 1;

    if(cache[n] != 0 ) return cache[n];

    return cache[n] = findFibWithCahce(n-1,cache) + findFibWithCahce(n-2,cache);

  }


  public long findFibWithOutCahce(int n) {

    if(n<=1) return 0;

    if(n == 2) return 1;

    Stack<Character> s = new Stack<>();
    return findFibWithOutCahce(n-1) + findFibWithOutCahce(n-2);

  }


  public static boolean balancedBrackets(String str) {

    Stack<Character> expStack = new Stack<>();

    String openingBraces = "{([";
    String closingBraces = "})]";

    Map<Character,Character> matchingBrace = new HashMap<>();

    matchingBrace.put('}','{');
    matchingBrace.put(']','[');
    matchingBrace.put(')','(');

    for(Character letter : str.toCharArray()) {

      if(openingBraces.indexOf(letter)!=-1) {
        expStack.push(letter);
        continue;
      }


      if(closingBraces.indexOf(letter)!=-1) {

        if(expStack.isEmpty()) {
          return false;
        }

        if(expStack.pop().equals(matchingBrace.get(letter))) {
          continue;
        }
        else {
          return false;
        }
      }

    }

    if(!expStack.isEmpty()) return false;

    return true;
  }


  public static int kanpSack(int[] w , int[] v , int capacity , int n , int[][] cache) {

    if(n==0 || capacity==0) {
      cache[capacity][n] = 0;
      return 0;
    }

    if(w[n-1]> capacity)  {
      if(cache[capacity][n-1]!=0) return cache[capacity][n-1];
      cache[capacity][n-1] = kanpSack(w,v,capacity,n-1,cache);
      return cache[capacity][n-1];
    }
    else {

      int itemWithInclude = 0;
      int itemWithOutInclude = 0;
      if(cache[capacity-w[n-1]][n-1]!=0) {
        itemWithInclude = cache[capacity-w[n-1]][n-1];
      } else {
        cache[capacity-w[n-1]][n-1] = kanpSack(w,v,capacity-w[n-1],n-1,cache);
        itemWithInclude = cache[capacity-w[n-1]][n-1];
      }

      if(cache[capacity][n-1]!=0) {
        itemWithOutInclude = kanpSack(w,v,capacity,n-1,cache);
      } else {
        cache[capacity][n-1] =kanpSack(w,v,capacity,n-1,cache);
        itemWithOutInclude = kanpSack(w,v,capacity,n-1,cache);
      }

     return  Math.max(itemWithInclude+v[n-1],itemWithOutInclude);

    }

  }


  public static int[] findThreeLargestNumbers(int[] array) {
    // Write your code here.

    if(array==null || array.length==0) {
      int[] temp = {};
      return temp ;
    }
    int[] result = new int[3];
    Arrays.fill(result,Integer.MIN_VALUE);
    result[2] = array[0];
    for(int i=1 ; i<array.length ; i++) {

      if(result[2]<= array[i]) {
        result[0] = result[1];
        result[1] = result[2];
        result[2] = array[i];
      } else if(result[1] <= array[i]) {
        result[0] = result[1];
        result[1] = array[i];
      } else if(result[0] < array[i]){
        result[0] = array[i];
      }


    }

    return result;

  }

  public static int[] searchForRange(int[] array, int target) {
    // Write your code here.
    int first = firstOccuranceOfNo(array,target);
    int last = lastOccuranceOfNo(array,target);
    return new int[]{first,last};
  }



  public static int firstOccuranceOfNo(int[] a , int target) {

    int start = 0;
    int end = a.length-1;
    int firstOccurance = -1;
    int mid = 0;

    while(start<=end) {

      mid = (start+end)/2;

      if(a[mid]==target) {
        firstOccurance = mid;
        end = mid-1;
      }

      if(a[mid] < target) {
        start = mid+1;
      } else if(a[mid] > target){
        end = mid-1;
      }


    }
    return firstOccurance;

  }

  public static int lastOccuranceOfNo(int[] a , int target) {

    int start = 0;
    int end = a.length-1;
    int lastOccurance = -1;
    int mid = 0;

    while(start<=end) {

      mid = (start+end)/2;

      if(a[mid]==target) {
        lastOccurance = mid;
        start = mid+1;
      }

      if(a[mid] < target) {
        start = mid+1;
      } else if(a[mid] > target){
        end = mid-1;
      }


    }
    return lastOccurance;

  }

  public static int[] bubbleSort(int[] array) {

    if(array==null || array.length==0) return new int[]{};

    boolean isSorted = false;
    int counter = 0;
    while(!isSorted) {

      isSorted = true;

      for(int i=0 ; i<array.length-1-counter;i++) {

        if(array[i] > array[i+1]) {
          swap(array,i,i+1);
          isSorted = false;
        }


      }


      counter++;


    }
      return array;

  }

  public static void swap(int[] array , int i , int j) {

    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;

  }


  public static String longestPalindromicSubstring(String s) {

    if(s==null || s.length()==0) return s;
    int[] longPaniIndexs = {0,1};
    String longestPalin = "";
    for(int i=1 ; i<s.length();i++){

      int[] oddPalin = longestPalinFrom(s,i-1,i+1);
      int[] evenPalin = 	longestPalinFrom(s,i-1,i);

      int[] longest = evenPalin[1]-evenPalin[0] > oddPalin[1]-oddPalin[0]
          ? evenPalin:oddPalin;

      longPaniIndexs = longest[1]-longest[0] > longPaniIndexs[1]-longPaniIndexs[0] ?
          longest:longPaniIndexs;
    }

    return s.substring(longPaniIndexs[0],longPaniIndexs[1]);

  }


  public static int[] longestPalinFrom(String s , int startIndex ,int endIndex){

    while(startIndex>=0 || endIndex<=s.length()-1) {

      if(s.charAt(startIndex)!=s.charAt(endIndex)){
        break;
      }
      startIndex--;
      endIndex++;
    }

    return new int[]{startIndex+1,endIndex};
  }


  public static void bitwiseOp() {

    int n = 10;

    System.out.println(10<<1);


  }


}





