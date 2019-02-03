package com.dailyCodingProblem.algoExpert;

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


}
