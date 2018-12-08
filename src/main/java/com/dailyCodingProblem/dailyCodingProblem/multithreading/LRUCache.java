package com.dailyCodingProblem.dailyCodingProblem.multithreading;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mshaik on 11/28/18.
 */
public class LRUCache {

Map<Integer,CacheNode> cacheMap;
static int LRU_CACHE_SIZE = 0;

CacheNode start ,end;


LRUCache(int capacity){
  LRU_CACHE_SIZE = capacity;
  cacheMap = new HashMap<>();
}


public int get(int key) {

   if(cacheMap.get(key)!=null) {

     CacheNode node = cacheMap.get(key);
     removeFromEnd(node);
     addAtTop(node);
     return node.value;

   }
   else {
     return -1;
   }




}

public void put(int value , int key){

  if(cacheMap.get(key)!=null){

    CacheNode node = cacheMap.get(key);
    node.value = value;
    removeFromEnd(node);
    addAtTop(node);

  } else {

    CacheNode cacheNode = new CacheNode(key,value);
    cacheNode.next = null;
    cacheNode.prev = null;

    if(cacheMap.size()>=LRU_CACHE_SIZE){
      cacheMap.remove(end.key);
      removeFromEnd(end);
      addAtTop(cacheNode);
    }else{

      addAtTop(cacheNode);

    }

    cacheMap.put(key,cacheNode);

  }




}



private void addAtTop(CacheNode node){

  node.next = start;
  node.prev = null;

  if(start!=null){
    start.prev = node;
  }

  node = start;

  if(end ==null){
    end = start;
  }


}


private void removeFromEnd(CacheNode node){

  if(node.prev!=null){
    node.prev.next = node.next;
  } else {
    start = node.next;
  }

  if(node.next!=null){
    node.next.prev = node.prev;
  } else {
    end = node.prev;
  }


}


}




class CacheNode{

  int key;
  int value;
  CacheNode prev;
  CacheNode next;

  CacheNode(int key,int value){
    this.key = key;
    this.value = value;
  }



}