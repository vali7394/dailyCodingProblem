package com.dailyCodingProblem.algoExpert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mshaik on 2/2/19.
 */
public class MinHeap {




  public ArrayList<Integer> buildMinHeap(ArrayList<Integer> array){

    int lastParentIndx = Math.floorDiv(array.size()-2,2);

    for(int currentIdx = lastParentIndx ; currentIdx>=0; currentIdx--){


      swap(currentIdx,array.size()-1,array);

    }


    return array;
  }


  public void swiftDown(int currentInd , int endInd , ArrayList<Integer> array){

    int firstchild = currentInd*2+1;

    while(firstchild<=endInd){

      int secondChild = currentInd*2+2<=endInd?currentInd*2+2:-1;
      int swapInd;
      if(secondChild!=-1 && array.get(secondChild)<array.get(firstchild)){
        swapInd = secondChild;
      }else {
        swapInd =firstchild;
      }

      if(array.get(swapInd)<array.get(currentInd)){
        swap(swapInd,currentInd,array);
        currentInd = swapInd;
        firstchild = currentInd*2+1;
      }else {
        return;
      }


    }



  }


  public void swap(int i , int j , List<Integer> list){
    int temp = list.get(i);
    list.set(i,list.get(j));
    list.set(j,temp);
  }



  public void buildMaxHeap(ArrayList<Integer> array){

    int lastParentInd = Math.floorDiv(array.size()-2,2);

    for(int currenInd=lastParentInd ; currenInd>=0 ; currenInd--){

    }




  }


  private void swiftDownMaxHeap(ArrayList<Integer> list , int endInd , int currentInd) {

    int firstChildInd = 2 * currentInd + 1;

    while (firstChildInd <= endInd) {

      int secondChild = 2 * currentInd + 2 <= endInd ? 2 * currentInd + 2 : -1;
      int swapInd;

      if (secondChild != -1 && list.get(secondChild) > list.get(firstChildInd)) {
        swapInd = secondChild;
      } else {
        swapInd = firstChildInd;
      }

      if (list.get(swapInd) > list.get(currentInd)) {
        swap(swapInd, currentInd, list);
        currentInd = swapInd;
        firstChildInd = currentInd * 2 + 1;
      } else {
        return;
      }


    }
  }

    public void heapSort(ArrayList<Integer> array){

      buildMaxHeap(array);

      for(int i=array.size()-1; i>0 ; i++){

        swap(0,i,array);
        swiftDown(0,i-1,array);

      }


  }


}
