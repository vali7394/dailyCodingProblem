package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

/**
 * Created by mshaik on 11/11/18.
 */

public class CustomStack {

  int[] stack ;
  int top = -1;

  Node topNode ;

  CustomStack(int size){
    stack = new int[size];
  }


  public void push(int value) {
    top++;
    stack[top] = value;
  }

  public int pop() {
    if(!isEmpty()) {
      int temp = stack[top];
      top--;
      return temp;
    }
    return -1;
  }

  public int peek() {
    return stack[top];
  }

  public boolean isEmpty() {
    return top==-1;
  }


  public void pushLinkedList(int value){

    if(isEmptyList()) {
      topNode = new Node(value,null);
    }
    else {
      topNode = new Node(value,topNode);
    }

  }


  public int popLinkedList() {
    if(!isEmptyList()) {
      int value = topNode.value;
      topNode = topNode.next;
      return value;
    }

    return -1;

  }

  public int peekLinked() {
    return topNode.value;
  }

  public boolean isEmptyList() {
    return topNode == null;
  }


}
