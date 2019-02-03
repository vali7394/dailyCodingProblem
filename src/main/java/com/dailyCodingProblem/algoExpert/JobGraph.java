package com.dailyCodingProblem.algoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mshaik on 2/1/19.
 */
public class JobGraph {

  List<JobNode> jobs ;

  Map<Integer,JobNode> jobGraph = new HashMap<>();

  public JobGraph(List<Integer> jobs)
  {
    this.jobs = new ArrayList<>();

    for(Integer job : jobs){
      jobGraph.put(job, addNodeToGraph(job));
      this.jobs.add(jobGraph.get(job));
    }

  }


  public List<JobNode> getJobs(){
    return this.jobs;
  }


  public void addPreReqs(Integer[] preReq){

      JobNode node = this.getJobNode(preReq[1]);
      node.preReqs.add(this.getJobNode(preReq[0]));

  }


  public JobNode addNodeToGraph(Integer job){
      return new JobNode(job);
  }


  public JobNode getJobNode(Integer job){

    if(!jobGraph.containsKey(job)){
      jobGraph.put(job, addNodeToGraph(job));
    }

    return jobGraph.get(job);

  }


}
