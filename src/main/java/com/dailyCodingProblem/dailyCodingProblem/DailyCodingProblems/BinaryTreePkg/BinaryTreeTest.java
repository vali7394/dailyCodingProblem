package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems.BinaryTreePkg;

import com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems.TreeNode;

/**
 * Created by mshaik on 12/20/18.
 */
public class BinaryTreeTest {


  public static void main(String[] args) {

    BinaryTreeDemo btDemo = new BinaryTreeDemo();
    btDemo.addNode(10);
    btDemo.root.left = new TreeNode(5);
    btDemo.root.left.left = new TreeNode(2);
    btDemo.root.right = new TreeNode(17);
    btDemo.root.right.left = new TreeNode(11);
    btDemo.allPathsInBT(btDemo.root);
    //btDemo.printBT(btDemo.root);
   // btDemo.findSumInTree(btDemo.root,17);
    //System.out.println("Is BST" + btDemo.isBST(btDemo.root));

  }
}
