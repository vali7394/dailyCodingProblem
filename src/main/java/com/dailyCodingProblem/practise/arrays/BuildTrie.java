package com.dailyCodingProblem.practise.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mshaik on 2/5/19.
 */
public class BuildTrie {

  TrieNode root;

  BuildTrie(){
    root = new TrieNode();
  }

  class TrieNode {

    Character value;
    Map<Character,TrieNode> children;
    boolean endOfNode;


    TrieNode(){
      this.children = new HashMap<>();
      this.endOfNode = false;
    }


  }



  public void buildTrieNodeFromString(String target){

    TrieNode current = root;

    for(int i=0; i<target.length();i++){

      TrieNode node = current.children.get(target.charAt(i));

      if(node==null){
        node = new TrieNode();
        node.value = target.charAt(i);
        current.children.put(target.charAt(i),node);
      }

      current = node;

    }

    current.endOfNode = true;

  }


  public boolean searchInTrie(String target){

    TrieNode current = root;

    for(int i=0 ; i< target.length();i++){

      TrieNode node = current.children.get(target.charAt(i));

      if(node==null){
        return false;
      }

      current = node;

    }

    return current.endOfNode;

  }

  public void deleteRec(String target){

  }

  public boolean delete(TrieNode current , String target , int index){

    if(index==target.length()){

      if(!current.endOfNode){
        return false;
      }

      current.endOfNode = false;
      return current.children.size()==0;
    }

    TrieNode node = current.children.get(target.charAt(index));

    if(node==null){
      return false;
    }

    boolean isSafeToDelete = delete(node,target,index+1);

    if(isSafeToDelete){
      node.children.remove(target.charAt(index));
      return node.children.size()==0;

    }

    return false;

  }


}
