package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

import java.util.Stack;

/**
 * Created by mshaik on 12/3/18.
 */
public class QueueUsingStack<T> {

  Stack<T> pushStack ;
  Stack<T> popStack;

  QueueUsingStack(){
    pushStack = new Stack<>();
    popStack = new Stack<>();
  }


  public void enQueue(T value){
    pushStack.push(value);
  }

  public T deQueue(){

    if(isQueueEmpty()) throw new RuntimeException("Eror");

    if(popStack.isEmpty()){

      while (!pushStack.isEmpty()){
        popStack.push(pushStack.pop());
      }

    return   popStack.pop();
    }


    return   popStack.pop();



  }


  public int queueSize(){
    return pushStack.size() + popStack.size();
  }

  public boolean isQueueEmpty(){
    return pushStack.isEmpty() && popStack.isEmpty();
  }

}
