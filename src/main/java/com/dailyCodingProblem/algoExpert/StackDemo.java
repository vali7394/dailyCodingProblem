package com.dailyCodingProblem.algoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by mshaik on 1/31/19.
 */
public class StackDemo {

  int n;
  int[] array = new int[n];

  int top = -1;

  ArrayList<HashMap<String,Integer>> minMaxStack = new ArrayList<>();

  StackDemo(int size){
    this.n = size;
  }




  public void push(int ele){

    if(top==array.length){
      System.out.println("Stack is full");
      return;
    }

    int minEle = ele;
    int maxEle = ele;

    HashMap<String,Integer> minMaxMap = new HashMap();


    minMaxMap.put("MIN",minEle);
    minMaxMap.put("MAX",maxEle);

    if(minMaxStack.size()>0){

      HashMap<String,Integer> map = minMaxStack.get(minMaxStack.size()-1);
      minMaxMap.put("MIN",Math.min(map.get("min"),minEle));
      minMaxMap.put("MAX",Math.max(map.get("max"),maxEle));

    }

    minMaxStack.add(minMaxMap);
    top++;
    array[top] = ele;

  }

  public int pop(){
    if(top==-1) {
      System.out.println("Stack is Empty");
      return Integer.MIN_VALUE;
    }

    minMaxStack.remove(minMaxStack.size()-1);
    int num = array[top];
    top--;
    return num;

    }


  public int peek() {

    if(top==-1) {
      System.out.println("Stack is Empty");
      return Integer.MIN_VALUE;
    }

    return array[top];
  }


  public int getMin(){
    if(minMaxStack.isEmpty()) return Integer.MIN_VALUE;
    return minMaxStack.get(minMaxStack.size()-1).get("MIN");
  }


  public int getMax(){
    if(minMaxStack.isEmpty()) return Integer.MAX_VALUE;
    return minMaxStack.get(minMaxStack.size()-1).get("MAX");
  }

  }





