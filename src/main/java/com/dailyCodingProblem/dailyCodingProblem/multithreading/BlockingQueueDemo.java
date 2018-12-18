package com.dailyCodingProblem.dailyCodingProblem.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by mshaik on 12/12/18.
 */
public class BlockingQueueDemo {

  public static void main(String args[]) throws Exception{

    /*BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();

       Consumer consumer = new Consumer(queue);
   Thread t1 = new Thread(new Producer(queue));
   Thread t2 = new Thread(consumer);

   t1.start();
   t2.start();

   t2.join();S
    System.out.println("Finished");*/

    Person p = new Person();
    Person p1 = new Person();

    List<Person> persons = new ArrayList<>();

    persons.add(p1);
    persons.add(p);

    List<String> names = Arrays.asList("Shaik","Bhavni","Vali","Malarapu");

    List<Integer> nos = Arrays.asList(1,5,13,23,11,1);

    names.stream().sorted().forEach(System.out::println);

    nos.stream().sorted().forEach(System.out::println);

   // persons.forEach(person -> System.out.println(person.getName()));

    Collections.sort(persons, Comparator.comparing(Person::getPersonId));

    persons.forEach(person -> System.out.println(person.getPersonId()));

   // t1.start();

  }

}
