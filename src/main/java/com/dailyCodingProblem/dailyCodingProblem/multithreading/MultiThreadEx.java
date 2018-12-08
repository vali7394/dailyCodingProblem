package com.dailyCodingProblem.dailyCodingProblem.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.LongStream;

/**
 * Created by mshaik on 11/26/18.
 */
public class MultiThreadEx {






  private static Long sumOfFirstNo() throws Exception{
    Thread.sleep(1000);
    return LongStream.range(0,100000).reduce(0,Long::sum);

  }


  private static Long sumOFew(){
    return LongStream.range(0,100).reduce(0,Long::sum);

  }


  public static void main(String args[]) throws Exception{


    ExecutorService service = Executors.newFixedThreadPool(5);

    Future<Long> computeSum = service.submit(new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        return sumOfFirstNo();
      }
    });

    Long result = computeSum.get();
    System.out.println("Future get"+ result);
    System.out.println("Before future get"+sumOFew());
    service.shutdown();

  }

}
