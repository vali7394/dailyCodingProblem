package com.dailyCodingProblem.algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mshaik on 2/2/19.
 */
public class MinHeap {


  public static void main(String[] args){
    MinHeap minHeap = new MinHeap();
    minHeap.heapSort(new int[]{8,5,2,9,5,6,3});
  }


  public void heapSort(int[] array){

   // buildMinHeap(array);
    buildMapHeap(array);
    for(int endIndx=array.length-1  ;endIndx>0;endIndx--){
      //sfitDown(i,a);
      swap(0,endIndx,array);
      swiftDown(array,0,endIndx-1);
    }

    Arrays.stream(array).forEach(System.out::println);

  }



  public void buildMinHeap(int[] array){

    int lastParentInd = Math.floorDiv(array.length-2,2);

    for(int i = lastParentInd ; i>=0 ; i--){
      sfitDown(i,array.length-1,array);
    }


  }

  public void sfitDown(int index , int endIndex , int[] array){

    int firstChild = 2*index+1;

    while(firstChild<=endIndex){

      int secondChild = 2*index+2<=endIndex?2*index+2:-1;
      int swapIndex;
      if(secondChild!=-1 && array[firstChild] > array[secondChild]){
        swapIndex = secondChild;
      }else {
        swapIndex = firstChild;
      }


      if(array[swapIndex] < array[index]){
        swap(swapIndex,index,array);
        index = swapIndex;
        firstChild = 2*index+1;
      }else {
        return;
      }


    }


  }




  public void swap(int i ,int j , int[] array){
    int temp = array[i];
    array[i] = array[j];
    array[j]= temp;
  }


  public void buildMapHeap(int[] array){

    int lastParent = Math.floorDiv(array.length-2,2);

    for(int i=lastParent;i>=0;i--){
      swiftDown(array,i,array.length-1);
    }


  }


  public void swiftDown(int[] array,int index,int endIndex){

    int firstChild = 2*index+1;

    while(firstChild<=endIndex){

      int second = 2*index+2<=endIndex?2*index+2:-1;
      int indexToSwap;
      if(second!=-1 && array[firstChild] < array[second]){
        indexToSwap = second;
      }else {
        indexToSwap = firstChild;
      }

      if(array[indexToSwap]>array[index]){
        swap(index,indexToSwap,array);
        index = indexToSwap;
        firstChild = 2*index+1;
      }
      else {
        return;
      }



    }

  }


  public void swiftUp(int currentIndex , int[] array){

    int parentInd = Math.floorDiv(currentIndex-1,2);

    while(currentIndex>0 && array[currentIndex]<array[parentInd]){
      swap(currentIndex,parentInd,array);
      currentIndex = parentInd;
      parentInd = Math.floorDiv(currentIndex-1,2);
    }


  }


}
