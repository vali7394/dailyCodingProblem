package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mshaik on 10/11/18.
 */
public class BackTracking {


  public static void allPsblDice(int dice, int faces){
    List<Integer> list = new ArrayList<>();
    allDiceHelp(dice,6,0,list);
  }


  public static void allDiceHelp(int dice , int desiredSUm ,int sumsoFar,List<Integer> chocies) {

    if(dice ==0 ){

        System.out.println();
        chocies.forEach(System.out::print);

    } else {

      for(int i=1; i<=6 ; i++){
        if((sumsoFar+i+1*(dice-1))<=desiredSUm && (sumsoFar+i+6*(dice-1)>=desiredSUm)) {
          chocies.add(i);
          allDiceHelp(dice - 1, desiredSUm, sumsoFar + i, chocies);
          chocies.remove(chocies.size() - 1);
        }
      }


    }



  }




  public static void dice(int dice , int faces) {

    List<Integer> possibilities = new ArrayList<>();

    diceHelper(dice,faces,7,0,possibilities);

  }


  private static void diceHelper(int dice,int faces ,int desiredSum,int sumSoFar, List<Integer> choosen) {

    if(dice == 0) {
      if(sumSoFar == desiredSum) {
        System.out.println();
        choosen.forEach(System.out::print);
      }
    }
    else{

      for(int i=1 ; i<=faces;i++) {
        if((sumSoFar+i+1*(dice-1) <= desiredSum) && (sumSoFar+i+6*(dice-1) >=desiredSum) ) {
          choosen.add(i);
          diceHelper(dice - 1, faces,desiredSum, sumSoFar+i, choosen);
          choosen.remove(choosen.size() - 1);
        }

      }


    }


  }


  public static void stringPermutations(String targetString) {

    permuteHelper(targetString,"");
  }


  private static void permuteHelper(String permuteString, String choosen) {

    System.out.println(permuteString+ "    " + choosen);

    if(permuteString.isEmpty()) {
      System.out.println(choosen);
    }

    else {

      for(int i=0 ;i<permuteString.length() ; i++) {
        permuteHelper(new StringBuilder(permuteString).deleteCharAt(i).toString(),choosen+permuteString.charAt(i));
      }


    }

  }



  public static void permuteHelp(String permuteString, String choosen) {

    System.out.println(permuteString+ "   "  +choosen);

    if(permuteString.isEmpty()) {
      System.out.println("FInally choosen" +choosen);
    }

    for(int i=0; i<permuteString.length() ; i++) {

      permuteHelp(new StringBuffer(permuteString).deleteCharAt(i).toString(),
          choosen+permuteString.charAt(i));
    }


  }

  public static void stringPermuteTest(String permuteString) {

    permuteHelp(permuteString,"");

  }





  public static void sumLists(){

    List<String> names = Arrays.asList("Jane","Bob","Mat","Sara");
    subListHelper(names,new ArrayList<>());

  }


  private static void subListHelper(List<String> list , List<String> choosen) {

    if(list.isEmpty()){
      System.out.println();
      choosen.forEach(System.out::print);
    }
    else {

      for(int i=0 ; i<list.size() ; i++){
         choosen.add(list.get(i));
        list.remove(i);
        subListHelper(list,choosen);
        list.add(i,list.get(i));

      }


    }




  }

}
