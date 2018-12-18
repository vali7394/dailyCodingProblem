package com.dailyCodingProblem.dailyCodingProblem.multithreading;

/**
 * Created by mshaik on 12/12/18.
 */
public class SingletonDemo {

  //private  volatile static SingletonDemo demo = new SingletonDemo();

  private volatile static SingletonDemo singletonDemo ;

  private SingletonDemo() {

  }


  public  static SingletonDemo getSingltonDemo(){

    if(singletonDemo == null) {
      synchronized (SingletonDemo.class) {
          if(singletonDemo==null) {
            singletonDemo = new SingletonDemo();
          }
      }
    }
    return singletonDemo;
  }

}
