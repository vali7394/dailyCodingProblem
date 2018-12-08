package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

/**
 * Created by mshaik on 10/11/18.
 */
public class MatrixProblems {


  public static void searchSortedMartix(int[][] matrix,int m) {

    int row = matrix.length-1;
    int col = matrix[0].length-1;

    int i = 0 , j=col;

    while(i<=row && j>=0) {

      if(matrix[i][j] == m) {
        System.out.println("Item found at " + i + "  " +j);
        return;
      }

      else if( matrix[i][j] < m) {

        i++;
      }

      else {
            j--;

      }


    }

    System.out.println("Item not found at ");

  }
}
