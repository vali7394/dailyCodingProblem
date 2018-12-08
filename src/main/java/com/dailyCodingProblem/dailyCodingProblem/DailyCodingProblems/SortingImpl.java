package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

import java.util.Arrays;

/**
 * Created by mshaik on 10/13/18.
 */
public class SortingImpl {


  public static void selectionSort(int[] array) {


    for (int i = 0; i < array.length; i++) {

      int min = i;

      for (int j = i + 1; j < array.length; j++) {
        if (array[min] > array[j]) {
          min = j;
        }

      }

      if (i!=min && array[min] != array[i]) {
      swap(array,min,i);
      }


    }

    Arrays.stream(array).forEach(System.out::println);
  }

    private static void swap(int[] array , int i , int j) {

    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;

    }

    //// Watch Video once - My code school once

    public static void bubbleSort(int[] array) {

    if(array == null || array.length==1) {
      System.out.println("Sorted");
    }

    for(int i=1 ; i<array.length ; i++ ) {

      for(int j= 0 ; j<array.length-i-1 ; j++) {

        if(array[j] > array[j+1]) {
          swap(array,j,j+1);
        }

      }

    }

      Arrays.stream(array).forEach(System.out::println);

    }





  }



