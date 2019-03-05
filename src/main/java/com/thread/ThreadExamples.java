package com.thread;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mshaik on 2/14/19.
 */
public class ThreadExamples {

  public static void main(String[] args) throws InterruptedException,ExecutionException{

    /*Queue<Integer> sharedQueue = new LinkedList<>();


    WaitExample example = new WaitExample(sharedQueue,4);
    NotifyExample notify = new NotifyExample(sharedQueue);

    new Thread(example).start();
    new Thread(notify).start();*/

    AtomicInteger atomic = new AtomicInteger(1);

      Thread t1 = new Thread(() -> {
        System.out.println(atomic.getAndIncrement());
      });

      Thread t2 = new Thread(() -> {
        try {
          while (atomic.get()<13)
          t1.join();
        }catch (InterruptedException ex){

        }
        System.out.println(atomic.getAndIncrement());
      });

      Thread t3 = new Thread(() -> {
        try {
          while (atomic.get()<13)
          t2.join();
        }catch (InterruptedException ex){

        }
        System.out.println(atomic.getAndIncrement());
      });

      Thread t4 = new Thread(() -> {
        try {
          while (atomic.get()<13)
          t3.join();
        }catch (InterruptedException ex){

        }
        System.out.println(atomic.getAndIncrement());
      });


    t1.start();
    t2.start();
    t3.start();
    t4.start();



  }


}
