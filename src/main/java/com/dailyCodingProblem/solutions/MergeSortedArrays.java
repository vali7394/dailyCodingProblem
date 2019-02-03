package com.dailyCodingProblem.solutions;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by mshaik on 12/24/18.
 */

public class MergeSortedArrays {

  private class QueueNode implements Comparable<QueueNode> {

    int array,  index ,  value;

    QueueNode(int array, int index ,int value) {

      this.array = array;
      this.index = index;
      this.value = value;

    }

    public int compareTo(QueueNode node){
      if(this.value > node.value) return 1;
      else if(this.value < node.value) return -1;
      else return 0;
    }


  }


  PriorityQueue<QueueNode> priorityQueue = new PriorityQueue<>();



  public  void mergeKSortedArrays(int[][] list){

    int size=0;

    for(int i=0; i<list.length;i++) {

      size+=list[i].length;
      QueueNode node = new QueueNode(i,0,list[i][0]);
      priorityQueue.add(node);

    }

    int[] resultArray = new int[size];


    for(int i=0 ; !priorityQueue.isEmpty() ; i++) {

      QueueNode node = priorityQueue.poll();

      resultArray[i] = node.value;

      int nexIndex = node.index+1;

      if(nexIndex < list[node.array].length) {

        QueueNode newNode = new QueueNode(node.array,nexIndex,list[node.array][nexIndex]);
        priorityQueue.add(newNode);
      }


    }

    Arrays.stream(resultArray).forEach(System.out::println);
  }


}
