package com.csdojo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by mshaik on 2/15/19.
 */
public class Permutations {


  public static void main(String args[]){
    Permutations permutations = new Permutations();
  //  permutations.permutation("abab");
  //  permutations.permInterger();
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
   // permutations.powerSet(list);
   // permutations.noOfToplogies(3);
   // System.out.print(permutations.fibonicNo(5));
   // permutations.stairCaseProblem(4);
    permutations.topKFreqElements(new int[]{1,2,3,2,2,2,3,3,4,1,2,3,2,1,3},2);
  }


  public void permutation(String input){
   // permuHelper(input,"");
    boolean[] visited = new boolean[input.length()];
    ArrayList<String> letters = new ArrayList<>();
    permHelperString("abcc","",letters,visited);
  }


  public void permuHelper(String input, String perm){

    if(input.length()==0){
      System.out.println(perm);
      return;
    }

    for(int i=0; i<input.length();i++){
      permuHelper(new StringBuilder(input).deleteCharAt(i).toString(),perm+input.charAt(i));
    }

  }

  public void permHelperString(String array , String perm , ArrayList<String> list , boolean[] visited){

    if(array.length()==perm.length()){
      list.add(String.valueOf(perm));
    }

    else {

      for(int i=0; i<array.length();i++){

        if(visited[i]){
          continue;
        }

        visited[i] = true;
        perm = new StringBuilder(perm).append(array.charAt(i)).toString();
        permHelperString(array,perm,list,visited);
        perm = new StringBuilder(perm).deleteCharAt(perm.length()-1).toString();
        visited[i] = false;

        while (i<array.length()-1 && array.charAt(i)==array.charAt(i+1)){
          i++;
        }



      }



    }


  }



  public void permInterger(){
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(3);
    ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
   // permHelperInt(list,new ArrayList<>(),finalList);
   // permHelperInPlace(0,list,finalList);
    boolean[] visited = new boolean[list.size()];
    permHelperDuplicate(list,new ArrayList<>(),finalList,visited);
    finalList.forEach(list1 -> {
      System.out.println();
      list1.forEach(System.out::print);
    });

  }


  public void permHelperInt(ArrayList<Integer> array , ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> list){
    if(array.size()==0){
      list.add(temp);
      return;
    }

    for(int i=0; i<array.size();i++){

      if(temp.contains(array.get(i))){
        continue;
      }

      ArrayList<Integer> newList = new ArrayList<>(array);
      newList.remove(i);
      ArrayList<Integer> permList = new ArrayList<>(temp);
      permList.add(array.get(i));
      permHelperInt(newList,permList,list);
    }


  }

  public void permHelperInPlace(int index , ArrayList<Integer> array, ArrayList<ArrayList<Integer>> list){

    if(index==array.size()-1){
      list.add(new ArrayList<>(array));
      return;
    }

    for(int i=index ; i<array.size();i++){
      swap(index,i,array);
      permHelperInPlace(index+1,array,list);
      swap(index,i,array);
    }


  }


  public void permHelperDuplicate(ArrayList<Integer> array , ArrayList<Integer> perm , ArrayList<ArrayList<Integer>>
      finaList , boolean[] visited) {
    if(array.size()==perm.size()){
      finaList.add(new ArrayList<>(perm));
    }else {

      for(int i=0; i<array.size();i++){

        if(visited[i]) continue;
          visited[i] = true;
        perm.add(array.get(i));
        permHelperDuplicate(array,perm,finaList,visited);
        perm.remove(perm.size()-1);
        visited[i] = false;

        while (i<array.size()-1 && array.get(i)==array.get(i+1)){
          i++;
        }


      }




    }


  }



  public void swap(int i , int j , ArrayList<Integer> array){

    int temp = array.get(i);
    array.set(i,array.get(j));
    array.set(j,temp);

  }


  public void powerSet(List<Integer> input){

    /*List<ArrayList<Integer>> powerSet = new ArrayList<>();

    powerSet.add(new ArrayList<>());


    for(int num : input){

      int size = powerSet.size();

      for(int i=0 ; i<size;i++){
        ArrayList<Integer> powesetTemp = new ArrayList<>(powerSet.get(i));
        powesetTemp.add(num);
        powerSet.add(powesetTemp);
      }


    }*/


    recHelper(input,input.size()-1).forEach(list->{
      System.out.println();
      list.forEach(System.out::print);
    });

  }

