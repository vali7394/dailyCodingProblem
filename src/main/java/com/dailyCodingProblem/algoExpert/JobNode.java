package com.dailyCodingProblem.algoExpert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mshaik on 2/1/19.
 */
public class JobNode {

  Integer job;
  List<JobNode> preReqs;
  boolean visited;
  boolean inprogress;


  JobNode(int job){
    this.job = job;
    preReqs = new ArrayList<>();
    this.visited = false;
    this.inprogress = false;
  }



}
