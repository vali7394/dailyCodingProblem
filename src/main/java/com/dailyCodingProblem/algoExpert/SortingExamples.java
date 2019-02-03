package com.dailyCodingProblem.algoExpert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by mshaik on 1/29/19.
 */
public class SortingExamples {





public static void main(String args[]){

  SortingExamples examples = new SortingExamples();

 /* for(int i: examples.mergeSort(new int[]{8,5,2,9,5,6,3})){
    System.out.println(i);
  }*/

 /* for(int i: examples.quickSort(new int[]{8,5,2,9,5,6,3})){
    System.out.println(i);
  }*/

  //System.out.println(examples.quickSelect(new int[]{8,5,2,9,5,6,3},6));
  examples.test();
}



  public int[] mergeSort(int[] array) {
    return mergeSortHelper(array);
  }


  public int[] mergeSortHelper(int[] array){

    if(array.length<=1) {
      return array ;
    }

    int mid = array.length/2;

    int[] left = Arrays.copyOfRange(array,0,mid);
    int[] right = Arrays.copyOfRange(array,mid,array.length);

    return mergeProcess(mergeSortHelper(left),mergeSortHelper(right));


  }


  public int[] mergeProcess(int[] left, int right[]) {

    int result[] = new int[left.length+right.length];

    int i =0 ;
     int j=0;
     int k=0;

    while(i<left.length && j<right.length) {

      if(left[i] < right[j]) {
        result[k] = left[i];
        i++;
      } else {
        result[k] = right[j];
        j++;
      }

      k++;


    }

    while(i<left.length){
      result[k] = left[i];
      i++;
      k++;
    }

    while (j<right.length){
      result[k] = right[j];
      j++;
      k++;
    }

    return result;

  }


  public int[] quickSort(int[] array) {

      quickSortHelper(array,0,array.length-1);

      return array;

  }


  public void quickSortHelper(int[] array , int startIndex , int endIndex) {

    if(startIndex>=endIndex){
      return;
    }

    int pivot = startIndex;
    int left = startIndex+1;
    int right = endIndex;
    while(left<=right) {
      if (array[pivot] < array[left] && array[pivot] > array[right]) {
        swap(array, left, right);
      }

      if (array[pivot] >= array[left]) {
        left++;
      }

      if (array[pivot] <= array[right]) {
        right--;
      }
    }
    swap(array,pivot,right);

    boolean isLeftSubArraySmall = right-1-startIndex < endIndex-(1+right);

    if(isLeftSubArraySmall) {
      quickSortHelper(array,startIndex,right-1);
      quickSortHelper(array,right+1,endIndex);
    }
    else {
      quickSortHelper(array,right+1,endIndex);
      quickSortHelper(array,startIndex,right-1);
    }


  }


  


  public static void swap(int[] array , int i , int j) {

    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;

  }


  public int quickSelect(int[] array,int position){
    return quickSelectHelepr(array,0,array.length-1,position-1);
  }

  public int quickSelectHelepr(int[] array , int startIndex, int endIndex , int postion) {

    while(true){

      if(startIndex > endIndex){
        return -1;
      }

      int pivot = startIndex;

      int left = startIndex+1;
      int right = endIndex;

      while(left<=right) {

        if(array[pivot]< array[left] && array[pivot]>array[right]) {
         swap(array,left,right);
        }

        if(array[pivot]>= array[left]){
          left++;
        }
        if(array[pivot] <=array[right]) {
          right--;
        }


      }

      swap(array,pivot,right);

      if(postion==right){
        return array[postion];
      }

      if(postion < right) {
        endIndex = right-1;
      }

      if(postion > right) {
        startIndex = right+1;
      }


    }




  }



  public void  test() {

    Map<String,Boolean> map = new HashMap<>();

    if((Boolean)map.get("TOO")){

    }

  }


}
