package com.dailyCodingProblem.algoExpert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mshaik on 2/1/19.
 */
public class BinarySearchTree {

  TreeNode root;


  public TreeNode addNodeToBSTRec(TreeNode node , int value){

    if(node==null) {

    return new TreeNode(value,null,null);

    }

    if(node.value < value) node.right = addNodeToBSTRec(node.right,value);
    else node.left = addNodeToBSTRec(node.left,value);

    return node;

  }


  public void addNode(int value){
    root = addNodeToBSTRec(root,value);
  }


  public boolean searchInBST(TreeNode node ,int value) {
    return searchRec(node,value);
  }


  public boolean searchRec(TreeNode node , int value) {
    if(node==null) return false;
    if(node.value == value) return true;
    if(node.value<value) return searchRec(node.right,value);
    else return searchRec(node.left,value);
  }




  public void inorderTreeBST(TreeNode node){

    if(node==null) return;
    inorderTreeBST(node.left);
    System.out.println(node.value);
    inorderTreeBST(node.right);

  }


  public void preOrderTreeBST(TreeNode node){

    if(node==null) return;

    System.out.println(node.value);
    inorderTreeBST(node.left);
    inorderTreeBST(node.right);

  }

  public void postOrderTreeBST(TreeNode node){

    if(node==null) return;


    inorderTreeBST(node.left);
    inorderTreeBST(node.right);
    System.out.println(node.value);

  }

  public int findMinInTree(TreeNode node) {
    return findMinTreeRec(root);
  }


  public int findMaxInTree(TreeNode node) {
    return findMaxTreeRec(root);
  }

  public Integer findMinTreeRec(TreeNode node){
    if(node == null) return null;
    if(node.left==null && node.right==null) return node.value;
    return findMinTreeRec(node.left);
  }


  public Integer findMaxTreeRec(TreeNode node){
    if(node == null) return null;
    if(node.left==null && node.right==null) return node.value;
    return findMaxTreeRec(node.right);
  }


  public void levelOrderTravesel(TreeNode node) {


    if(node==null) return;
    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(node);

    while(!queue.isEmpty()) {

      TreeNode temp = queue.poll();
      System.out.println(temp.value);
      if(temp.left!=null) queue.add(temp.left);
      if(temp.right!=null) queue.add(temp.right);

    }


  }

  public int finClosetInBst(TreeNode node , int value){
  //  return findClosestInBstHelper(node,Integer.MAX_VALUE,value);
    return findClosestValueIterative(node,value,Integer.MAX_VALUE);
  }


  public int findClosestInBstHelper(TreeNode node  , int closest, int target) {

    if(node.value-target==0) {
      return node.value;
    }

    if(Math.abs(node.value-target) < Math.abs(target-closest)) {
      closest = node.value;
    }

    if(target < node.value && node.left!=null) return findClosestInBstHelper(node.left,closest,target);
    else if(target > node.value && node.right!=null) return findClosestInBstHelper(node.right,closest,target);
    return closest;
  }


  public int findClosestValueIterative(TreeNode node , int target , int closest) {

    if(node==null) return closest;

    if(node.value==target) return node.value;

    TreeNode currentNode = node;

    while(currentNode!=null) {

      if(Math.abs(currentNode.value-target) < Math.abs(target-closest)) {
        closest = currentNode.value;
      }

      else if(currentNode.value < target) {
        currentNode = currentNode.right;
      }
      else if(currentNode.value > target) {
        currentNode = currentNode.left;
      }
      else{
        break;
      }


    }

    return closest;
  }


  public TreeNode removeAnElementFromBST(TreeNode node, int target) {
    return removeNodeBstHelper(node,target);
  }



  public TreeNode removeNodeBstHelper(TreeNode node , int target) {

    if(node == null) return node;

    if(node.value == target) {

      // Scenario 1 Non leaf node
      if(node.left!=null && node.right!=null) {

      node.value = findMinTreeRec(node.right);
      node.right = removeNodeBstHelper(node.right,node.value);
      return node;
      }



      if(node.left==null && node.right == null){
        return null;
      }


      else if(node.left!=null) {
        return node.left;
      }


      else{
        return node.right;
      }

    }

   else if(node.value < target) {

      node.right = removeNodeBstHelper(node.right,target);

    } else {

      node.left = removeNodeBstHelper(node.left,target);
    }

    return node;

  }


  public boolean isValidBST(TreeNode node) {

    return isValidBstHelper(node, Integer.MIN_VALUE,Integer.MAX_VALUE);


  }


  public boolean isValidBstHelper(TreeNode node, int min , int max) {

    if(node == null) return true;

    if(node.value <= min || node.value >= max) {
      return false;
    }

    if(node.left!=null) isValidBstHelper(node.left,min,node.value);
    if(node.right!=null) isValidBstHelper(node,node.value,max);

    return true;
  }


  public void inorderIterative(TreeNode node){




  }


  public boolean areBSTmirroedtoEachOther(TreeNode node , TreeNode node2){

    return isBSTMirrorHelper(node,node2);

  }


  public boolean isBSTMirrorHelper(TreeNode node1 , TreeNode node2){

    if(node1==null && node2==null) return true;

    if(node1==null || node2==null){
      return false;
    }

    if(node1.value!=node2.value) return false;

    if(isBSTMirrorHelper(node1.left,node2.right) && isBSTMirrorHelper(node1.right,node2.left)){
      return true;
    }

    return false;
  }



  public void iterativeBinaryTreeInOrderTr(TreeNode node, java.util.function.Consumer<TreeNode> callback){

    TreeNode previousNode = null;

    TreeNode currentNode = node;


    while(currentNode!=null){

      TreeNode nextNode;

      if(previousNode==null || currentNode==previousNode.parent){
        if(currentNode.left!=null){
          nextNode = currentNode.left;
        }
        callback.accept(currentNode);
        nextNode = currentNode.right!=null?currentNode.right:currentNode.parent;
      }





    }



  }


  public void increasingSubMaxProdOf3(int[] array){

    int maxProd = 0;

    for(int i=1; i< array.length;i++){




    }





  }


  public int leftMaxProduct(int[] array, int value){

    int maxValue =0 ;

    int maxIndex = -1;

    for(int i=0; i<value;i++){
      if(array[i] > maxValue && array[i] < array[value]){
      maxIndex = i;
      maxValue = array[i];
      }
    }

    return maxIndex;

  }


  public int rightMaxProduct(int[] array , int value){

    int maxProduct = 0;
    int maxIdnex = -1;

    for(int i=value+1; i<array.length;i++){

      if(array[i] > array[value] && array[i] > maxProduct){
        maxProduct = array[i];
        maxIdnex = i;
      }


    }
    return maxIdnex;

  }


  public void maxProduct(int[] array){

    int maxProduct = 0;

    for(int i=0; i< array.length;i++){

      int left = leftMaxProduct(array,i);
      int right  = rightMaxProduct(array,i);

      left = left==-1?0:left;
      right = right==-1?0:right;




    }


  }





}
