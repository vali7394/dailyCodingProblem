package com.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by mshaik on 2/18/19.
 */
public class CyclicBarrierExample {


  public static void main(String[] args) {


    CyclicBarrier barrier = new CyclicBarrier(4, () -> {
      System.out.print("All parties are arrived to checkpoint");
    });

    Thread biker1 = new Thread(new Biker(barrier));
    Thread biker2 = new Thread(new Biker(barrier));
    Thread biker3 = new Thread(new Biker(barrier));
    Thread biker4 = new Thread(new Biker(barrier));
    biker1.start();
    biker2.start();
    biker3.start();
    biker4.start();
  }

  static class Biker implements Runnable {

    CyclicBarrier barrier;

    Biker(CyclicBarrier cyclicBarrier) {
      this.barrier = cyclicBarrier;
    }

    @Override
    public void run() {

      try {
        System.out.print("Left check point");
        barrier.await();
        System.out.print("Reached first check point");
        barrier.await();
        System.out.print("Reached second check point");
        barrier.await();
        System.out.print("Reached second check point");
        barrier.await();
        System.out.print("Reached final check point");
      } catch (InterruptedException | BrokenBarrierException exception) {

      }


    }

  }
}
