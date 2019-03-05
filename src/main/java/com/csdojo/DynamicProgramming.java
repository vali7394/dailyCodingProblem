package com.csdojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by mshaik on 2/14/19.
 */
public class DynamicProgramming {

  public static void main(String[] args){
    DynamicProgramming programming = new DynamicProgramming();
    //programming.noOfWaysChanges(new int[]{5},9);
   // programming.minEditOpe("abc","yabd");
   // programming.longestIncreSubSeq(new int[]{5,7,-24,12,10,2,3,12,5,6,35});
   // programming.findAnagrams("cbaebabacd","abc");
    System.out.print(programming.isPalindrumOfAnother("geeksforgeeks"));
  }


  // 75 , 105 , 120, 75,90,135


  public void maxSumNoAdjElem(int[] array) {

    int[] temp = new int[array.length];

    int first  = array[0];
    int second = Math.max(first,array[1]);

    for(int i=2 ; i<array.length;i++) {
      int current = Math.max(second,first+array[i]);
      first = second;
      second = current;
    }

    System.out.print(second);

  }


  public void noOfWaysChanges(int[] denom , int amount){

    int[] ways = new int[amount+1];

    ways[0] = 1;

    for(int den : denom){

      for(int i=1; i <=amount ; i++){

        if(den <=i){
          ways[i]+=ways[i-den];
        }

      }


      System.out.print(ways[amount]);


    }





  }

  public void minNoOfCoins(int[] denom , int i){

    int[] ways = new int[i+1];
    Arrays.fill(ways,Integer.MAX_VALUE);

    ways[0] = 0;

    for(int den : denom){

      for(int amount=1; amount<i+1;amount++){

        if(den<=amount){

          ways[amount] = Math.min(ways[amount],ways[amount-den]);
        }



      }


    }







  }


  public void minEditOpe(String one , String two){

    int[][] temp = new int[one.length()+1][two.length()+1];

    for(int i=0 ; i<=one.length();i++){
      temp[i][0] = i;
    }

    for(int j=0; j<=two.length();j++){
      temp[0][j]=j;
    }


    for(int i=1; i<=one.length();i++){

      for(int j=1; j<temp[0].length;j++){

        if(one.charAt(i-1)==two.charAt(j-1)){
          temp[i][j] = temp[i-1][j-1];
        } else {
          temp[i][j] = 1+ Math.min(temp[i-1][j-1],Math.min(temp[i-1][j],temp[i][j-1]));
        }


      }


    }

    System.out.print(temp[one.length()][two.length()]);
    //printActualEdits(temp,one.toCharArray(),two.toCharArray());

  }


  private void printActualEdit(int[][] temp , String one , String two){

    int start = one.length();
    int last = two.length();

    while(true){

      if(start==0 || last==0){
        break;
      }

      if(one.charAt(start-1)==two.charAt(last-1)){
        start = start-1;
        last = last-1;
      }

      else if(temp[start][last]==temp[start-1][last-1]+1){
        System.out.println("Edited the string" + two.charAt(last-1) + "from  " + one.charAt(start-1));
        start = start-1;
        last = last-1;
      }
      else if(temp[start][last]==temp[start][last-1]+1){
        System.out.println ("Delete the string" + two.charAt(last-1) + "from  " + one.charAt(start-1));
        last = last-1;
      }

      else if(temp[start][last]==temp[start-1][last]+1){
        System.out.println ("Delete the string" + one.charAt(start-1) + "from  " + one.charAt(start-1));
        start = start-1;
      }


    }





  }

  public void longestIncreSubSeq(int[] array){

    int[] temp = new int[array.length];
    int[] index = new int[array.length];
    Arrays.fill(temp,1);
    Arrays.fill(index,-1);

    int maxLength = 0;
    int maxIndex = -1;

    for(int i=1 ; i<array.length;i++){

      for(int j=0; j<i;j++){
        if(array[j]<array[i]){
          temp[i] = Math.max(temp[i],temp[j]+1);
          index[i] = j;
        }

      }

      if(maxLength < temp[i]){
        maxLength = temp[i];
        maxIndex = i;
      }

    }

    System.out.print(maxLength);
    buildSeq(array,maxIndex,index);

  }


  private void buildSeq(int[] array, int maxIndex,int[] seqs){

    int currentInd = maxIndex;

    while(currentInd!=-1){
      System.out.println(array[currentInd]);
      currentInd = seqs[currentInd];
    }


  }


  public void waterTrapped(int[] array){

    int[] leftMax = new int[array.length];
    int[] maxRight = new int[array.length];


    leftMax[0] = 0;
    maxRight[array.length-1] = 0;

    int maxLeftSofat = 0;

    for(int num : array){

    }




  }

  public List<Integer> findAnagrams(String s, String p) {

    List<Integer> list = new ArrayList<>();

    char[] pattern = p.toCharArray();

    Arrays.sort(pattern);

    for(int i=0; i<(s.length()-p.length()+1);i++){

      String temp = s.substring(i,i+p.length());

      char[] tempChar = temp.toCharArray();

      Arrays.sort(tempChar);

      if(Arrays.equals(pattern,tempChar)){
        list.add(i);
      }

    }

    return list;

  }


  public boolean isPalindrumOfAnother(String target){

    Map<String,Integer> map = new HashMap<>();

    String[] count = target.split("");

    for(String valie : count){

      if(map.containsKey(valie)){
        map.put(valie,map.get(valie)+1);
      }
      else {
        map.put(valie,1);
      }

    }

    int odd = 0;
    for(Map.Entry<String,Integer> entry : map.entrySet()){

      if(!(entry.getValue()%2==0)){
        odd++;
      }

      if(odd>1){
        return false;
      }

    }

    return true;


  }

}
