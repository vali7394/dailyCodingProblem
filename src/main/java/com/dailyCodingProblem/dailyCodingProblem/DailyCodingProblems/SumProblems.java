package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by mshaik on 10/9/18.
 */
public class SumProblems {


  public static int[] findNoAddUpToSum(int[] n, int k) {

    Map<Integer, Integer> map = new HashMap<>(n.length);

    for (int value : n) {

      if (map.get(value) != null) {

        int[] nos = new int[2];
        nos[0] = value;
        nos[1] = map.get(value);
        return nos;

      }

      map.put(k - value, value);

    }

    return null;

  }

  public static long[] productArray(int[] elements) {

    long productsum = 1;

    long[] productArray = new long[elements.length];

    for (int n : elements) {
      productsum *= n;
    }

    for (int i = 0; i < elements.length; i++) {
      productArray[i] = productsum / elements[i];

    }

    return productArray;

  }

  static int[] productArray(int arr[], int n) {

    int[] left = new int[n];
    int[] right = new int[n];
    int[] product = new int[n];

    left[0] = 1;
    right[n - 1] = 1;

    for (int i = 1; i < n; i++) {
      left[i] = left[i - 1] * arr[i - 1];
    }

    for (int j = n - 2; j >= 0; j--) {
      right[j] = right[j + 1] * arr[j + 1];
    }


    for (int i = 0; i < n; i++) {
      product[i] = left[i] * right[i];
    }

    return product;
  }


  static void products(int[] a) {

    int[] p = new int[a.length];

    for (int i = 0; i < a.length; i++) {
      p[i] = 1;
    }

    int temp = 1;

    for (int i = 0; i < a.length; i++) {
      p[i] = temp;
      temp = temp * a[i];

    }

    temp = 1;

    for (int j = a.length - 1; j >= 0; j--) {

      p[j] *= temp;
      temp *= a[j];

    }


  }


  static int missingNumber(int[] a) {

    int max = 0;
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] < 0) {
        continue;
      } else {

        if (max < a[i]) {
          max = a[i];
          sum += a[i];
        }


      }
    }
    return 0;

  }

  static List<Integer> findRepeatingNos(int[] a) {
    Map<Integer, Integer> map = new HashMap<>(a.length);
    List<Integer> repetating = new ArrayList<>();
    for (int number : a)
      if (map.get(number) != null) {
        map.put(number, map.get(number) + 1);
      } else {
        map.put(number, 1);
      }

    for (Integer entry : map.keySet()) {
      if (map.get(entry) > 1) {
        repetating.add(entry);
      }

    }
    return repetating;
  }


  static List<Integer> findDuplicates(int[] numbers) {

    Set<Integer> duplicates = new HashSet<>();

    for (int i = 0; i < numbers.length; i++) {

      int index = Math.abs(numbers[i]) - 1;

      if (numbers[index] < 0) {
        duplicates.add(Math.abs(numbers[i]));
      } else {
        numbers[index] = -numbers[index];
      }

    }

    for (int i = 0; i < numbers.length; i++) {

      numbers[i] = Math.abs(numbers[i]);

    }

    return new ArrayList<>(duplicates);

  }


  static int findDuplicates(int[] a, int n) {

    int oneOccurrence = 0;

    int[] countBitArray = new int[32];

    for (int i = 0; i < a.length; i++) {

      for (int k = 0; k < 32; k++) {

        int kthBit = 1 << k;

        if ((a[i] & kthBit) == kthBit) {
          countBitArray[k]++;
        }

      }

    }

    for (int i = 0; i < 32; i++) {

      countBitArray[i] = countBitArray[i] % n;

      if (countBitArray[i] == 1) {

        oneOccurrence = oneOccurrence | (1 << i);

      }


    }


    return oneOccurrence;
  }


  public static void sumSubSet(int[] array, int k) {

    int sum = 0;
    int start = 0;
    int end = 0;
    for (int i = 0; i < array.length; i++) {

      sum += array[i];

      if (sum == k) {
        end = i;
      }

      while (sum > k) {
        sum = sum - array[i];
      }


    }


  }


  public static float power(int x, int y) {

    float  temp = 0;
    if (y == 0) {
      return 1;
    } else {
      temp = power(x, y / 2);
      if (y % 2 == 0) {
        return temp * power(x, y / 2);
      } else {
        if(y >0) {
          return x * temp * temp;
        } else {
          return (temp*temp)/x;
        }

      }
    }


  }


  public static long powerIterative(int x , int y) {

    if(y==0)return 1;
    if(y==1) return x;
    int sum = 1;
    for(int i=1 ; i<=y ; i++) {
      sum*= x;
    }

    return sum;
  }

}