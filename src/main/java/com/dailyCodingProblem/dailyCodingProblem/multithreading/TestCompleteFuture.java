package com.dailyCodingProblem.dailyCodingProblem.multithreading;

import com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems.StringProblems;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by mshaik on 11/26/18.
 */
public class TestCompleteFuture {

  public static void main(String args[]) {


    List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
        new Shop("LetsSaveBig"),
        new Shop("MyFavoriteShop"),
        new Shop("BuyItAll"));

  Shop shop = new Shop();
  long start = System.nanoTime();

  Future<Double> price= shop.getPriceAsync("My Fav product");

  long invocation = (System.nanoTime()-start)/1_000_000;
System.out.println("Invokcation returned after" +invocation);
    System.out.println(StringProblems.isPalinDrum("abcadc"));

    try{
      double priceNew = price.get();
      System.out.println("Price" + priceNew);
    }
    catch (Exception e){
      System.out.println("error");
    }

    long retrivalTIme = (System.nanoTime()-start)/1_000_000;

    System.out.println("rerival returned after" +retrivalTIme);

  }






}
