package com.dailyCodingProblem.algoExpert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mshaik on 2/3/19.
 */
public class TrieDataStructure {

  TrieNode root;

  class TrieNode {

    Map<Character,TrieNode> childern;
    boolean isEndOfWOrd;

     TrieNode() {
      this.isEndOfWOrd = false;
       childern = new HashMap<>();
    }

  }



  TrieDataStructure(){
    root = new TrieNode();
  }



  public void insertIntoTrieNode(String word){

    TrieNode current = root;

    for(int i=0; i<word.length();i++){

      Character letter = word.charAt(i);

      TrieNode node = current.childern.get(letter);

      if(node==null){
        node = new TrieNode();
        current.childern.put(letter,node);
      }

      current = node;
    }

    current.isEndOfWOrd = true;

  }


  public void searchInTrie(String word){

    TrieNode current = root;

    for(int i=0 ; i<word.length();i++){

    }


  }


  public void insertWord(String word){
    insertRecursive(root,word,0);
  }

  public TrieNode insertRecursive(TrieNode current ,String word, int index){



    if(index==word.length()){
      current.isEndOfWOrd = true;
    }

    TrieNode node = current.childern.get(word.charAt(index));

    if(node==null){
      node = new TrieNode();
      current.childern.put(word.charAt(index),node);
    }

    current= node;

    return insertRecursive(current,word,index+1);
  }


  public boolean searchWordInTrie(String word){

    TrieNode current = root;

    for(int i=0 ; i<word.length();i++){

      TrieNode node = current.childern.get(word.charAt(i));

      if(node==null){
        return false;
      }

      current = node;


    }


    return current.isEndOfWOrd;

  }


  public void  searchWordInNode(String word){
      searchRec(root,word,0);
  }


  public boolean searchRec(TrieNode current , String word, int index){

    if(word.length()==index){
     return current.isEndOfWOrd;
    }

    TrieNode node = current.childern.get(word.charAt(index));

    if(node==null){
      return false;
    }

    return searchRec(node,word,index+1);



  }


  public void deleteWordInTrie(String word){

  }

  public boolean deleteRec(TrieNode current, String word, int index){

    if(word.length()==index){
      if(!current.isEndOfWOrd){
        return false;
      }
      current.isEndOfWOrd = false;
     return current.childern.size() ==0;
    }

    char ch = word.charAt(index);
    TrieNode node = current.childern.get(word.charAt(index));

    if(node==null){
      return false;
    }

    boolean isSafeToDelete = deleteRec(node,word,index+1);

    if(isSafeToDelete){
      current.childern.remove(ch);
      return current.childern.size()==0;
    }


    return false;


  }


}
