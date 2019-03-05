package com.csdojo;

/**
 * Created by mshaik on 2/12/19.
 */
public class CodingProblems {


  public static void main(String[] args){
    CodingProblems problems = new CodingProblems();
    problems.noOfWaysToDecode("12345");
  }

  public void noOfWaysToDecode(String data){
    System.out.print(noOfWaysDecodeHelper(data,data.length()));
  }


  public int noOfWaysDecodeHelper(String data , int length){

    if(length==0 || length==1) return 1;

    if(data.charAt(0)=='0') return 0;

    int result = noOfWaysDecodeHelper(data,length-1);

    if(length>=2 && Integer.parseInt(data.substring(data.length()-length,length))<=26) {
      result+=noOfWaysDecodeHelper(data,length-2);
    }

    return result;
  }



}
