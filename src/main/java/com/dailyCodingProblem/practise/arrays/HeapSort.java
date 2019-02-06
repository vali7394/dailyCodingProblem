package com.dailyCodingProblem.practise.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;

/**
 * Created by mshaik on 2/5/19.
 */
public class HeapSort {

  // Build Min / Max Heap
  // SiftDown

  BiFunction<Integer,Integer,Boolean> maxHeapFun = (a,b)-> a>b;
  BiFunction<Integer,Integer,Boolean> minHeap = (a,b)-> a<b;

  public static void main(String[] args){
    HeapSort sort = new HeapSort();
    sort.heapSort(new int[] {8,5,2,9,5,6,3});
  }


  public void heapSort(int[] array){


      buildMinHeap(array);

     // buildMaxHeap(array);


    for(int i=array.length-1; i>=0;i--){

      swap(array,0,i);
      swiftDownForMinHeap(array,0,i-1);
      //siftDown(array,0,i-1,maxHeapFun);

    }

    Arrays.stream(array).forEach(System.out::println);


  }



  /*public  void buildMinHeap(int[] array){

    int lastParentInd = Math.floorDiv(array.length-2,2);

    for(int i=lastParentInd;i>=0;i--){
      siftDown(array,lastParentInd,array.length-1,minHeap);
    }

  }*/


  public void buildMaxHeap(int[] array){

    int firstParentIndx = Math.floorDiv(array.length-2,2);

    for(int i=firstParentIndx; i>=0 ;i--){
      siftDown(array,i,array.length-1,maxHeapFun);
    }


  }


  public void siftDown(int[] array , int parentIndx , int endIndx, BiFunction<Integer,Integer,Boolean>
      comparisionFun){

    int firstChild= 2*parentIndx+1;

    while(firstChild<=endIndx){

      int secondChild = 2*parentIndx+2<=endIndx?2*parentIndx+2:-1;
      int swapIndex ;
      if(secondChild!=-1 && comparisionFun.apply(array[secondChild],array[firstChild])){
        swapIndex = secondChild;
      }else {
        swapIndex = firstChild;
      }

      if(comparisionFun.apply(swapIndex,parentIndx)){
        swap(array,swapIndex,parentIndx);
        parentIndx = swapIndex;
        firstChild = 2*parentIndx+1;
      }else {
        return;
      }


    }




  }

  public void swap(int[] array , int i , int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;

  }



  public void buildMinHeap(int[] array){

    int lasrParentInd = Math.floorDiv(array.length-2,2);

    for(int i=lasrParentInd;i>=0;i--){
      swiftDownForMinHeap(array,i,array.length-1);
    }

  }


  public void swiftDownForMinHeap(int[] array , int lastParent, int end){

    int first = 2*lastParent+1;

    int second = 2*lastParent+2<=end?2*lastParent+2:-1;

    int swapInd;

    if(second!=-1 && array[second] < array[first]){
      swapInd = second;
    }else {
      swapInd = first;
    }

    if(array[swapInd] < array[lastParent]){
      swap(array,swapInd,lastParent);
      lastParent = swapInd;
      first = 2*lastParent+1;
    }else {
      return;
    }


  }


  public void siftup(int array[] , int end){

    int parentIndx = (end-1)/2;

   while (end>0){

     if(array[parentIndx] < array[end]){

       swap(array,parentIndx,end);
       end = parentIndx;
       parentIndx = (end-1)/2;

     }
     else {
       return;
     }


   }



  }





}
