package com.thread;

import java.util.Queue;
import java.util.Random;

/**
 * Created by mshaik on 2/18/19.
 */
public class WaitExample implements Runnable {

  Queue<Integer> sharedQueue;
  int maxSize ;

  WaitExample(Queue<Integer> sharedQueue , int size){
    this.sharedQueue = sharedQueue;
    maxSize = size;
  }


  @Override
  public void run() {

    while (true){

      synchronized (sharedQueue){

        if(sharedQueue.size()==maxSize){
          try {
            sharedQueue.wait();
          }catch (InterruptedException ex){

          }

          Random random = new Random();
          System.out.println("producing");
          sharedQueue.add(random.nextInt(100));
          sharedQueue.notify();


        }







      }









    }





  }
}

