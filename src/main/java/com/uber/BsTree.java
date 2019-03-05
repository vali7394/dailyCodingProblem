package com.uber;

import com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems.BSTNode;

/**
 * Created by mshaik on 2/25/19.
 */
public class BsTree {

  BsNode root;


  public void insertInToBst(int value){
    root =createHelper(root,value);
  }


  public BsNode createHelper(BsNode node , int value){


    if(root==null){
      root = new BsNode(value);

    }
    else if(value < root.value){
      root.left = createHelper(root.left,value);
    }


    else {
      root.right = createHelper(root.right,value);
    }

    return root;

  }

  public void traversePreBst(BsNode root){

    System.out.println(root.value);
    traversePreBst(root.left);
    traversePreBst(root.right);

  }

  public void traverseInBst(BsNode root){

    traversePreBst(root.left);
    System.out.println(root.value);
    traversePreBst(root.right);


  }


  public void traversePostBst(BsNode root){

    traversePreBst(root.left);
    traversePreBst(root.right);
    System.out.println(root.value);

  }


  public boolean searchElement(BsNode root , int value){

    if(root==null){
      return false;
    }

    if(root.value==value){
      return true;
    }

    if(root.value < value){
      return searchElement(root.right,value);
    }

    return searchElement(root.left,value);

  }

  public void findHeight(BsNode node){
    System.out.println(findHeightHelper(node));
  }

  public int findHeightHelper(BsNode node){

    if(node==null){
      return 1;
    }

    int findLeft = findHeightHelper(node.left);
    int findRight = findHeightHelper(node.right);

    return Math.max(findLeft,findRight)+1;


  }




}
