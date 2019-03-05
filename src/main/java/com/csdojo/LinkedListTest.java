package com.csdojo;

/**
 * Created by mshaik on 2/17/19.
 */
public class LinkedListTest {

  public static void main(String[] args){


    LinkedList linkedList = new LinkedList();
    linkedList.addNode(10);
    linkedList.addNode(20);
    linkedList.addNode(30);
    linkedList.addNode(40);
    linkedList.addNode(50);
    linkedList.addNode(60);
   // linkedList.reversePrintLinkedList(linkedList.head);
    //linkedList.printLinkedList(linkedList.reverseLinkedList(linkedList.head));
   // System.out.print(linkedList.nThFromLast(linkedList.head,5).value);
    linkedList.printLinkedList(linkedList.reverseNodesInKgroups(linkedList.head,3));
  }

}
