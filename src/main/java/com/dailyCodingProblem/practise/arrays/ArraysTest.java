package com.dailyCodingProblem.practise.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mshaik on 2/3/19.
 */
public class ArraysTest {


  public static void main(String[] args) {
    ArraysTest test = new ArraysTest();
    // Arrays.stream(test.twoNumberSum(new int[]{3,5,-4,8,11,1,-1,6},10)).forEach(System.out::println);
    /*for(Integer[] list : test.findTriplets(new int[]{12,3,1,2,-6,5,-8,6},0)){
      System.out.println();
      System.out.print(list[0] + " ");
      System.out.print(list[1] + " ");
      System.out.print(list[2]);
    }*/

    // System.out.print(test.NoOFWaysToMakeChange(new int[]{1,5,10,25},10));
    // System.out.print(test.findMedianOfSortedArrays(new int[]{1, 3, 8, 9, 15},new int[]{7, 11, 19, 21, 18, 25}));

   /* LRUCache cache = new LRUCache(3);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.put(3, 3);
    cache.put(4, 4);
    System.out.println(cache.get(4));
    System.out.println(cache.get(3));
    System.out.println(cache.get(2));
    System.out.println(cache.get(1));
    cache.put(5, 5);
    System.out.println(cache.get(1));
    System.out.println(cache.get(2));
    System.out.println(cache.get(3));
    System.out.println(cache.get(4));
    System.out.println(cache.get(5));*/


  // System.out.print(test.cherryPickup(new int[][]{{0,1,-1},{1,0,-1},{1,1,1}}));

    test.printDiagonals(new String[][]{{"a","b","c"},{"d","e","f"},{"g","h","i"}});

    // cache.put(6,60);


  }


  public int[] twoNumberSum(int[] array, int target) {

    if (array == null || array.length == 0) return new int[]{};

    Map<Integer, Integer> valueMap = new HashMap<>();

    for (int i = 0; i < array.length; i++) {

      if (valueMap.containsKey(array[i])) {
        int pair = valueMap.get(array[i]);
        return new int[]{Math.min(array[i], array[pair]), Math.max(array[i], array[pair])};
      } else {
        valueMap.put(target - array[i], i);
      }


    }

    return new int[]{};

  }


  public List<Integer[]> findTriplets(int[] array, int target) {

    int[] empty = new int[]{};

    List<Integer[]> finalList = new ArrayList<>();

    if (array == null || array.length == 0) return finalList;

    Arrays.sort(array);

    for (int i = 0; i < array.length - 2; i++) {

      int currentSum = array[i];

      int startInde = i + 1;
      int endIndex = array.length - 1;


      while (startInde < endIndex) {

        int tragetSum = array[i] + array[startInde] + array[endIndex];

        if (tragetSum < target) {
          startInde++;
        } else if (tragetSum > target) {
          endIndex--;
        } else {
          finalList.add(new Integer[]{array[i], array[startInde], array[endIndex]});
          startInde++;
        }

      }


    }


    return finalList;

  }


  public int[] smallestDiff(int[] array1, int[] array2) {
    int[] finalResult = new int[2];
    if (array1.length == 0 || array2.length == 0) return null;

    if (array1.length == 1 && array2.length == 1) return new int[]{array1[0], array2[0]};

    Arrays.sort(array1);
    Arrays.sort(array2);

    int leftArray = 0;
    int rightArray = 0;

    int minSofar = Integer.MIN_VALUE;


    while (leftArray < array1.length && rightArray < array2.length) {

      int diffSofar = Math.abs(array1[leftArray] - array2[rightArray]);

      if (diffSofar == 0) {
        return new int[]{array1[leftArray], array2[rightArray]};
      } else if (minSofar > diffSofar) {
        minSofar = diffSofar;
        finalResult = new int[]{array1[leftArray], array2[rightArray]};
      }

      if (array1[leftArray] < array2[rightArray]) {
        leftArray++;
      } else {
        rightArray++;
      }

    }

    return finalResult;

  }


  public int[] subArraySort(int[] array) {

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < array.length; i++) {

      if (isOutOfOrder(i, array)) {
        min = Math.min(min, array[i]);
        max = Math.max(max, array[i]);
      }

    }

    if (min == Integer.MAX_VALUE) return new int[]{-1, -1};

    int left = 0;
    int right = array.length - 1;
    int minInd = -1;
    int maxInd = -1;

