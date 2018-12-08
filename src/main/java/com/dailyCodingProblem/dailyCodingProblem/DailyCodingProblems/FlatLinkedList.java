package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

/**
 * Created by mshaik on 11/9/18.
 */
public class FlatLinkedList {

  FlatNode head;

  public void addLinkedList(CustomLinkedList node) {
    if(head==null) {
      head = new FlatNode(node,null);
    }
    else {

      FlatNode temp = head;

      while(temp.next!=null) {
        temp = temp.next;
      }
      temp.next = new FlatNode(node,null);
    }
  }


  public void printFlatLinkedList(FlatNode flatNode) {

    FlatNode temp = flatNode;

    while(temp!=null) {

      CustomLinkedList linkedList = temp.below;
      Node tempNode = linkedList.head;
      while(tempNode!=null) {
        System.out.println(tempNode.value);
        tempNode = tempNode.next;
      }
      temp = temp.next;
    }

  }


}
