package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

/**
 * Created by mshaik on 12/3/18.
 */
public class QueueUsingArray {

  int queue[];
  int front = -1;
  int rear = -1;

  QueueUsingArray(int size){
    queue = new int[size];
  }


  public void enQueue(int value){

    if(isQueueFull()){
      System.out.println("Queue is full");
      return;
    }

    if(isQueueEmpty()) {
      front = rear = 0;
    }
    else {
      rear = (rear+1)%queue.length;
    }

    queue[rear] = value;

  }


  public void deQUeue(){

    if(isQueueEmpty()) {
      System.out.println("Queue is empty");
      return;
    }

    if(front==rear) {
      rear = front = -1;
    } else {
      front = (front+1)%queue.length;
    }

  }


  public int peek(){
    if(isQueueEmpty()) {
      System.out.println("Queue is empty");
    }

    return queue[front];
  }

  private boolean isQueueFull(){
    return (rear+1)%queue.length==front;
  }

  private boolean isQueueEmpty() {
    return front == -1 && rear== -1;
  }


}
