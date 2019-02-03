package com.dailyCodingProblem.algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mshaik on 1/31/19.
 */
public class AlgoRecursion {


  public static void main(String[] args) {

    AlgoRecursion recursion = new AlgoRecursion();

    // ArrayList<ArrayList<Integer>> list = recursion.powerset(new int[]{1,2,3});

   /* ArrayList<ArrayList<Integer>> list = recursion.powerSetRecur(new int[]{1,2,3},2);

    list.forEach(set->{
      System.out.println();
      set.forEach(System.out::print);
    });
*/

  /*  for(int num : recursion.productOfNum(new int[]{1,2,3})){
      System.out.println(num);
    }*/

   // recursion.permutations(Arrays.asList(1, 2, 3));
   // recursion.StringPermutation("abc");
    recursion.allSubStrings("abc");

  }


  public ArrayList<ArrayList<Integer>> powerset(int[] array) {

    if (array.length == 0 || array == null) {
      return new ArrayList<>();
    }

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<Integer>());

    for (int number : array) {

      int length = result.size();

      for (int j = 0; j < length; j++) {

        ArrayList<Integer> subArray = new ArrayList<>(result.get(j));
        subArray.add(number);
        result.add(subArray);
      }


    }


    return result;


  }


  public ArrayList<ArrayList<Integer>> powerSetRecur(int[] array, int index) {


    if (index < 0) {
      ArrayList<ArrayList<Integer>> emptySwt = new ArrayList<>();
      emptySwt.add(new ArrayList<Integer>());
      return emptySwt;
    }

    int element = array[index];

    ArrayList<ArrayList<Integer>> subset = powerSetRecur(array, index - 1);

    int curSubSetLength = subset.size();

    for (int i = 0; i < curSubSetLength; i++) {

      ArrayList<Integer> subsetTemp = new ArrayList(subset.get(i));
      subsetTemp.add(element);
      subset.add(subsetTemp);

    }

    return subset;
  }


  public int[] productOfNum(int[] array) {

    int[] left = new int[array.length];
    int[] right = new int[array.length];

    left[0] = 1;
    right[array.length - 1] = 1;

    for (int i = 1; i < array.length; i++) {
      left[i] = left[i - 1] * array[i - 1];
    }

    for (int j = array.length - 2; j >= 0; j--) {
      right[j] = right[j + 1] * array[j + 1];

    }

    int[] prodArray = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      prodArray[i] = left[i] * right[i];
    }

    return prodArray;

  }


  public void permutations(List<Integer> list) {

    List<List<Integer>> finalist = new ArrayList<>();
    permuteHelperSwap(0,list,finalist);
   // permuteHelper(list, new ArrayList<>(), finallist);

    finalist.forEach(permute -> {
      System.out.println();
      permute.forEach(System.out::print);
    });

  }


  public void permuteHelper(List<Integer> list, List<Integer> permute, List<List<Integer>> finalResult) {

    if (list.isEmpty()) {
      finalResult.add(permute);
    }

    for (int i = 0; i < list.size(); i++) {

      List<Integer> temp = new ArrayList<>(list);
      temp.remove(i);
      List<Integer> permuteTemp = new ArrayList<>(permute);
      permuteTemp.add(list.get(i));
      permuteHelper(temp, permuteTemp, finalResult);

    }


  }


  public void StringPermutation(String s){
    List<String> finallist = new ArrayList<>();
    permuteHelperForString(s,"",finallist);
    finallist.forEach(System.out::println);

  }

  public void permuteHelperForString(String actualString , String choosen , List<String> perms){

    if(actualString.isEmpty()){
      perms.add(choosen);
    }

    for(int i=0 ; i<actualString.length() ; i++) {

      permuteHelperForString(new StringBuilder(actualString).deleteCharAt(i).toString(),
          choosen+actualString.charAt(i),perms);

    }


  }


  public void permuteHelperSwap(int i , List<Integer> list , List<List<Integer>> perms) {

    if (i == list.size() -1) {
      perms.add(new ArrayList<Integer>(list));
    } else {
      for (int j = i; j < list.size(); j++) {
        swap(i, j, list);
        permuteHelperSwap(i + 1, list, perms);
        swap(i, j, list);
      }
    }


  }


  public void swap(int i , int j , List<Integer> list){
    int temp = list.get(i);
    list.set(i,list.get(j));
    list.set(j,temp);
  }


  public void allSubStrings(String s){

    List<String> subString = new ArrayList<>();

    for(int i = 0 ; i< s.length() ; i++) {

      for(int j=i ; j<= s.length() ;j++) {
        System.out.println(s.substring(i,j));
      }

    }

  }


}
