package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by mshaik on 10/9/18.
 */
public class StringProblems {


  public static boolean isPalinDrum(String s) {

    if(s.length() < 2) {
      return true;
    }
    else {

      if(s.charAt(0)==s.charAt(s.length()-1)) {
        return isPalinDrum(s.substring(1,s.length()-1));
      }

      return false;
    }


  }

  public static void printBinary(int n) {

    if(n < 2) {
      System.out.print(n);
    }

    else {
      int bit = n%2;
      printBinary(n/2);
     printBinary(n%2);

    }


  }


  public static void readFile(String fileName,String indent) {

    File file = new File(fileName);
    System.out.println(indent);
    System.out.print(file.getName());
    if(file.isFile()) {

    }
    else {

      Arrays.stream(file.list()).forEach(subfileName->readFile(fileName+"/"+subfileName,indent+ "  "));
    }

  }

  static String funnyString(String s) {
    int length = s.length();

    int[] diff = new int[length-1];
    for(int i=1; i<=length-1 ; i++){
      diff[i-1] = Math.abs(s.charAt(i-1)-s.charAt(i));
    }

    int start = 0;
    int end = diff.length-1;

    while(start <= end) {
      if(diff[start]!=diff[end]) {
        return "Not Funny";
      }
      start++;
      end--;

    }

    return "Funny";


  }

  public static boolean isPerumPalindrum(String s){

    Map<Character,Integer> charCount = new HashMap<>(s.length());

    for(int i=0 ; i<s.length(); i++) {

      Character letter = s.charAt(i);
      if(charCount.get(letter)!=null) {

        charCount.put(letter,charCount.get(letter)+1);
      }
        else {

        charCount.put(letter,1);

      }


    }


    int oddCount = 0;

    for(Map.Entry<Character,Integer> entry: charCount.entrySet()) {

      if((entry.getValue()&1)==1) {
        oddCount++;
      }

      if(oddCount > 1) {
        return false;
      }

    }

    return true;

  }



  public static boolean isRotataionOfString(String first , String second) {

    if(first.length()==second.length()&&first.concat(second).indexOf(second)!=-1) return true;
    else return false;


  }

  public static void findLongestPlaindrumSubString(String givenString) {

    int start = 0;
    int length = givenString.length();

    int low , high;

    int maxLength = 1;


    for(int i=1; i<givenString.length();i++) {

      low = i-1;
      high = i;

      while(low>=0 && high<length && givenString.charAt(low)==givenString.charAt(high)) {

        if(high-low+1 > maxLength) {
          start = low;
          maxLength = high-low+1;
        }
        low--;
        high++;

      }

    low= i-1;
    high = i+1;

    while (low>=0 &&  high<length && givenString.charAt(low)==givenString.charAt(high)) {

      if(high-low+1 > maxLength) {
        start = low;
        maxLength = high-low+1;
      }
      low--;
      high++;



    }



  }

    System.out.println(givenString.substring(start,start+maxLength));
  }



  static void superReducedString(String s) {


    StringBuffer reducedString = new StringBuffer();

    for(int i=0; i<s.length()-1;i++) {

      if(s.charAt(i)==s.charAt(i+1)){
        continue;
      } else {
        reducedString.append(s.charAt(i));
      }


    }

    System.out.println(reducedString.toString());


  }



  public static void learnParallelStream(int n){

    System.out.println(Stream.iterate(1L,i->i+1)
          .limit(n)
          .parallel()
          .reduce(0L,Long::sum));

  }


  public static int nonRepCharcter(String s) {

    Map<Character,Integer> characterIntegerMap = new HashMap<>(s.length());

    for(Character ch : s.toCharArray()) {
      if(characterIntegerMap.get(ch)!=null) characterIntegerMap.put(ch,characterIntegerMap.get(ch)+1);
      else characterIntegerMap.put(ch,1);
    }

    for(int i=0; i<s.length() ; i++) {
      if(characterIntegerMap.get(s.charAt(i))==1){
        return i;
      }
    }


    return -1;
  }


  public static void longestCommonSubSeq(){

    String first = "AGGTAB";
    String second = "GXTXAYB";

    int max = 0;
    int m = first.length();
    int n = second.length();

    int[][] temp = new int[m+1][n+1];


    for(int i=1;i<temp.length;i++) {

      for(int j=1; j<temp[0].length;j++) {

        if(first.charAt(i-1)==second.charAt(j-1)) {
          temp[i][j]= temp[i-1][j-1]+1;
        }
        else {
          temp[i][j] = Math.max(temp[i-1][j],temp[i][j-1]);
        }


      }


    }


    System.out.println(temp[m][n]);

    // Following code is used to print LCS

    int index = temp[m][n];
    int loop = index;

    int i = m;
    int j = n;

    char[] finalString = new char[index];

    while(i>0 && j>0) {

      if(first.charAt(i-1)==second.charAt(j-1)) {

        finalString[index-1] = first.charAt(i-1);
        i--;
        j--;
        index--;

      } else if (temp[i-1][j] > temp[i][j-1]) {
        i--;
      } else {
        j--;
      }


    }

    String s ="";

  for(char c : finalString) {
    s= s+c;
  }

    System.out.println(s);
    System.out.println(longestCommonSubSeqRec(first,second));


  }


  public static int longestCommonSubSeqRec(String first ,String second) {

    if(first.length()==0 || second.length()==0) return 0;

    if(first.charAt(first.length()-1)==second.charAt(second.length()-1)) {
      return 1 + longestCommonSubSeqRec(first.substring(0,first.length()-1),second.substring(0,second.length()-1));
    }else {

      return Math.max(longestCommonSubSeqRec(first,second.substring(0,second.length()-1)),longestCommonSubSeqRec
          (first.substring(0,first.length()-1),second));
    }



  }



  public static void longestCommonSubString(){

  String first = "GeeksforGeeks";
  String second = "GeeksQuiz";


  int[][] temp = new int[first.length()+1][second.length()+1];

  int max = 0;

    int row = 0;
    int col = 0;

  for(int i=1 ; i<temp.length;i++) {

    for(int j=1; j<temp[0].length;j++) {

      if(i==0 || j==0) {
        temp[i][j]=0;
      }

     else if(first.charAt(i-1)==second.charAt(j-1)) {
        temp[i][j] = 1 + temp[i-1][j-1];

        if(max < temp[i][j] ) {
          max = temp[i][j];
          row = i;
          col = j;
        }

      }
       else {
        temp[i][j] = 0;
      }



    }

  }

  System.out.println("max substring is" + max);

 String subString = "";



 while(temp[row][col]!=0) {
   subString = first.charAt(row-1)+subString;
   row--;
   col--;
 }

 System.out.println(subString);

    System.out.println("max substring Rec is" + longestCommonRec(first,second));
  }


  public static int longestCommonRec(String first,String second) {

    if(first.length()==0 || second.length()==0) return 0;

    if(first.charAt(0)==second.charAt(0)) return 1+longestCommonRec(first.substring(1),second.substring(1));
    else return Math.max(longestCommonRec(first,second.substring(1)),longestCommonRec(first.substring(1),second));

  }



}
