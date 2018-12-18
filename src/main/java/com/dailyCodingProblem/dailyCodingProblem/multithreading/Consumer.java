package com.dailyCodingProblem.dailyCodingProblem.multithreading;

import java.util.concurrent.BlockingQueue;

/**
 * Created by mshaik on 12/12/18.
 */
public class Consumer implements Runnable {

  BlockingQueue<Integer> queue;

  volatile boolean isExit = false;

  Consumer(BlockingQueue queue) {
    this.queue = queue;
  }

  public void isExit(boolean isExit) {
    this.isExit = isExit;
  }

  public void run() {

      while(true) {
        try {
          int value = queue.take();
          if( value > 15) break;
          System.out.println("Consumer " + value);
        } catch (Exception ee) {

        }

      }

  }
}
