package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

/**
 * Created by mshaik on 11/25/18.
 */
public class DoubleLinkedList {

  DoubleNode start;

  public void addNodeFirst(int value) {

    DoubleNode node = new DoubleNode(value, null, null);

    if (start == null) {
      start = node;
      return;
    }

    start.prev = node;
    node.prev = null;
    node.next = start;
    start = node;

  }


  public void addNodeBefore(DoubleNode node , int value){

  if(node==null){
    System.out.println("Invalid after Adddress");
    return;
  }

  DoubleNode prev = node.prev;  // 1-3-4  2
  prev.next =  new DoubleNode(value, node.prev, node);

  }

  public void addAfter(DoubleNode node , int value) {

    if(node==null){
      System.out.println("Invalid after Adddress");
      return;
    }

    //1 2 4 -- 3
    node.next = new DoubleNode(value,node,node.next);

  }



  public void print(DoubleNode node) {
    DoubleNode temp = node;
    while(temp.next!=null) {
      temp = temp.next;

    }

  }

  public void printReverse(DoubleNode node) {
    DoubleNode temp = node;
    while(temp.next!=null) {
      temp = temp.next;

    }

    while (temp!=null){
      System.out.println(temp.value);
      temp = temp.prev;
    }

  }


  public boolean isItPalinDrum(DoubleNode node){

    DoubleNode start = node;
    DoubleNode end = node;

    if(node == null){
      return true;
    }

    while(end.next!=null) {
      end = end.next;
    }

    while (start!=end) {

      if(start.value != end.value){
        return false;
      }

      start = start.next;
      end = end.prev;




    }

    return true;
  }







}