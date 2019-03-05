package com.csdojo;

/**
 * Created by mshaik on 2/18/19.
 */
public class QueueNode implements Comparable<QueueNode> {


  int array , index , value;

  public QueueNode(int array , int index , int value){

    this.value = value;
    this.index = index;
    this.array = array;

  }


  @Override
  public int compareTo(QueueNode o) {

    if(this.value > o.value) return 1;
    if(this.value < o.value) return -1;
    return 0;
  }
}
