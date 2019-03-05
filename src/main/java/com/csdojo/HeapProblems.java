package com.csdojo;

import java.util.Arrays;

/**
 * Created by mshaik on 2/22/19.
 */
public class HeapProblems {


  public static void main(String[] args){
    HeapProblems problems = new HeapProblems();
    problems.mergeSort(new int[]{38,27,43,3,9,82,10});
  }


  public void heapSort(int[] array){
    buildMaxHeap(array);

    for(int i=array.length-1; i>0 ;i--){
      swap(0,i,array);
      shiftDown(array,i-1,0);
    }

    for(int n : array){
      System.out.println(n);
    }

  }



  public void buildMaxHeap(int[] array){

    int lastParent = Math.floorDiv(array.length-2,2);

    for(int i = lastParent; i>=0;i--){
      shiftDown(array,array.length-1,i);
    }

  }


  public void shiftDown(int[] array, int length , int parent){

    int left = 2*parent+1;

    while (left<= length){

      int right = 2*parent+2<=length?2*parent+2:-1;

      int swapInd = 0;

      if(right!=-1 && array[right]>array[left]){
        swapInd = right;
      }else {
        swapInd = left;
      }

      if(array[parent] < array[swapInd]){
        swap(parent,swapInd,array);
        parent = swapInd;
        left = 2*parent+1;
      }else {
        return;
      }



    }



  }

  public void swap(int i , int j , int[] array){

    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;

  }


  public void quickSort(int[] array){
      quickSortHelper(array,0,array.length-1);
    for(int n : array){
      System.out.println(n);
    }
  }

  public void quickSortHelper(int[] array , int start , int end){

    if(start>=end){
      return;
    }

    int pivot = start;
    int left = pivot+1;
    int right = end;

    while(left<=right){

      if(array[left]> array[pivot] && array[right] < array[pivot]){
        swap(left,right,array);
      }

     else if(array[left] <= array[pivot]){
        left++;
      }

      else {
       right--;
      }

    }

    swap(right,pivot,array);

    boolean isLeftSmall = right-1-start < end-right+1 ? true:false;

    if(isLeftSmall){
      quickSortHelper(array,start,right-1);
      quickSortHelper(array,right+1,end);
    }
    else {
      quickSortHelper(array,right+1,end);
      quickSortHelper(array,start,right-1);
    }

  }


  public void mergeSort(int[] array){
    int[] temp = mergeSortHelper(array);
    for(int n : temp){
      System.out.println(n);
    }

  }

  public int[] mergeSortHelper(int[] array){
    if(array.length==1){
      return array;
    }

    int mid = array.length/2;

    int[] left = Arrays.copyOfRange(array,0,mid);
    int[] right = Arrays.copyOfRange(array,mid,array.length);

    return mergeProcess(mergeSortHelper(left),mergeSortHelper(right));

  }


  public int[] mergeProcess(int[] one , int[] two){

    if(one.length==0) return two;
    if(two.length==0) return one;

    int i = 0;
    int j= 0;
    int k=0 ;

    int[] temp = new int[one.length+two.length];

    while(i<one.length && j<two.length){

      if(one[i] < two[j]){
        temp[k] = one[i];
        i++;
      } else {

        temp[k] = two[j];
        j++;
      }

      k++;

    }

    while (i<one.length){
      temp[k] = one[i];
      i++;
      k++;
    }

    while (j<two.length){
      temp[k] = two[j];
      k++;
      j++;
    }



    return temp;


  }




}
