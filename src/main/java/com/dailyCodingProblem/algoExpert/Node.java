package com.dailyCodingProblem.algoExpert;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mshaik on 1/28/19.
 */
class Node {

  String name;

  List<Node> childs = new ArrayList<>();


  Node(String name) {
    this.name = name;
  }

  public void addChild(Node child) {
    this.childs.add(child);
  }


  public List<String> depthFirstSearch(Node node, ArrayList<String> names) {

    names.add(node.name);
    if (node != null) {
      for (int i = 0; i < node.childs.size(); i++) {
        node.childs.get(i).depthFirstSearch(childs.get(i), names);
      }

    }

    return names;

  }

  public List<String> BFS(Node node , ArrayList<String> names) {
    ArrayDeque<Node> queue = new ArrayDeque();

    queue.add(node);

    while(!queue.isEmpty()) {

      Node nodeTemp = queue.pop();
      names.add(nodeTemp.name);

      for(Node temp : nodeTemp.childs) {
        queue.add(temp);
      }

    }

    return names;

  }



}

