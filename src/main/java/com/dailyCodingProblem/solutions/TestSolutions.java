package com.dailyCodingProblem.solutions;

import java.util.LinkedList;

/**
 * Created by mshaik on 12/23/18.
 */
public class TestSolutions {

  public static void main(String[] args) {

    LinkedListOne one = new LinkedListOne();
    one.addNode(1);
    one.addNode(2);
    one.addNode(3);
    one.addNode(9);

   // one.iterate(one.head);

    LinkedListOne two = new LinkedListOne();

    two.addNode(2);
    two.addNode(3);
    two.addNode(9);

    LinkedListOne finalList = addTwoLinkedList(one,two);

    finalList.iterate(finalList.head);

  }

// 9321
 // 932

  public static LinkedListOne addTwoLinkedList(LinkedListOne one, LinkedListOne two){

    if(one == null) return two;
    if(two== null) return one;

    if(one == null && two==null) return null;

    Node tempOne = one.head;
    Node tempTwo = two.head;

    int carry = 0;

    LinkedListOne finalList = new LinkedListOne();

    while(tempOne!=null && tempTwo!=null) {

      int sum = carry + tempOne.value + tempTwo.value;
      int digit = sum%10;
      carry = sum/10;

      finalList.addFirst(digit);
      tempOne = tempOne.next;
      tempTwo = tempTwo.next;
    }

    if(tempOne!=null) {

      int sum = carry + tempOne.value;

      int digit = sum%10;

      carry =sum/10;

      finalList.addFirst(digit);

    }

    if(tempTwo!=null) {

      int sum = carry + tempTwo.value;
      int digit = sum%10;
      carry = sum/10;
      finalList.addFirst(digit);
    }


    if(carry!=0) finalList.addFirst(carry);

    return finalList;
  }


}
