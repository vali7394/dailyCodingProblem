package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

/**
 * Created by mshaik on 11/9/18.
 */
public class FlatNode {

  CustomLinkedList below;
  FlatNode next;

  FlatNode(CustomLinkedList below, FlatNode next) {
    this.below = below;
    this.next = next;
  }

}
