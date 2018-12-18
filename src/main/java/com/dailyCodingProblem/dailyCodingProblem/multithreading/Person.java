package com.dailyCodingProblem.dailyCodingProblem.multithreading;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Created by mshaik on 12/12/18.
 */
public class Person  {


  Person(){

  }

  int personId ;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  String name;


  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  /*@Override
  public int compareTo(Object p) {
    Person pp = (Person) p;
    return this.personId - pp.getPersonId();
  }*/

}
