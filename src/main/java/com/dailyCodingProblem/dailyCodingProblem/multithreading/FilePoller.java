package com.dailyCodingProblem.dailyCodingProblem.multithreading;

/**
 * Created by mshaik on 10/18/18.
 */
public class FilePoller implements Runnable {


  public void run() {

  FileChecker fileChecker = FileChecker.getInstance();

  if(fileChecker.poller() != null) {
    System.out.println(fileChecker.poller().getAbsolutePath());
  }

  }
}
