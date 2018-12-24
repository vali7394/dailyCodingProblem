package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mshaik on 12/18/18.
 */
public class BSTDemo {

  TreeNode root;


  private TreeNode addNodeRecursive(TreeNode node ,int value) {

    TreeNode currentNode = new TreeNode(value);

    if(node == null) {

      currentNode.left = null;
      currentNode.right = null;
      node = currentNode;

    }

    else if( node.value < value) {
      node.right = addNodeRecursive(node.right, value);
    } else {
      node.left = addNodeRecursive(node.left,value);
    }

    return node;
  }

  public void addNode(int value) {
    root = addNodeRecursive(root,value);
  }



  public void printBstInOrder(TreeNode node) {
    System.out.println("In Order of Tree Node");
    printRecursiveInOrder(node);
    }


  private void printRecursiveInOrder(TreeNode node) {

    if(node == null) return;
    printRecursiveInOrder(node.left);
    System.out.println(node.value);
    printRecursiveInOrder(node.right);

  }


  public void printPreOrder(TreeNode node) {
    System.out.println("Pre Order of Tree Node");
    printRecursivePreOrder(node);
  }

  public void printPostOrder(TreeNode node) {
    System.out.println("Post Order of Tree Node");
    printRecursivePostOrder(node);
  }

  private void printRecursivePreOrder(TreeNode node) {

    if(node == null) return;

    System.out.println(node.value);

    printRecursivePreOrder(node.left);
    printRecursivePreOrder(node.right);

  }

  private void printRecursivePostOrder(TreeNode node) {

    if(node == null) return;

    printRecursivePostOrder(node.left);
    printRecursivePostOrder(node.right);
    System.out.println(node.value);


  }

  public void getMinInTree(TreeNode node) {
    System.out.println("Min of tree is" + getMinRecursive(node));
  }

  private int getMinRecursive(TreeNode node) {
    if(node.left == null) return node.value ;
    return getMinRecursive(node.left);
  }

  public void getMaxTree(TreeNode node) {
    System.out.println("Max of tree is" + getMaxTreeRecursive(node));
  }

  private int getMaxTreeRecursive(TreeNode node) {

    if(node.right == null) return node.value;
    return getMaxTreeRecursive(node.right);

  }


  public void searchValue(TreeNode root ,int value) {
    System.out.println("Tree has the value ? True / False" + searchRecursive(root,value));
  }


  private boolean searchRecursive(TreeNode node ,int value) {

    if(node == null) return false;

    if(node.value == value) return true;
    if(node.value < value) return searchRecursive(node.right,value);
    else return searchRecursive(node.left,value);


  }


  public void printLevelOrderTree(TreeNode node) {

    if(node==null) return;

    Queue<TreeNode> queue = new ArrayDeque<>();

    queue.add(node);

    while (!queue.isEmpty()) {
      TreeNode temp = queue.peek();
      System.out.println(temp.value);
      queue.poll();
      if(temp.left!=null) queue.add(temp.left);
      if(temp.right!=null) queue.add(temp.right);
    }


  }


  public void deleteNodeFromTree(TreeNode node,int value) {

    if(node==null) return;

    TreeNode temp = deleteRecuNode(node,value);

    printBstInOrder(temp);



  }

  private TreeNode deleteRecuNode(TreeNode node , int value) {
    if(node == null) return node;

    if(node.value < value) {
     node.right = deleteRecuNode(node.right,value);
    } else if (node.value > value){
     node.left= deleteRecuNode(node.left,value);
    }

    else {

      if(node.left==null){
        return node.right;
      } else if(node.right==null) {
        return node.left;
      }

      node.value = findMin(node.right);

      node.right = deleteRecuNode(node.right,node.value);

    }

    return node;

  }


  private int findMin(TreeNode node) {
    if(node.left==null) return node.value;
    return findMin(node.left);
  }


}
