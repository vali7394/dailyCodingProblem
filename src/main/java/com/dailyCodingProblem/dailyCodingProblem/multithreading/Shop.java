package com.dailyCodingProblem.dailyCodingProblem.multithreading;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by mshaik on 11/26/18.
 */
public class Shop {


  public Shop(){

  }


  public Shop(String shopName){

  }

  public double getPrice(String product) {
    return calculatePrice(product);
  }
  private double calculatePrice(String product) {
    delay();
    return Math.random() * product.charAt(0) + product.charAt(1);
  }


  public static void delay() {
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }


  public Future<Double> getPriceAsync(String product){
    Future<Double> future = CompletableFuture.supplyAsync(()->getPrice(product));
    /*System.out.println("In price");
    new Thread(()->{
      try {
        double price = getPrice(product);
        future.complete(price);
      }catch (Exception e){
        future.completeExceptionally(e);
      }
    }).start();*/
    return future;
  }

}
