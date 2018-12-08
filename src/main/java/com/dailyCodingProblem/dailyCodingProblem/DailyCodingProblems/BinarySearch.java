package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

/**
 * Created by mshaik on 10/14/18.
 */
public class BinarySearch {


  public static int findInRotatedArray(int[] array, int key) {

    int start = 0;
    int end = array.length - 1;

    // 13, 18, 25, 2, 8, 10

    while (start <= end) {

      int mid = end + (start - end) / 2;

      if (array[mid] == key) {
        return mid;
      } else if (array[mid] <= array[end]) {

        if (key > array[mid] && key <= array[end]) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }

      } else {

        if (key >= array[start] && key < array[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }

      }
    }

    return -1;


  }

}

