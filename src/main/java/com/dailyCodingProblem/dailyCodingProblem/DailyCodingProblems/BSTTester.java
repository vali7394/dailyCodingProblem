package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

/**
 * Created by mshaik on 11/14/18.
 */
public class BSTTester {


  public static void main(String args[]) {

   /* BinarySearchTree searchTree = new BinarySearchTree();
    searchTree.addNode(20);
    searchTree.addNode(8);
    searchTree.addNode(22);
    searchTree.addNode(4);
    searchTree.addNode(12);
    searchTree.addNode(10);
    searchTree.addNode(14);*/

     BinaryTree tree = new BinaryTree();

    tree.root = new BSTNode(10);
    tree.root.left = new BSTNode(8);
    tree.root.right = new BSTNode(2);
    tree.root.left.left = new BSTNode(3);
    tree.root.left.right = new BSTNode(5);
    tree.root.right.left = new BSTNode(2);

    tree.printAllPathsFromRootToLeaf(tree.root);
   // searchTree.printLevelOrder(searchTree.root);
  //  searchTree.findHeightOfBST();
 // System.out.println(searchTree.findMinInTree());
  //  System.out.println(searchTree.findMaxInTree());
  //  searchTree.printBSTPreOrder(searchTree.root);
//    searchTree.printInorder(searchTree.root);
 //   if(searchTree.searchBinaryTree(1))
 //   System.out.println("Node is present");
  //  else
  //    System.out.println("Node is not present");
  }

}


