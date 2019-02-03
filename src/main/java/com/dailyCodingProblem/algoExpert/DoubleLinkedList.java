package com.dailyCodingProblem.algoExpert;

/**
 * Created by mshaik on 1/31/19.
 */
public class DoubleLinkedList {

  LinkedNode head;
  LinkedNode tail;

  class LinkedNode{

    int value;
    LinkedNode prev;
    LinkedNode next;

    LinkedNode(int value){
      this.value = value;
    }


  }



  public boolean findValueInNode(int value) {

    LinkedNode temp = head;

    while(temp!=null){

      if(temp.value==value) {
        return true;
      }

      temp = temp.next;

    }

    return false;


  }


  public void setHead(LinkedNode node){
    if(head==null){
      head = node;
      tail = node;
      return;
    }
    insertBefore(head,node);

  }


  public void setTail(LinkedNode node){
    if(tail==null){
      setHead(node);
      return;
    }
    insertAfter(tail,node);
  }

  public void insertBefore(LinkedNode node ,LinkedNode nodeToInsert){

    if(nodeToInsert==head && nodeToInsert==tail) return;

    removeNode(nodeToInsert);

    nodeToInsert.prev = node.prev;
    node.next = node;

    if(node.prev==null){
      head = nodeToInsert;
    } else{
      node.prev.next = nodeToInsert;
    }

  }


  public void insertAfter(LinkedNode node ,LinkedNode insertAfter) {
    if(insertAfter==head && insertAfter==tail) return;

    removeNode(insertAfter);

    insertAfter.next = node.next;
    insertAfter.prev = node;

    if(node.next==null){
      tail = insertAfter;
    }else {

      node.next.prev = insertAfter;
      node.next = insertAfter;

    }



  }


  public void insertATPosition(int position , LinkedNode node){

    if(position==1) {
      insertBefore(head,node);
    }

    LinkedNode temp = head;
    int current = 1;
    while(temp!=null && current++!=position) temp = temp.next;

    if(temp==null){
      setTail(node);
    }else {
      insertBefore(head,node);
    }


  }


  public void removeNode(LinkedNode node) {

    LinkedNode temp = head;

    if(node==head) head = head.next;
    if(node==tail) tail = tail.prev;

  }


  public void removeNodeFromBindinggs(LinkedNode node){

   if(node.next!=null) node.next.prev = node.prev;
   if(node.prev!=null) node.prev.next = node.next;

   node.prev = null;
   node.next = null;


  }



}
