package com.csdojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mshaik on 2/20/19.
 */
public class NTreeNode {

  int value;

  List<NTreeNode> children;

  NTreeNode(int value){

    this.value = value;
    children = new ArrayList<>();

  }

}
