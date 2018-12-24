package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems.BinaryTreePkg;

import com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mshaik on 12/20/18.
 */
public class BinaryTreeDemo {

  TreeNode root;


  public void addNode(int value) {
    root = new TreeNode(value);
  }


  public void printBT(TreeNode root) {
    printRecursive(root);
  }

  private void printRecursive(TreeNode node) {
    if(node == null) return;
    printRecursive(node.left);
    System.out.println(node.value);
    printRecursive(node.right);

  }


  public boolean isBST(TreeNode node) {
   // return isBSTRecu(node);
   // return isBSTRecEfficent(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
    return isBSTUsingInOrderTravelsal(node,null);
  }


  private boolean isBSTRecu(TreeNode node) {

    if(node == null) return true;
    if(isSmallerThanRoot(node.left,node.value) && isGreaterThanRoot(node.right,node.value)
        && isBSTRecu(node.left) && isBSTRecu(node.right)) return true;

    return false;


  }


  private boolean isSmallerThanRoot(TreeNode node , int value) {
    if(node == null) return true;

    if(node.value < value & isSmallerThanRoot(node.left,value) && isSmallerThanRoot(node.right,value)) return true;
    return false;

  }

  private boolean isGreaterThanRoot(TreeNode node , int value) {

    if(node == null) return true;

    if(node.value > value && isGreaterThanRoot(node.left,value) && isGreaterThanRoot(node.right,value)) return true;
    else return false;


  }



  public void allPathsInBT(TreeNode node) {

      int[] paths = new int[20];
      inOrderPaths(node,paths,0);
  }


  private void inOrderPaths(TreeNode node, int[] paths, int pathLength) {

    if(node == null) return;
    paths[pathLength]=node.value;
    pathLength++;

    if(node.left==null && node.right==null) {
    printPath(paths,pathLength);
    } else {

      inOrderPaths(node.left,paths,pathLength);
      inOrderPaths(node.right,paths,pathLength);

    }





  }


  private void printPath(int[] path,int length){
   for(int i=0; i<length;i++) {
     System.out.print(path[i]+ " ");
   }
    System.out.println(" ");
  }



  private boolean isBSTRecEfficent(TreeNode node,int min , int max) {

    if(node == null) return true;

    if(node.value > min && node.value < max
        && isBSTRecEfficent(node.left,min,node.value)
        && isBSTRecEfficent(node.right,node.value,max)) return true;
    else
      return false;

  }



  private boolean isBSTUsingInOrderTravelsal(TreeNode node, TreeNode prev){

    if(node == null) return true;

    if(!isBSTUsingInOrderTravelsal(node.left,node)) {
      return false;
    }

    if(prev!=null && node.value <= prev.value) {
      return false;
    }

    prev = node;

    return isBSTUsingInOrderTravelsal(node.right,prev);


  }



  public void findSumInTree(TreeNode node , int sum) {
    List<Integer> intList = new ArrayList<>();
  boolean r=  findSumUtil(node,17,intList);
   if(r) intList.forEach(System.out::println);
   else  System.out.println("No path for sum " + 22);
  }


  private boolean findSumUtil(TreeNode node , int sum , List<Integer> elemetns) {

    if (node == null) return false;

    if (node.left == null && node.right == null) {

      if (sum == node.value) {
        elemetns.add(node.value);
        return true;

      } else return false;

    }


    if (findSumUtil(node.left, sum - node.value, elemetns)) {
      elemetns.add(node.value);
      return true;
    }

    if (findSumUtil(node.right, sum - node.value, elemetns)) {
      elemetns.add(node.value);
      return true;
    }

    return false;

  }

}
