package com.dailyCodingProblem.algoExpert;

/**
 * Created by mshaik on 2/1/19.
 */
public class BinarySearchTreeTesting {


  public static void main(String args[]) {

    BinarySearchTree bst = new BinarySearchTree();

    TopologicalSort sort = new TopologicalSort();

    bst.addNode(10);
    bst.addNode(5);
    bst.addNode(15);
    bst.addNode(2);
    bst.addNode(5);
    bst.addNode(22);
    bst.addNode(1);
    bst.addNode(-5);

   // bst.inorderTreeBST(bst.root);
   // bst.preOrderTreeBST(bst.root);
      bst.postOrderTreeBST(bst.root);
      sort.iterativePostOrderTravesal(bst.root);

   // sort.iterativeInOrderTravesal(bst.root);

   // System.out.println(bst.findMaxInTree(bst.root));
  //  System.out.println(bst.findMinInTree(bst.root));

  //  System.out.println(bst.searchInBST(bst.root,1));

   // bst.levelOrderTravesel(bst.root);

    //System.out.println(bst.finClosetInBst(bst.root,12));
   // bst.root = bst.removeAnElementFromBST(bst.root,10);
  //  bst.inorderTreeBST(bst.root);
   // System.out.println(bst.isValidBST(bst.root));
  }

}
