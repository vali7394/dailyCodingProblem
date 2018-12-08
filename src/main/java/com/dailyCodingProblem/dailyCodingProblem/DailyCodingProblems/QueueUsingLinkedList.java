package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

/**
 * Created by mshaik on 12/3/18.
 */
public class QueueUsingLinkedList {

 class Node{

   int value;
   Node next;

   Node(int value , Node next) {
     this.value = value;
     this.next = next;
   }

  }

  Node front;
  Node rear;

 public void enQueue(int value){

   Node node = new Node(value,null);
   if(front == null && rear== null) {

     front = rear = node;
   } else {
     rear.next = node;
     rear = node;
   }

 }


 public void deQueue(){

   if(front==null) return;
    if(front == rear){
      front = rear = null;
   }else {
     front = front.next;
   }


 }

 public int peek(){
   return front.value;
 }





}
