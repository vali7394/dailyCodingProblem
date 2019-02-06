package com.dailyCodingProblem.algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mshaik on 2/1/19.
 */
public class BinaryTree {

  TreeNode root;






  public void BinaryTreeInvert(TreeNode node){


  }


  public void mirrorTreeHelper(TreeNode node){

    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(node);

    while(!queue.isEmpty()) {

      TreeNode temp = queue.poll();
      swapTreeNodes(temp);

      if(temp.left!=null) queue.add(temp.left);
      if(temp.right!=null) queue.add(temp.right);

    }



  }


  public void mirrorTreeRec(TreeNode node){

    if(node==null) return;
    swapTreeNodes(node);
    mirrorTreeRec(node.left);
    mirrorTreeRec(node.right);

  }



  public void swapTreeNodes(TreeNode node){
    TreeNode left = node.left;
    node.left = node.right;
    node.right = left;

  }




  public void maxSumPathBinarTree(TreeNode node){


  }


  public ArrayList<Integer> maxSumTree(TreeNode node){

    if(node==null) return new ArrayList<>(Arrays.asList(0,0));

    ArrayList<Integer> leftSumArray = maxSumTree(node.left);

    int maxSumLeftBranch = leftSumArray.get(0);
    int leftMaxSumPath = leftSumArray.get(1);

    ArrayList<Integer> rightMaxSumAray = maxSumTree(node.right);
    int maxSumRightBranch = rightMaxSumAray.get(0);
    int RightMaxSum = rightMaxSumAray.get(1);

    int macChildSumBranch = Math.max(maxSumLeftBranch,maxSumRightBranch);
    int maxSumBranch = Math.max(macChildSumBranch+node.value,node.value);

    int MaxSumTree = Math.max(maxSumRightBranch+maxSumLeftBranch+node.value , maxSumBranch);

    int runningSum = Math.max(leftMaxSumPath+RightMaxSum+node.value,MaxSumTree);

    return new ArrayList<>(Arrays.asList(maxSumBranch,runningSum));

  }


}
