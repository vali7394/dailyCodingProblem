package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

/**
 * Created by mshaik on 11/8/18.
 */
public class LinkedListTestClass {



  public static void main(String args[]) {


    CustomStack  customStack = new CustomStack(20);
    customStack.pushLinkedList(10);
    customStack.pushLinkedList(20);
    customStack.pushLinkedList(30);
    customStack.pushLinkedList(40);

    System.out.println(customStack.popLinkedList());
    System.out.println(customStack.peekLinked());
    System.out.println(customStack.popLinkedList());
    System.out.println(customStack.popLinkedList());
    System.out.println(customStack.isEmptyList());
    System.out.println(customStack.popLinkedList());
    System.out.println(customStack.isEmptyList());
    System.out.println(customStack.popLinkedList());
    CustomLinkedList linkedList1 = new CustomLinkedList();

    linkedList1.addNode(5);
    linkedList1.addNode(5);
    linkedList1.addNode(6);
    linkedList1.addNode(30);
    linkedList1.addNode(30);
    linkedList1.addNode(5);

   // linkedList1.findNthElement(linkedList1.head,0);
  //  linkedList1.removeDuplicates(linkedList1.head);
    //linkedList1.removeDuplicatesUsingExtraMemory(linkedList1.head);

    CustomLinkedList linkedList2 = new CustomLinkedList();

    linkedList2.addNode(10);
    linkedList2.addNode(20);



    CustomLinkedList linkedList3 = new CustomLinkedList();

    linkedList3.addNode(19);
    linkedList3.addNode(22);
    linkedList3.addNode(50);

    CustomLinkedList linkedList4 = new CustomLinkedList();

    linkedList4.addNode(28);
    linkedList4.addNode(35);
    linkedList4.addNode(40);
    linkedList4.addNode(45);


    // 11 21 23 60

   // linkedList.printLinkedList(linkedList.head);
  //  linkedList.printUsingRecursion(linkedList.head);
  //  System.out.println(linkedList.findMiddleLinkedList(linkedList.head));
  //  linkedList.printLinkedList(linkedList.findMiddleLinkedList(linkedList.head));
  //  linkedList.deleteNodeInLinkedList(linkedList.head,3);
   // linkedList.deleteNodeInLinkedList(linkedList.head,1);
  //  linkedList.deletASelectiveNode(linkedList.head.next);
    //linkedList.printLinkedList(linkedList.head);
   /* linkedList.removeDuplicates(linkedList.head);
    linkedList.printLinkedList(linkedList.head);*/

   /*FlatLinkedList flatLinkedList = new FlatLinkedList();
   flatLinkedList.addLinkedList(linkedList1);
   flatLinkedList.addLinkedList(linkedList2);
   flatLinkedList.addLinkedList(linkedList3);
   flatLinkedList.addLinkedList(linkedList4);
   flatLinkedList.printFlatLinkedList(flatLinkedList.head);*/


  }

}
