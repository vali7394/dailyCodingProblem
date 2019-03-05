package com.thread;

import java.util.Queue;

/**
 * Created by mshaik on 2/18/19.
 */
public class NotifyExample implements Runnable {

  Queue<Integer> sharedQueue;

  NotifyExample(Queue<Integer> message){
    this.sharedQueue = message;
  }

  @Override
  public void run() {

    while (true){

      synchronized (sharedQueue){

        if(sharedQueue.isEmpty()){
          try {
            sharedQueue.wait();
          }catch (InterruptedException ex){

          }
        }
        System.out.println("consumnig");
        System.out.print(sharedQueue.poll());
        sharedQueue.notify();



      }





    }



  }
}
