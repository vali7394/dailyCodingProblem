package com.dailyCodingProblem.dailyCodingProblem.multithreading;

import org.springframework.core.io.FileSystemResource;

import java.io.File;

/**
 * Created by mshaik on 10/18/18.
 */
public class FileChecker {

  static FileChecker fileChecker;
  private FileChecker() {

  }

  public static FileChecker getInstance() {
    if(fileChecker == null) {
       fileChecker =new FileChecker();
      return fileChecker;
    }
    else {
      return fileChecker;
    }
  }

  public File poller() {
    FileSystemResource fs = new FileSystemResource("/Users/mshaik/Downloads/inventoryData/*.csv");
    if(fs.isFile()) {
      return fs.getFile();
    }

    return null;
  }


}
