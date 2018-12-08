package com.dailyCodingProblem.dailyCodingProblem.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by mshaik on 10/18/18.
 */
public class SchedulejobTest {



  public static void main(String args[]) {

    long initialDelay = 0;
    long rate = 60;

    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
    executorService.scheduleAtFixedRate(new FilePoller(),initialDelay,rate, TimeUnit.SECONDS);

  }


}
