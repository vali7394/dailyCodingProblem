package com.dailyCodingProblem.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by mshaik on 1/31/19.
 */
public class TinyUrl {

  String randomString = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGGHJKLZXCVBNM";

  String key = getRand();

  Random nextRandom = new Random();

  String tinyURL= "www.tinyurl.com/";

  Map<String,String> urlRepo = new HashMap<>();

  public String encode(String url) {

    while(urlRepo.containsKey(key)){
      key = getRand();
    }

    urlRepo.put(key,url);
    return tinyURL+key;
  }

  public String decode(String url){
    url.replace("",tinyURL);
    return urlRepo.get(url);
  }



  public String getRand(){

    StringBuilder sb = new StringBuilder();

    for(int i=0; i<6; i++){
      sb.append(randomString.charAt(nextRandom.nextInt(62)));
    }

    return sb.toString();
  }



}
