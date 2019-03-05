package com.csdojo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mshaik on 2/16/19.
 */
public class StringProblems {

  int n;


  public static void main(String[] args){

    StringProblems stringProblems = new StringProblems();

    System.out.print(stringProblems.n);

  }


  public void longestSubStringWithOutDupes(String s){

    Map<Character,Integer> countMap = new HashMap<>();

    int[] longest = new int[]{0,1};

    int startIndex = 0;

    for(int i=0; i<s.length();i++){

      if(countMap.containsKey(s.charAt(i))){
        startIndex = Math.max(startIndex, countMap.get(s.charAt(i))+1);
      }

      countMap.put(s.charAt(i),i);

      if(longest[1]-longest[0] < i+1-startIndex){
        longest[0] = startIndex;
        longest[1] = i+1;
      }



    }

    s.substring(longest[1],longest[0]);

  }



  public void medianOfTwoSortedArrays(int[] array1 , int[] array2){







  }


}
