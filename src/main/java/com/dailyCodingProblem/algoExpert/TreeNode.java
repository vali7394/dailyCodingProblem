package com.dailyCodingProblem.algoExpert;

/**
 * Created by mshaik on 2/1/19.
 */
public class TreeNode {

  int value;

  TreeNode left;

  TreeNode right;

  TreeNode parent;

  TreeNode(int value , TreeNode left, TreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }


  TreeNode(int value , TreeNode left, TreeNode right,TreeNode parent) {
    this.value = value;
    this.left = left;
    this.right = right;
    this.parent = parent;
  }

}
