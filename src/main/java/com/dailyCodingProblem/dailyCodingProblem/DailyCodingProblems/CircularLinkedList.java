package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

/**
 * Created by mshaik on 11/11/18.
 */
public class CircularLinkedList {

  Node head;
  Node last;
  int size = 0;


  public void addLinkedListAtLast(int value) {
    Node node = new Node(value,null);
    if(isEmpty()) {

    head = node ;
    last = node;
    size = 1;

    }
    else {

      node.next = last.next;
      last.next = node;
      size++;
    }

  }

  public void addLastLinkedList(int value) {

    Node node = new Node(value,null);

    if(head==null){
      head = node;
      size=1;
    }





  }


  public int getLength(){
    return size;
  }

  public boolean isEmpty(){
    return size==0;
  }

}
