package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

/**
 * Created by mshaik on 12/3/18.
 */
public class StackUsingArray {

  int[] array ;
  int top;
  int size ;

  StackUsingArray(int size){
    array = new int[size];
    this.size = size;
    top = -1;
  }




  public void push(int value){

    if(top == size) System.out.println("Stack is Full");
    top++;
    array[top] = value;

  }


  public boolean isStackEmpty(){
    return top == -1;
  }

  public int pop(){

    if(isStackEmpty()) throw new RuntimeException("Stack is Empty");
    int popEd = array[top];
    top--;
    return popEd;

  }

}
