package com.dailyCodingProblem.algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by mshaik on 2/1/19.
 */
public class TopologicalSort {


  public static void main(String args[]){

    TopologicalSort sort = new TopologicalSort();
    sort.getTopologicalSortOfJobs(Arrays.asList(1,2,3,4),Arrays.asList(new Integer[]{1,2},new Integer[]{1,3},new
        Integer[]{3,2}, new Integer[]{4,2}, new Integer[]{2,4})).forEach(System.out::println);

  }


  public List<Integer> getTopologicalSortOfJobs(List<Integer> jobs , List<Integer[]> dependecies){

    JobGraph graph = createJobGraph(jobs,dependecies);
    return returnOrderedJobs(graph);

  }



  public JobGraph createJobGraph(List<Integer> jobs , List<Integer[]> dependecies){
    JobGraph graph = new JobGraph(jobs);

    for(Integer[] preReq : dependecies){
      graph.addPreReqs(preReq);
    }


    return graph;

  }

  public List<Integer> returnOrderedJobs(JobGraph jobGraph){

   List<Integer> orderedJobs = new ArrayList<>();

    List<JobNode> jobNodes = jobGraph.getJobs();

    while(jobNodes.size()>0){
      JobNode jobTemp = jobNodes.get(jobNodes.size()-1);
      jobNodes.remove(jobNodes.size()-1);
      boolean containsCycle = depthFirstSearch(jobTemp,orderedJobs);

      if(containsCycle) return new ArrayList<>();

    }

    return orderedJobs;
  }


  public boolean depthFirstSearch(JobNode node , List<Integer> orderedJobs){

    if(node.visited) return false;
    if(node.inprogress) return true;

      node.inprogress = true;

    for(JobNode preReq : node.preReqs){
      boolean containsCycle =  depthFirstSearch(preReq,orderedJobs);
      if(containsCycle) return true;
    }

    node.visited = true;
    node.inprogress = false;

    orderedJobs.add(node.job);

    return false;

  }


  public boolean findPatternMatch(String input, String target){
    Integer[] temp = new Integer[target.length()];
    buildPattern(temp,target);
    return doesMatchPattern(input,target,temp);
  }


  public void buildPattern(Integer[] pattern , String targetString){

    if(targetString.length()==0) return;

    Arrays.fill(pattern,-1);

    int i= 1;
    int j=0;

    while(i<targetString.length()){

      if(targetString.charAt(i)==targetString.charAt(j)){

        pattern[i] = j;
        i++;
        j++;

      } else if(j>0){

        j= pattern[j-1]+1;
      }
      else {
        i++;
      }

    }





  }


  public boolean doesMatchPattern(String string , String target , Integer[] pattern){

    if(string.length()==0 || target.length()==0) return false;

    int i=0;
    int j=0;

    while(i+target.length()-j<=string.length()){

      if(string.charAt(i)==target.charAt(j)){

        if(j==target.length()-1) return true;

        i++;
        j++;

      } else if(j>0){
        j= pattern[j-1]+1;
      }
      else {
        i++;
      }


    }


    return false;


  }


  public void iterativeInOrderTravesal(TreeNode node) {

    Stack<TreeNode> stack = new Stack();

    TreeNode root = node;

    while(true) {

      if(root!=null){
        stack.push(root);
        root= root.left;
      }
      else{

        if(stack.isEmpty()){
          break;
        }

        TreeNode temp = stack.pop();

        System.out.println(temp.value);

        root= temp.right;


      }





    }


  }


  public void iterativePostOrderTravesal(TreeNode node){

    if(node==null) return;

    Stack<TreeNode> stack = new Stack<>();
    TreeNode root = node;

    while(true){

      if(root!=null){
        stack.push(root);
        root = root.left;
      }else {


        if(stack.isEmpty()){
          break;
        }
        TreeNode temp = stack.pop();
        if(temp==null) {
          root = temp.right;
          System.out.println(temp.value);
        }else {

        }
      }




    }



  }


}
