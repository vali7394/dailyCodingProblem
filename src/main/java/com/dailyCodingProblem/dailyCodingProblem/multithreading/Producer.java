package com.dailyCodingProblem.dailyCodingProblem.multithreading;

import java.util.concurrent.BlockingQueue;

/**
 * Created by mshaik on 12/12/18.
 */
public class Producer implements Runnable {

  BlockingQueue<Integer> queue;

  Producer(BlockingQueue queue) {
    this.queue = queue;
  }




  public void run() {

    for(int i=0 ; i<17; i++) {
      try {
        System.out.println("Producer");
        queue.put(i);
      } catch (Exception ee) {

      }

    }

  }
}
