package com.uber;

/**
 * Created by mshaik on 2/25/19.
 */
public class TestBsClass {

  public static void main(String[] args){

    BsTree tree = new BsTree();
    tree.insertInToBst(10);
    tree.insertInToBst(5);
    tree.insertInToBst(15);
    tree.insertInToBst(20);
    tree.insertInToBst(7);
    tree.insertInToBst(4);

    tree.traversePreBst(tree.root);



  }

}
