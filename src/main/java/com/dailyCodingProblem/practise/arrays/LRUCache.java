package com.dailyCodingProblem.practise.arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by mshaik on 2/4/19.
 */
class LRUCache {

  Map<Integer,DoubleLinkedList> cache ;

  DoubleLinkedList head;
  DoubleLinkedList tail;

  int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    cache = new HashMap<>(capacity);

  }

  public int get(int key) {

    if(cache.containsKey(key)) {
      DoubleLinkedList node = cache.get(key);
      removeNode(node);
      insertNodeAtTop(node);
      return node.value;
    }

    return -1;


  }

  public void put(int key, int value) {

    if(cache.containsKey(key)){
      DoubleLinkedList node = cache.get(key);
      removeNode(node);
    }
    else {

      if(cache.size()>=capacity){
        cache.remove(tail.key);
        removeNode(tail);
      }


    }

    DoubleLinkedList list = new DoubleLinkedList(value,key);
    cache.put(key,list);
    insertNodeAtTop(list);

  }


  public void removeNode(DoubleLinkedList node){

    if(node.prev!=null) {
      node.prev.next = node.next;
    } else {
      head = node.next;
    }

    if(node.next!=null){
      node.next.prev = node.next;
    }else {
      tail = node.prev;
    }


  }


  public void insertNodeAtTop(DoubleLinkedList node){

    node.next = head;
    node.prev = null;

    if(head!=null) {
      head.prev = node;
    }

    head = node;

    if(tail==null){
      tail = head;
    }




  }

  class DoubleLinkedList {

    int value;
    int key;

    DoubleLinkedList prev;
    DoubleLinkedList next;

    DoubleLinkedList(int value , int key) {
      this.value = value;
      this.key = key;
    }


  }


  //Math.min(10,20,20);

}