  public ArrayList<ArrayList<Integer>> recHelper(List<Integer> input, int index){

    if(index<0){
      ArrayList<ArrayList<Integer>> subSet = new ArrayList<>();
      subSet.add(new ArrayList<>());
      return subSet;
    }

    int element = input.get(index);

    ArrayList<ArrayList<Integer>> powerSet = recHelper(input,index-1);
    int size = powerSet.size();
    for(int i=0; i<size;i++){
      ArrayList<Integer> list =new ArrayList<>(powerSet.get(i));
      list.add(element);
      powerSet.add(list);
    }

    return powerSet;
  }


  public void noOfToplogies(int n){


    Map<Integer,Integer> cache = new HashMap<>();
    cache.put(0,1);
    System.out.print(topologyHelper(n,cache));
  }


  public int topologyHelper(int n , Map<Integer,Integer> cache){

    if(cache.containsKey(n)){
      return cache.get(n);
    }

    int totalToplogies = 0;

    for(int left=0; left<n;left++){

      int right = n-left-1;

      int leftTopologeis = topologyHelper(left,cache);
      int rightTopologies = topologyHelper(right,cache);

      totalToplogies+=leftTopologeis*rightTopologies;




    }
    cache.put(n,totalToplogies);
    return totalToplogies;

  }


  public int fibonicNo(int n){
    Map<Integer,Integer> cache = new HashMap<>();
    cache.put(0,0);
    cache.put(1,0);
    cache.put(2,1);
    return fibNonHelper(n,cache);
  }

  public int fibNonHelper(int n , Map<Integer,Integer> cache){

    if(cache.containsKey(n)){
      return cache.get(n);
    }

     int fib = fibNonHelper(n-1,cache)+fibNonHelper(n-2,cache);
    cache.put(n,fib);
    return fib;
  }


  public void fibiterative(int n){

    int first =0;
    int second =1;



    for(int i=3;i<=n;i++){

      int total=first+second;
      first = second;
      second= total;

    }

    System.out.print(second);

  }


  public void stairCaseProblem(int n){

    Map<Integer,Integer> cache = new HashMap<>();

    cache.put(0,1);
    cache.put(1,1);
    //cache.put(2,2);


 /*   int fisrt = 1;
    int second = 1;

    for(int i=2; i<=n;i++){
      int current = fisrt+second;
      fisrt = second;
      second = current;

    }
*/

    System.out.print(stairCaseHelperWithXSteps(n,new int[]{1,3,5},cache));

   // System.out.print(stairCaseHelper(n,cache));

 // System.out.print(cache.get(n));
  //  System.out.print(second);
  }


  public int stairCaseHelper(int n , Map<Integer,Integer> cache){

    if(cache.containsKey(n)){
      return cache.get(n);
    }

    int ways = stairCaseHelper(n-1,cache)+stairCaseHelper(n-2,cache);

    cache.put(n,ways);
    return ways;

  }

// 3  {1,3,5}
  public int stairCaseHelperWithXSteps(int n , int[] steps, Map<Integer,Integer> cache){

    if(cache.containsKey(n)){
      return cache.get(n);
    }
    int total = 0;
    for(int i=0; i<steps.length;i++){
      if(n-steps[i]>=0) total+=cache.get(n-steps[i])!=null ? cache.get(n-steps[i]):stairCaseHelperWithXSteps(n-steps[i],steps,cache);
    }
    cache.put(n,total);

    return total;

  }


  public void topKFreqElements(int[] array , int k){

    Map<Integer,Integer> countMap = new HashMap<>();

    for(int num : array){

      if(countMap.containsKey(num)){
        countMap.put(num,countMap.get(num)+1);
      }else {
        countMap.put(num,1);
      }


    }

    PriorityQueue<Integer> queue = new PriorityQueue<>((n1,n2)->countMap.get(n1)-countMap.get(n2));

    for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
      queue.add(entry.getKey());
      if(queue.size()>k){
        queue.remove();
      }
    }

    List<Integer> list = new ArrayList<>();

    while (!queue.isEmpty()) {
      list.add(0,queue.poll());
    }

    list.forEach(System.out::print);

  }

  public void maxSlideWindow(int[] array, int k){

    List<Integer> list = new ArrayList<>();

    ArrayDeque<Integer> queue = new ArrayDeque<>();
    int i;
    for(i=0; i<k;i++){

      while (!queue.isEmpty() && array[queue.peekLast()] <= array[i]){
        queue.removeLast();
      }

      queue.addLast(i);

    }

    for (;i<array.length;i++){

      list.add(array[queue.peek()]);

      while (!queue.isEmpty() && queue.peek()<=i-k) {
        queue.removeFirst();
      }

      while (!queue.isEmpty() && array[i] >=  array[queue.peekLast()]){
        queue.removeLast();
      }

    queue.addLast(array[i]);

    }

    list.add(array[queue.peek()]);
    return ;
  }

}
