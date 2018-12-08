package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mshaik on 11/14/18.
 */
public class BinarySearchTree {

 /* BSTNode root;


  private BSTNode addNodeRecursive(BSTNode node ,int value) {

    if(node == null) {
      return new BSTNode(value,null,null);
    }

    if(value < node.value) {
      node.left = addNodeRecursive(node.left,value);
    }

    else if(value > node.value) {
     node.right = addNodeRecursive(node.right,value);
    }


  return node;

  }


  public void addNode(int value) {
    root = addNodeRecursive(root,value);
  }


  public void printBSTPreOrder(BSTNode tree){

    if(tree == null) return;

    System.out.println(tree.value);
    printBSTPreOrder(tree.left);
    printBSTPreOrder(tree.right);

  }


  public void printInorder(BSTNode tree) {

    if(tree == null) return;

    printInorder(tree.left);
    System.out.println(tree.value);
    printInorder(tree.right);


  }

  public void printPosrOrder(BSTNode tree){
    if(tree==null) return;
    printPosrOrder(tree.left);
    printPosrOrder(tree.right);
    System.out.println(tree.value);
  }


  public boolean searchBinaryTree(int value) {
    return searchRecursive(root,value);
  }

  public boolean searchRecursive(BSTNode tree , int value) {

    if(tree == null) return false;
    if(tree.value==value) return true;

    return (value < tree.value) ?
       searchRecursive(tree.left,value): searchRecursive(tree.right,value);
    }


 public int findMinInTree(){
    return findMinInTreerec(root);
 }

  public int findMaxInTree(){
    return findMaxInTreerec(root);
  }

  public int findMaxInTreerec(BSTNode tree){
    if(tree.right==null) {
      return tree.value;
    }

    return findMaxInTreerec(tree.right);

  }

  public int findMinInTreerec(BSTNode tree){

   if(tree.left==null){
     return tree.value;
   }
   return findMinInTreerec(tree.left);
  }


 public void printLevelOrder(BSTNode tree){


   Queue<BSTNode> treeQueue = new LinkedList<>();
    treeQueue.add(tree);

    while(!treeQueue.isEmpty()) {

      BSTNode node = treeQueue.poll();
      System.out.println(node.value);
     if(node.left!=null) treeQueue.add(node.left);
     if(node.right!=null) treeQueue.add(node.right);

    }



 }


 public int findHeightRec(BSTNode tree) {

   if(tree == null) return 0;

   int heightOfLeft = findHeightRec(tree.left);
   int heightOfRight = findHeightRec(tree.right);

   return Math.max(heightOfLeft,heightOfRight)+1;


 }

 public void findHeightOfBST(){
    System.out.println(findHeightRec(root));
 }



*/

}
