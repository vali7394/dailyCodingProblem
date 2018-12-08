package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

import java.util.LinkedList;

/**
 * Created by mshaik on 12/3/18.
 */
public class StackUsingLinkedList {

  Node top ;
  int size = 0;


  public void push(int value){
    if(top==null){
      top = new Node(value,value,null);
    }else {
      top = new Node(value,Math.min(top.min,value),top);
    }
    size++;
  }


  public int pop(){
    if(size==0){
      throw new RuntimeException("Stack is empty");
    }

    int value = top.valeu;

    top = top.next;
    size--;
    return value;

  }

  public boolean isStackEmpty(){
    return size==0;
  }

  public int size(){
    return this.size;
  }

  public int getMin(){
    return top.min;
  }

  public class Node{
    int valeu;
    int min;
    Node  next;


    Node(int value, int min,Node next){
      this.min = min;
      this.valeu = value;
      this.next = next;
    }

  }



}