    if (min != Integer.MAX_VALUE) {

      while (array[left] <= min) {
        left++;
      }

      while (array[right] >= max) {
        right--;
      }

    }
    return new int[]{left, right};

  }


  public boolean isOutOfOrder(int i, int[] array) {

    if (i == 0) {
      return array[i] <= array[i + 1];
    } else if (i == array.length - 1) {
      return array[i] >= array[i - 1];
    }

    return array[i] >= array[i - 1] && array[i] <= array[i + 1];

  }


  public int[] largestRange(int[] array) {


    Map<Integer, Boolean> valueMap = new HashMap<>();

    int[] range = new int[2];

    for (int num : array) {
      valueMap.put(num, false);
    }

    int longestRange = Integer.MIN_VALUE;


    for (int num : array) {

      if (valueMap.containsKey(num)) {
        continue;
      }

      valueMap.put(num, true);

      int left = num - 1;
      int right = num + 1;
      int currentLength = 1;

      while (valueMap.containsKey(left)) {
        valueMap.put(left, true);
        currentLength++;
        left--;
      }

      while (valueMap.containsKey(right)) {
        valueMap.put(right, true);
        currentLength++;
        right++;
      }

      if (longestRange < currentLength) {
        longestRange = currentLength;
        range = new int[]{left + 1, right - 1};
      }


    }


    return range;

  }


  public int NoOFWaysToMakeChange(int[] denoms, int target) {

    int[] ways = new int[target + 1];
    ways[0] = 1;

    for (int denom : denoms) {

      for (int amount = 1; amount < ways.length; amount++) {

        if (denom <= amount) {

          ways[amount] += ways[amount - denom];

        }


      }


    }

    return ways[target];

  }

  // O(nd)  O(n)
  public int minCoinsForChange(int[] denoms, int amout) {

    int[] ways = new int[amout + 1];

    Arrays.fill(ways, Integer.MAX_VALUE);

    ways[0] = 0;
    int toCompare = 0;

    for (int denom : denoms) {
      for (int i = 1; i < ways.length; i++) {


        if (denom <= i) {
          if (ways[i - denom] == Integer.MAX_VALUE) {
            toCompare = ways[i - denom];
          } else {
            toCompare = ways[i - denom] + 1;
          }

          ways[i] = Math.min(ways[i], toCompare);
        }

      }


    }

    return ways[amout];


  }


  public double findMedianOfSortedArrays(int[] one, int[] two) {

    if (one.length > two.length) {
      return findMedianOfSortedArrays(two, one);
    }

    int x = one.length;
    int y = two.length;

    int start = 0;
    int end = x;

    while (start < end) {

      int partX = (start + end) / 2;
      int partY = ((x + y + 1) / 2) - partX;

      int leftXMaxX = partX == 0 ? Integer.MIN_VALUE : one[partX - 1];
      int RightMinX = partX == x ? Integer.MAX_VALUE : one[partX];

      int leftMaxY = partY == 0 ? Integer.MIN_VALUE : two[partY - 1];
      int RightMinY = partY == y ? Integer.MAX_VALUE : two[partY];

      if (leftXMaxX <= RightMinY && RightMinX >= leftMaxY) {

        if (x + y % 2 == 0) {
          return (Math.max(leftMaxY, leftXMaxX) + Math.min(RightMinX, RightMinY)) / 2;
        } else {
          return Math.max(leftMaxY, leftXMaxX);
        }


      } else if (leftXMaxX > RightMinY) {
        end = partX - 1;
      } else {
        start = partX + 1;
      }


    }

    return -1;

  }


  public void countRiverSizes(int[][] matrix) {

    int[][] visited = new int[matrix.length][matrix[0].length];
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < matrix.length; i++) {

      for (int j = 0; j < matrix[0].length; j++) {

        if (visited[i][j] == 1) {
          continue;
        } else {
          int count = countEachRiverSize(matrix, visited, 0, 0, 0);
          if (count > 0) list.add(count);
        }

      }

    }


  }


  public static int countEachRiverSize(int[][] matrix, int[][] visited, int start, int end, int count) {

    if (start >= matrix.length || end < 0 || start < 0 || end >= matrix[0].length) {
      return count;
    }

    if (visited[start][end] == 1) {
      return 0;
    }

    visited[start][end] = 1;
    if (matrix[start][end] == 0) {
      return 0;
    }
    count++;
    count += countEachRiverSize(matrix, visited, start - 1, end, count) +
        countEachRiverSize(matrix, visited, start + 1, end, count)
        + countEachRiverSize(matrix, visited, start, end + 1, count) +
        countEachRiverSize(matrix, visited, start, end - 1, count);

    return count;

  }


  int cherryPickup(int[][] grid) {

    int totalCherries = 0;

    int[][] visited = new int[grid.length+1][grid[0].length+1];

    for (int i = 0; i < grid.length; i++) {

      for (int j = 0; j < grid[0].length; j++) {

        if (visited[i][j] == 1) {
          continue;
        }

        totalCherries = cherryPickUpHelper(grid, visited, i, j, 0);


      }

    }
    return totalCherries;

  }


  public int cherryPickUpHelper(int[][] grid, int picked[][], int i, int j, int count) {

    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return count;

    if (picked[i][j] == 1) {
      return 0;
    }

    picked[i][j] = 1;

    if (grid[i][j] == -1) {
      return 0;
    }

    if (grid[i][j] == 1) {
      count++;
    }

    count = cherryPickUpHelper(grid, picked, i + 1, j, count) +
        cherryPickUpHelper(grid, picked, i - 1, j, count) +
        cherryPickUpHelper(grid, picked, i, j + 1, count) +
        cherryPickUpHelper(grid, picked, i, j - 1, count);
    return count;
  }


  private void printDiagonals(String[][] matrix){




    for(int k=0; k<matrix.length;k++){

      int i = k;
      int j = 0;

      while(i>=0){
        System.out.println(matrix[i][j]);
        i = i-1;
        j=j+1;
      }



    }


    for(int k=1; k<matrix[0].length;k++){

      int i = matrix.length-1;
      int j = k;

      while(j<=matrix[0].length-1){
        System.out.println(matrix[i][j]);
        i = i-1;
        j=j+1;
      }



    }




  }

}




