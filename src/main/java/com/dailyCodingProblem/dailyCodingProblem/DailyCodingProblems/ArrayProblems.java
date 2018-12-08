package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by mshaik on 10/13/18.
 */
public class ArrayProblems {



  public static void rorateArray(int[] array , int k) {

     k = k%array.length;
    int[] temp = new int[k];

    for(int i=0; i<temp.length ;i++) {
      temp[i] = array[i];
    }

    int j = 0;
    for(int i=k;i<array.length;i++){
      array[j] =array[i];
      j++;
    }

    for (int i=0;i<temp.length;i++){
      array[j] = temp[i];
      j++;
    }

    Arrays.stream(array).forEach(System.out::println);

  }

  public static void rorateArrayUsingReverse(int[] array,int k) {

    k = k%array.length;

    /*for(int i=0 ; i<k/2 ;i++) {
      swap(array,i,k-1-i);
    }

    for(int i=k ; i<array.length/2;i++) {
      swap(array,k,array.length-1);
    }

    for(int i=0 ; i<array.length/2;i++) {
      swap(array,i,array.length-1-i);
    }*/

    reverseArray(array,0,k-1);
    reverseArray(array,k,array.length-1);
    reverseArray(array,0,array.length-1);

    Arrays.stream(array).forEach(System.out::println);
  }


  static void reverseArray(int[] array , int start , int end) {
    while(start <end) {
      swap(array,start,end);
      start++;
      end--;
    }
  }

  static void swap(int[] array , int i , int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }


  public static void mergeTwoSortedArrays(int[] a , int[] b) {



    int[] finalArray = new int[a.length+b.length];
    int first = 0 , second= 0;
    int k = 0;
    while(first < a.length && second <b.length) {

      if(a[first] < a[second]) {
        finalArray[k] = a[first];
        first++;
      }
      else {
        finalArray[k] = b[second];
        second++;
      }

      k++;

    }

    while(first < a.length) {
      finalArray[k] = a[first];
      first++;
      k++;
    }

    while (second < b.length) {
      finalArray[k] = a[second];
      second++;
      k++;

    }

    Arrays.stream(finalArray).forEach(System.out::println);


  }


  public static void mergeSortedArrays(int[] a , int[] b){

    int m = a.length;
    int n = b.length;
    int l =0 ;
    int k =0;
    int f =0;
    int[] finalArray = new int[m+n];

    while(l<m && k<n) {

      if(a[l] < b[k]) {
        finalArray[f] = a[l];
        l++;
      }

      else {
        finalArray[f] = b[k];
        k++;

      }
      f++;

    }


    while(l<m) {
      finalArray[f] = a[l];
      l++;
      f++;
    }

    while(k<n) {

      finalArray[f] = b[k];
      k++;
      f++;

    }

    Arrays.stream(finalArray).forEach(System.out::println);

  }


  public static int balancedParenthesis(String s) {

    int bal = 0;
    int ans = 0;

    for (int i = 0; i < s.length(); i++) {

      bal += s.charAt(i) == '(' ? 1 : -1;

      if (bal == -1) {
        bal += 1;
        ans += 1;
      }


    }

    return ans + bal;

  }


  static void findLongestConseqSubseq(int arr[],int n)
  {

    Set<Integer> set = new HashSet<>(n);

    for(int i: arr){
      set.add(i);
    }


    int max = 0;

    for(Integer i : set){

      if(set.contains(i-1)) continue;

      int length = 0;

      while(set.contains(i++)) length++;
      max = Math.max(max,length);

    }


  System.out.println(" Array size is " + max);

  }


  static void maxSumEqK(int k){

    int[] array = {1, 2, 3, 4, 5};

    int sum =0 ;
    int start = 0;
    int end = 0;
    k= 9;

    for(int i=0;i<array.length;i++){

      while (sum>k && start<i-1){
        sum = sum-array[start];
        start++;
      }

      if(sum==k){
        end = i-1;
        System.out.println("Elemetns index are"+start+end);
      }

      if(i<array.length){
        sum = sum+array[i];
      }

    }



  }


  public static void maxProfit(){

    int[] stocks = {2, 3, 10, 6, 4, 8, 1};

    /*int[] tempArray = new int[stocks.length-1];

    for(int i=0; i<tempArray.length-1 ; i++){
      tempArray[i] = stocks[i+1]-stocks[i];
    }*/

    System.out.println("Max Profit is " + maxprofix(stocks  ));

  }


  public static int maxSumSubarray(int[] array){

    int maxSoFar = array[0];
    int maxEndingHere = 0;
    for(int i=0;i<array.length;i++){

    maxEndingHere = maxEndingHere + array[i];
    if(maxSoFar < maxEndingHere) {

      maxSoFar = maxEndingHere;

    }

    if(maxEndingHere <0){
      maxEndingHere = 0;
    }

    }


  return maxSoFar;


  }


  private static int maxprofix(int[] array){

    int diff = array[1]-array[0];
    int curSum = diff;
    int maxSOfar = curSum;

    for(int i=1; i<array.length-1;i++){

      diff = array[i+1] - array[i];

      if(curSum >0){
        curSum = curSum+diff;
      }else {
        curSum = diff;
      }

      if(maxSOfar<curSum){
        maxSOfar = curSum;
      }


    }


    return maxSOfar;
  }




  public static void maxJumpsToReachEndArray( ){

    int[] array = {1, 1, 1, 0, 1} ;

    if(array.length<=1 || array[0]<=0){
      System.out.println(0);
      return;
    }

    int ladder = array[0];
    int stairs = array[0];
    int jump = 1;

    for(int level=1 ; level<array.length;level++){

      if(level==array.length-1) {
        System.out.println(jump);
        return;
      }

      ladder = Math.max(ladder,level+array[level]);

      stairs--;

      if(stairs==0){
        jump++;

        if(level>=ladder) {
          System.out.println(-1);
          return;
        }

        stairs= ladder-level;

      }




    }





  }



  public static int findLongSubSet(int[] a){

    if(a.length<=0){
      return 0;
    }

    int logestSubSeq = 0;

    Set<Integer> set = new HashSet<>(a.length);

    for(int i : a){
      set.add(i);
    }

    for(int i: set){

      if(set.contains(i-1)) continue;
      else {
        int length = 0;
        while(set.contains(i++)){
         length++;
        }

        logestSubSeq = Math.max(logestSubSeq,length);

      }



    }


    return logestSubSeq;
  }



  public static void missingNo(){

    int[] a= {1,2,4,5,6,7,8,9};

    int start = 0 ; int end = a.length-1;

    int mid = (end+start)/2;
    while(end-start>1){



      if(a[mid]>mid+1){
        end = mid;
      } else {
        start = mid;
      }


       mid = (end+start)/2;


    }

    System.out.println(a[mid]+1);

  }


  public  static void incresingSubSeq() {

    int[] array = {1,2};

    int[] temp = new int[array.length];

    int max = 1;

    for(int i=0; i<temp.length;i++) temp[i] = 1;

    for(int i=1; i<array.length;i++) {

      for(int j=0 ; j<array.length; j++) {

        if(array[i] > array[j]) {
          temp[i] = Math.max(temp[i],temp[j] + 1);
          max = Math.max(max,temp[i]);
        }

      }



    }

    System.out.println("Max incresing sub seq" + max);


  }



}
