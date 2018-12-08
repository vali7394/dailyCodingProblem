package com.dailyCodingProblem.dailyCodingProblem.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by mshaik on 11/26/18.
 */
public class FactorialCalculator implements Callable<Integer>
{

  private Integer number;

  public FactorialCalculator(Integer number) {
    this.number = number;
  }

  @Override
  public Integer call() throws Exception {
    int result = 1;
    if ((number == 0) || (number == 1)) {
      result = 1;
    } else {
      for (int i = 2; i <= number; i++) {
        result *= i;
        TimeUnit.MILLISECONDS.sleep(20);
      }
    }
    System.out.println("Result for number - " + number + " -> " + result);
    return result;
  }
}