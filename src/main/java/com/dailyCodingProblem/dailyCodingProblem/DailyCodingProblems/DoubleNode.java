package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

/**
 * Created by mshaik on 11/25/18.
 */

public class DoubleNode {

  int value;
  DoubleNode next;
  DoubleNode prev;

  DoubleNode(int value, DoubleNode prev, DoubleNode next) {
    this.value = value;
    this.next = next;
    this.prev = prev;
  }

}
