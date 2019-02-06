package com.dailyCodingProblem.algoExpert;

import java.util.ArrayList;
import java.util.function.BiFunction;

/**
 * Created by mshaik on 2/3/19.
 */
public class ContinousMedianHandler {



  public static void main(String[] args){

    ContinousMedianHandler continousMedianHandler = new ContinousMedianHandler();
    continousMedianHandler.insert(5);
    System.out.println(continousMedianHandler.median);
    continousMedianHandler.insert(10);
    System.out.println(continousMedianHandler.median);
    continousMedianHandler.insert(100);
    System.out.println(continousMedianHandler.median);
    continousMedianHandler.insert(200);
    System.out.println(continousMedianHandler.median);
    continousMedianHandler.insert(6);
    System.out.println(continousMedianHandler.median);
    continousMedianHandler.insert(13);
    System.out.println(continousMedianHandler.median);
    continousMedianHandler.insert(14);
    System.out.println(continousMedianHandler.median);


  }



  BiFunction<Integer,Integer,Boolean> MIN_HEAP_FUN = (a,b)->a<b;
  BiFunction<Integer,Integer,Boolean> MAX_HEAP_FUN = (a,b)->a>b;

  Heap lowers = new Heap(MAX_HEAP_FUN,new ArrayList<Integer>());
  Heap highers = new Heap(MIN_HEAP_FUN,new ArrayList<Integer>());

  double median = 0;

  public double getMedian(){
    return median;
  }


  public void  insert(int n){

    if(lowers.length==0 || lowers.peak()>n){
      lowers.insert(n);
    }else {
      highers.insert(n);
    }

   reblanceHeap(lowers,highers);
    updateMedian();

  }


  public void reblanceHeap(Heap lowers , Heap highers){

    if(lowers.length - highers.length==2){
      highers.insert(lowers.remove());
    }else if (highers.length-lowers.length==2)  {
      lowers.insert(highers.remove());
    }else {
      return;
    }

  }


  public void updateMedian(){

    if(lowers.length > highers.length){
      median = lowers.peak();
    }
    else if(highers.length > lowers.length){
      median = highers.peak();
    }else {
      median = ((double)highers.peak()+(double)lowers.peak())/2;
    }

  }




  class Heap {

       ArrayList<Integer> heap = new ArrayList<>();
       BiFunction<Integer,Integer,Boolean> comparisionFun;
       int length;

    Heap(BiFunction comparisionFun , ArrayList<Integer> heap){
      this.comparisionFun = comparisionFun;
      this.heap = heap;
      }


    int peak(){
      return heap.get(0);
    }


    public ArrayList<Integer> buildHeap(ArrayList<Integer> heap){
      int lastParentInd = Math.floorDiv(heap.size()-2,2);

      for(int indx = lastParentInd; indx>=0 ; indx--){
        swiftDown(indx,heap.size()-1,heap);
      }

      return heap;

    }

    public void swiftDown(int index , int endIndex ,
                          ArrayList<Integer> heap){

      int firstChild = index*2+1;

      while(firstChild<=endIndex){

        int second = 2*index+2<=endIndex?2*index+2:-1;
        int indexToSwap;

        if(second!=-1 && comparisionFun.apply(heap.get(second),heap.get(firstChild))){
          indexToSwap = second;
        }else {
          indexToSwap = firstChild;
        }

        if(comparisionFun.apply(indexToSwap,index)){
          swap(indexToSwap,index,heap);
        }else {
          return;
        }


    }


  }


  public void swiftUp(int currentInd , ArrayList<Integer> list){
      int parentInd = Math.floorDiv(currentInd-1,2);

      while(parentInd>0) {
        if (comparisionFun.apply(list.get(currentInd), list.get(parentInd))) {
          swap(currentInd, parentInd, heap);
          currentInd = parentInd;
          parentInd = Math.floorDiv(currentInd - 1, 2);
          ;
        } else {
          return;
        }
      }

  }


    public void swap(int i ,int j , ArrayList<Integer> array){
      int temp = array.get(i);
      array.set(i,array.get(j));
      array.set(j,temp);
    }


    public int remove() {

      swap(0,heap.size()-1,heap);
      int ele = heap.get(heap.size()-1);
      length--;
      heap.remove(heap.size()-1);
      return ele;

    }

    public void insert(int n){

      heap.add(n);
      swiftUp(heap.size()-1,heap);
      length++;


    }


}

}
