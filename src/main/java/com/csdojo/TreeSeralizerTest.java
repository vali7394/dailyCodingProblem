package com.csdojo;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by mshaik on 2/20/19.
 */
public class TreeSeralizerTest {

  public static void main(String[] args){


    NTreeNode node = new NTreeNode(1);

    NTreeNode chil1 = new NTreeNode(2);
    NTreeNode chil2 = new NTreeNode(3);
    NTreeNode chil3 = new NTreeNode(4);

    List<NTreeNode> children1 = new ArrayList<>();
    children1.add(chil1);
    children1.add(chil2);
    children1.add(chil3);

    node.children.addAll(children1);


    NTreeNode chi1 = new NTreeNode(5);
    NTreeNode chi2 = new NTreeNode(6);
    NTreeNode chi3 = new NTreeNode(7);

    List<NTreeNode> children2 = new ArrayList<>();
    children2.add(chi1);
    children2.add(chi2);
    children2.add(chi3);

    children1.get(0).children.addAll(children2);

    NTreeNode ch1 = new NTreeNode(8);
    NTreeNode ch2 = new NTreeNode(9);
    NTreeNode ch3 = new NTreeNode(10);

    List<NTreeNode> children3 = new ArrayList<>();
    children3.add(ch1);
    children3.add(ch2);
    children3.add(ch3);

    children1.get(1).children.addAll(children3);

    NTreeNode c1 = new NTreeNode(11);
    NTreeNode c2 = new NTreeNode(12);
    NTreeNode c3 = new NTreeNode(13);

    List<NTreeNode> children4 = new ArrayList<>();
    children1.add(c1);
    children1.add(c2);
    children1.add(c3);

    children1.get(2).children.addAll(children4);

    TreeSeralizerTest test =  new TreeSeralizerTest();

    System.out.print(test.seralize(node));

  }


  public String seralize(NTreeNode node){
    StringBuilder sb = new StringBuilder();
      seralizeHelper(node,sb);
      return sb.toString();
  }


  public void seralizeHelper(NTreeNode node , StringBuilder sb){

    if(node==null){
      sb.append("null").append(",");
    }else {

      int temp = node.value;
      int size = node.children.size();

      sb.append(temp).append(",").append(size).append(",");

      for(int i=0; i<size;i++){
        seralizeHelper(node.children.get(i),sb);
      }

    }


  }



  public NTreeNode deseralize(String string){

    Queue<String> queue = new LinkedList<>();

    queue.addAll(Arrays.asList(string.split("'")));

    return null;
  }


  public NTreeNode deserHelper(Queue<String> queue){

    String node = queue.poll();

    if(node.equals("null")){
      return null;
    } else {

      NTreeNode temp = new NTreeNode(Integer.parseInt(node));

      int size = Integer.parseInt(queue.poll());

      List<NTreeNode> children = new ArrayList<>(size);

      for(int i=0 ; i< size;i++){
        children.add(deserHelper(queue));
      }

      return temp;


    }


  }

}
