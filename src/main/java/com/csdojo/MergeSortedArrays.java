package com.csdojo;

import java.util.PriorityQueue;

/**
 * Created by mshaik on 2/23/19.
 */
public class MergeSortedArrays {


  public static void main(String[] args){

    int[][] temp = new int[][]{{3,5,6,9},{1,2,4,6,10},{4,5,6,11}};

    MergeSortedArrays sortedArrays = new MergeSortedArrays();

    sortedArrays.mergeKSortedArrays(temp);


  }

  public void mergeKSortedArrays(int[][] arrays){

    PriorityQueue<TestNode> queue = new PriorityQueue();

    int size = 0;

    for(int i=0; i<arrays.length;i++){

      size+= arrays[i].length;

      if(arrays[i].length!=0){
        queue.add(new TestNode(i,0,arrays[i][0]));
      }

    }

    int[] temp = new int[size];

    for(int i=0; !queue.isEmpty();i++){

      TestNode node = queue.poll();
      temp[i] = node.value;
      size++;

      int newInd = node.index+1;

      if(newInd < arrays[node.array].length){
        queue.add(new TestNode(node.array,newInd,arrays[node.array][newInd]));
      }

    }

    for (int n : temp){
      System.out.println(n);
    }


  }

  public void medianOfTwoSortedArrays(int[] input , int[] output){

    if(input.length > output.length){
      medianOfTwoSortedArrays(output,input);
    }

    int x = input.length;
    int y = output.length;









  }























  class TestNode implements Comparable<TestNode>{

    int array , index, value;

    TestNode(int array,int index,int value){
      this.value = value;
      this.array = array;
      this.index = index;
    }

    public int compareTo(TestNode node){
      if(this.value < node.value){
        return -1;
      }else if(this.value > node.value){
        return 1;
      } else {
        return 0;
      }
    }

  }

}
