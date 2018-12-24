package com.dailyCodingProblem.solutions;

/**
 * Created by mshaik on 12/23/18.
 */
public class LinkedListOne {

  Node head;


  public void addNode(int value) {

    if(head==null) {
      head = new Node(value,null);
      return;
    }

    Node temp = head;

    while(temp.next!=null) {
      temp = temp.next;
    }

    temp.next = new Node(value,null);

  }


  public void addFirst(int value) {
    if(head==null) addNode(value);
    else head = new Node(value,head);
  }


  public Node iterate(Node node) {
    if(node==null) return null;
    System.out.println(node.value);
    return iterate(node.next);
  }

}
