package com.csdojo;

import java.util.Stack;

/**
 * Created by mshaik on 2/17/19.
 */
public class LinkedList {

  Node head;



  public void addNode(int value){
    if(head==null) {
      head = new Node(value);
      return ;
    }

    Node temp = head;

    while(temp.next!=null){
      temp = temp.next;
    }

    temp.next = new Node(value);
  }



  public void printLinkedList(Node node){

    if(node==null){
      return;
    }
    System.out.println(node.value);
    printLinkedList(node.next);
  }


  public void reversePrintLinkedList(Node node){
    if(node==null){
      return;
    }
    reversePrintLinkedList(node.next);
    System.out.println(node.value);
  }


  public Node reverseLinkedList(Node node)
  {
    if(node==null) return node;

    Node temp = node;
    Node prev = null;

    Node next= null;

    while(temp!=null){
      next = temp.next;
      temp.next = prev;
      prev = temp;
      temp = next;

    }

    return prev;


  }


  public Node nThFromLast(Node node, int n){

    Node fast = node;
    Node slwo = node;

    for(int i=1;i<=n;i++){
      if(fast==null) return null;
      fast= fast.next;
    }

    while (fast!=null){
      fast = fast.next;
      slwo = slwo.next;
    }

    return slwo;

  }

  public Node deleteNodeInLinkedList(Node node ,int value){

    if(node==null){
      return node;
    }

    Node temp = node;
    Node prev= null;

    while(temp!=null){

      if(temp.value == value){
        prev.next = temp.next;
        return node;
      }
      prev = temp;
      temp = temp.next;
    }

    System.out.print("No node with given value found");
    return prev;
  }


  public Node deleteMiddleNodeInLinkedList(Node node){

    Node fast = node;
    Node slow = node;
    Node prev= null;
    while (fast!=null && fast.next!=null){
      fast = fast.next.next;
      prev = slow;
      slow = slow.next;

    }

    prev.next = slow.next;
    return node;
  }


  public Node reverseNodesInKgroups(Node node, int k){

    Node temp = node;
    Node prev = null;
    Stack<Node> stack = new Stack<>();

    while(temp!=null ){
      int count=0;

      while(temp!=null  && count<k){
        stack.push(temp);
        temp = temp.next;
        count++;
      }

      while(stack.size()>0){

        if(prev==null){
          prev = stack.peek();
          node = prev;
          stack.pop();
        } else {

          prev.next = stack.peek();
          prev = prev.next;
          stack.pop();

        }


      }

    }

    prev.next = null;

    return node;

  }

}
