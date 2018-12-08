package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by mshaik on 12/6/18.
 */
public class BinaryTree {

  BSTNode root;


  public void printAllPathsFromRootToLeaf(BSTNode node) {

    int[] paths = new int[1000];
    List<String> pathsList = new ArrayList<>();
    printAllNodes(node, paths,0,pathsList);
    pathsList.stream().forEach(System.out::println);
  }


  public void printAllNodes(BSTNode node , int[] paths,int length,List<String> result) {

    if(node ==null) return;

    paths[length]= node.value;
    length++;

    if(node.left==null && node.right==null) {

      result.add(printArray(paths,length));

    }

    printAllNodes(node.left,paths,length,result);
    printAllNodes(node.right,paths, length,result);

  }



  String printArray(int ints[], int len)
  {
    int i;
    StringBuffer sb = new StringBuffer();
    sb.append('"');
    for (i = 0; i < len; i++)
    {
      sb.append(ints[i]);
      if(!(i==len-1))
      sb.append("->");
    }
    sb.append('"');
    return sb.toString();
  }


  boolean isSumEqual(int[] vals , int sum){
   return Arrays.stream(vals).reduce(Integer::sum).getAsInt()==sum;
  }




}
