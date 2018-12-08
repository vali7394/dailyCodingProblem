package com.dailyCodingProblem.dailyCodingProblem.multithreading;

/**
 * Created by mshaik on 11/28/18.
 */
public class LRUCacheExample {


  public static void main(String args[]) {

    LRUCache lruCache = new LRUCache(4);
    System.out.println(lruCache.get(1));

    lruCache.put(1,1);
    lruCache.put(2,2);
    lruCache.put(3,3);
    lruCache.put(4,4);
    System.out.println(lruCache.get(4));

  }

}
