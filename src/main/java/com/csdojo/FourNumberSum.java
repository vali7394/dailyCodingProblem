package com.csdojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mshaik on 3/1/19.
 */
public class FourNumberSum {


  public static void main(String[] args){

    //int[] array = new int[]{7,6,4,-1,1,2};
   // findQuadruplets(array,16);
   // FindUniqueChar("abcd");

   // islandPerm(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}});

 /*   findMaxDistance(new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1});
    findMaxDistance(new int[]{9, 2, 3, 4, 5, 6, 7, 8, 18, 0});
    findMaxDistance(new int[]{1, 2, 3, 4, 5, 6});
    findMaxDistance(new int[]{6, 5, 4, 3, 2, 1});
*/
  //  printBinary(30);

  //  maxDistanceBetweenArrays(new int[][]{{1,2,3},{4,5},{1,2,3}});

    largestSubSet(new int[]{1,5,10,20,40});

  }

  public static void findQuadruplets(int[] array , int tragetSum){

    Map<Integer,List<ArrayList<Integer>>> map = new HashMap<>();
    List<ArrayList<Integer>> result = new ArrayList<>();

    for(int i=0; i<array.length-1;i++){

      int currentElment = array[i];

      for(int j=i+1; j<array.length;j++){

        if(map.containsKey(tragetSum-(currentElment+array[j]))){

          List<ArrayList<Integer>> pairs = map.get(tragetSum-(currentElment+array[j]));

          for(int k=0; k<pairs.size();k++){
            ArrayList<Integer> quadruplet = new ArrayList<>(4);
            ArrayList<Integer> pairNos = pairs.get(k);
            quadruplet.add(pairNos.get(0));
            quadruplet.add(pairNos.get(1));
            quadruplet.add(currentElment);
            quadruplet.add(array[j]);
            result.add(quadruplet);

          }


        }


      }


      for(int l=0;l<i;l++){
       if(map.containsKey(currentElment+array[l])){
         map.get(currentElment+array[l]).add(new ArrayList<>(Arrays.asList(currentElment,array[l])));
       } else {
         List<ArrayList<Integer>> list = new ArrayList();
         ArrayList<Integer> pairP = new ArrayList<>();
         pairP.add(currentElment);
         pairP.add(array[l]);
         list.add(pairP);
         map.put(currentElment+array[l],list);
       }

      }


    }



    result.forEach(list-> {
          System.out.println();
          list.forEach(System.out::print);
        }
    );




  }



  public static void FindUniqueChar(String input){

    Map<Character,Integer> countMap = new HashMap<>();

    for(int i=0; i<input.length();i++){

      if(countMap.containsKey(input.charAt(i))){
        countMap.put(input.charAt(i),-2);
      } else {
        countMap.put(input.charAt(i),i);
      }


    }

    int minSoFar= Integer.MAX_VALUE;

    for(int value : countMap.values()){
      if(value >= 0){
        minSoFar = Math.min(minSoFar,value);
      }
    }

    System.out.println(input.charAt(minSoFar));


  }


  public static void validAnagram(String input , String anagram){

    int[] letterCount = new int[26];
    char[] inputArray = input.toCharArray();
    char[] anagramChar = anagram.toCharArray();

    if(input.length()!=anagram.length()){
      return;
    }

    for(int i=0; i< input.length();i++){

      letterCount[inputArray[i]-'a']++;
      letterCount[anagramChar[i]-'a']--;

    }

    for(int letter : letterCount){
      if(letter!=0){
        System.out.println("Not anagram");
      }
    }


    System.out.println("anagram");

  }

  public static void islandPerm(int[][] matrix){

    int count = 0;
    for(int i=0 ;i<matrix.length;i++){

      for(int j=0; j<matrix[0].length;j++){


        if(matrix[i][j]==1)
        count+=findParemi(i,j,matrix);

      }


    }

    System.out.println(count);

  }


  public static  int findParemi(int i, int j, int[][] matrix){

    int count=0;

    if(i-1<0 || matrix[i-1][j]==0) count++;
    if(i+1>= matrix.length || matrix[i+1][j]==0) count++;
    if(j-1<0 || matrix[i][j-1]==0) count++;
    if(j+1 >= matrix[0].length || matrix[i][j+1]==0) count++;

    return count;

  }


  public void maxDistanceArray(int[] array){

    int minElementFromLeft = Integer.MAX_VALUE;
    int maxEleGreaterFromRightThanLeft = Integer.MIN_VALUE;




  }


  public static void findMaxDistance(int[] array){

    int[] leftMin = new int[array.length];
    int[] rightMax = new int[array.length];

    leftMin[0] = array[0];
    rightMax[array.length-1]=array[array.length-1];

    for(int i=1; i<array.length;i++ ){
      leftMin[i]= Math.min(leftMin[i-1],array[i]);
    }

    for(int i=array.length-2;i>=0;i--){
      rightMax[i]=Math.max(rightMax[i+1],array[i]);
    }

    int i=0; int j=0 ; int maxSofar = -1;

    while(i<array.length && j<array.length){

      if(leftMin[i] < rightMax[j]){
        maxSofar = Math.max(maxSofar,j-i);
        j++;
      }else {
        i++;
      }

    }

    System.out.println(maxSofar);


  }


  public static void printBinary(int n){
    StringBuilder sb = new StringBuilder();

   /* while(n>0){
      int rem = n%2;
      sb.append(rem);
      n = n/2;
    }
    sb.reverse();*/

    printBinaryRec(n,0,sb);
    System.out.println(sb.toString());
  }


  public static void printBinaryRec(int n, int rem, StringBuilder sb){

    if(n==0 || n==1){
      sb.append(n);
    }
  else {
      sb.append(rem);
      printBinaryRec(n % 2, n / 2, sb);
    }

  }



  public static void maxDistanceBetweenArrays(int[][] arrayList){

    int maxDis = 0;

    int minValue = arrayList[0][0];
    int maxValue = arrayList[0][arrayList[0].length-1];

    for(int i=1; i<arrayList.length;i++){
      maxDis = Math.max(maxDis,Math.max(arrayList[i][arrayList[i].length-1]-minValue,maxValue-arrayList[i][0]));
      minValue = Math.min(minValue,arrayList[i][0]);
      maxValue = Math.max(maxValue,arrayList[i][arrayList[i].length-1]);

    }

    System.out.println(minValue);
    System.out.println(maxValue);
    System.out.println(maxDis);


  }


  public static void largestSubSet(int[] array){

    int[] divisonArray = new int[array.length];
    int[] seqs = new int[array.length];

    Arrays.sort(array);

    Arrays.fill(divisonArray,1);
    Arrays.fill(seqs,-1);

    int maxIndex =0;

    for(int i=1;i<array.length;i++){

      for(int j=0; j<i;j++){

        if(array[i]%array[j]==0 && divisonArray[i]<divisonArray[j]+1){
          divisonArray[i]=divisonArray[j]+1;
          seqs[i]=j;
        }

      }

      if(divisonArray[maxIndex] <divisonArray[i]){
        maxIndex = i;
      }

    }

    while (maxIndex!=-1){
      System.out.println(array[maxIndex]);
      maxIndex = seqs[maxIndex];
    }




  }



}

