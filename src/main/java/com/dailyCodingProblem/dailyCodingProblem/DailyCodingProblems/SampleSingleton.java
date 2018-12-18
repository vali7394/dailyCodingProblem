package com.dailyCodingProblem.dailyCodingProblem.DailyCodingProblems;

/**
 * Created by mshaik on 12/16/18.
 */
public class SampleSingleton {

  int num ;

  private volatile static SampleSingleton sampleSingletonOne;

  private volatile static SampleSingleton sampleSingletonTwo;

  private SampleSingleton (int num) {
    this.num = num;
  }

  static boolean  instanceOne = true;

  /*static {
    sampleSingletonOne = new SampleSingleton(1);
    sampleSingletonTwo = new SampleSingleton(2);

  }*/

  public static SampleSingleton getInstance() {

    doubleCheckLocaking(true,1);
    doubleCheckLocaking(false,2);

    if (sampleSingletonOne != null & instanceOne) {
      instanceOne = false;
      return sampleSingletonOne;
    } else {
      instanceOne = true;
      return sampleSingletonTwo;
    }

  }

  private static void doubleCheckLocaking(boolean instanceOne,int num){
    if(instanceOne && sampleSingletonOne==null) {

      synchronized (SampleSingleton.class) {

        if(sampleSingletonOne==null) {
            sampleSingletonOne = new SampleSingleton(num);

        }

      }

    } else {

      if(sampleSingletonTwo==null) {

        synchronized (SampleSingleton.class) {

          if(sampleSingletonTwo==null) {
            sampleSingletonTwo = new SampleSingleton(num);
          }

        }


      }


    }
  }

}
