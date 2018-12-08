package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mshaik on 11/8/18.
 */
public class CustomLinkedList {

  Node head;


  public Node addNode(int value) {
    if (head == null) {
      head = new Node(value, null);
    } else {
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = new Node(value, null);
    }

    return head;
  }


  public void printLinkedList(Node node) {

    Node temp = node;

    while (temp != null) {

      System.out.println(temp.value);
      temp = temp.next;

    }


  }

  public Node printUsingRecursion(Node node) {

    if (node == null) {
      return null;
    }

    System.out.println(node.value);

    return printUsingRecursion(node.next);

  }


  public Node findMiddleLinkedList(Node node) {

    if (node == null) {
      return null;
    }

    Node fastNode = node;
    Node slowNode = node;
    Node prev = node;
    while (fastNode != null && fastNode.next != null) {
      prev = slowNode;
      slowNode = slowNode.next;
      fastNode = fastNode.next.next;
    }

    prev.next = slowNode.next;

    return node;

  }


  public void deleteNodeInLinkedList(Node node, int value) {

    Node temp = node;
    Node prev = null;

    if (temp.value == value) {
      if (temp.next != null) {
        head = head.next;
        return;
      } else {
        head = null;
        return;
      }
    }

    while (temp != null) {

      if (temp.value == value) {
        prev.next = temp.next;
        return;
      }
      prev = temp;
      temp = temp.next;
    }

    if (temp == null) {
      System.out.println("Node not found");
    }

  }

  public void deletASelectiveNode(Node node) {

   Node temp = node.next;
   node.value = temp.value;
   node.next = temp.next;
   temp = null;

  }

  public void removeDuplicates(Node node){

    Node temp = node;

    while(temp!=null&&temp.next!=null) {
      while(temp.value==temp.next.value){
        temp.next = temp.next.next;
      }
      temp = temp.next;
    }
    printLinkedList(node);

  }


  public void removeDuplicatesUsingExtraMemory(Node node) {

    Set<Integer> values = new HashSet<>();
    Node temp = node;
    Node prev = null;
    while(temp!=null){

      if(values.contains(temp.value)){
        prev.next = temp.next;
      } else {
        values.add(temp.value);
        prev = temp;
      }
      temp = temp.next;
    }
printLinkedList(node);

  }

  public  void findNthElement(Node node, int n) {

    Node temp = node;
    Node current = node;


    for(int i=0 ;i<n;i++){
      if(temp==null){
        System.out.println("N is grater than the linkedlist size");
      }
      temp = temp.next;
    }

    while(temp!=null) {
      temp = temp.next;
      current = current.next;
    }
    if(current!=null) {
      System.out.println(current.value);
    }else {
      System.out.println("No Node exist");
    }

  }


  public boolean isPalinDrum(Node node){

    Node slow = node;
    Node fast = node;
    Node midNode = node;
    Node preSLowPoint = null;

    while(fast!=null&&fast.next!=null) {
      preSLowPoint = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    if(fast!=null){
      midNode = slow;
      slow = slow.next;
    }

    Node secondHalf = reverse(slow);
    preSLowPoint.next = null;
    boolean isPalin = compareList(node,secondHalf);

    System.out.println(isPalin);

    if(midNode!=null) {
      midNode.next = slow;
    } else {
      preSLowPoint.next = slow;
    }




    return isPalin;
  }


  public Node reverse(Node secondHalf){

    Node temp = secondHalf;
    Node prev = null;
    Node next = null;

    while(temp!=null) {
      next = temp.next;
      temp.next = prev;
      prev = temp;
      temp = next;
    }

    return prev;

  }

  public boolean compareList(Node head , Node slow){

    while(slow!=null && head!=null){

      if(slow.value!=head.value) return false;
      slow = slow.next;
      head = head.next;
    }

    return true;
  }

}
