package com.dailyCodingProblem.algoExpert;

import java.util.HashMap;

/**
 * Created by mshaik on 2/3/19.
 */
public class SuffixTrie {

  static class TrieNode {

    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

  }

    TrieNode root = new TrieNode();
    char endSymbol = '*';

    public SuffixTrie() {
     // populateSuffixTrieFrom(str);
    }

    public void populateSuffixTrieFrom(String str) {
      // Write your code here.
      TrieNode current = root;

      for (int i = 0; i < str.length(); i++) {
        String word = str.substring(i, str.length());
        buildTrieTreeFromString(root,word);
      }

    }

    public void buildTrieTreeFromString(TrieNode root , String word){

      TrieNode current = root;

      for(int i=0 ; i<word.length();i++){

        char letter = word.charAt(i);

        TrieNode node = current.children.get(letter);

        if(node==null){
          node = new TrieNode();
          current.children.put(letter,node);
        }

        current = node;

      }

      current.children.put(endSymbol,null);

  }

    public boolean contains(String str) {

      TrieNode current = root;

      for(int i=0 ; i<str.length();i++){
        Character letter = str.charAt(i);
        TrieNode node = current.children.get(letter);

        if(node==null){
          return false;
        }
        current = node;
      }
      return current.children.containsKey(endSymbol);
    }
  }


