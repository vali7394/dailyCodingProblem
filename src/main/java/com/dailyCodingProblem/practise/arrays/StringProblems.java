package com.dailyCodingProblem.practise.arrays;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by mshaik on 2/4/19.
 */
public class StringProblems {



  public static void main(String[] args){
    StringProblems problems = new StringProblems();
   // problems.permutationForIntegers(Arrays.asList(1,2,3));
//    problems.groupAnagrams();

   // problems.topKFreqWords(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},4);
  //  problems.subArrayWithGivenSum(new int[]{-2,-1,2,1},1);

    //equalizeArray(new int[]{3 ,3, 2, 1, 3});
    problems.roundOff( 24.988);

  }

  public void permutation(){
    List<String> perms = new ArrayList<>();
    perHelper("abc","",perms);
    perms.forEach(System.out::println);
  }


  public void perHelper(String actual, String choosen , List<String> list){

    if(actual.length()==0) {
      list.add(choosen);
      return;
    }

    for(int i=0; i<actual.length();i++){
      perHelper(new StringBuilder(actual).deleteCharAt(i).toString(),choosen +actual.charAt(i),list);
    }

  }


  public void permutationForIntegers(List<Integer> nums){

    List<List<Integer>> result = new ArrayList<>();

    permuHelperIntegers(nums, new ArrayList<Integer>(),result);

    result.forEach(list->{
      System.out.println();
      list.forEach(System.out::print);
    });

  }

// O(n2*n!) o(n*n!)
  public void permuHelperIntegers(List<Integer> nums , List<Integer> perm , List<List<Integer>> result){

    if(nums.size()==0){
      result.add(perm);
      return;
    }

    for(int i=0 ;i<nums.size();i++){
      List<Integer> newList = new ArrayList<>(nums);
      newList.remove(nums.get(i));
      List<Integer> newListPerm = new ArrayList<>(perm);
      newListPerm.add(nums.get(i));
      permuHelperIntegers(newList,newListPerm,result);
    }


  }


  public static void swap(int i , int j , ArrayList<Integer> array){

    int temp = array.get(i);
    array.add(i,array.get(j));
    array.add(j,temp);

  }


  public void fibNonicNo(int n){

  }


  public int fibHelper(int n , int[] cache){

    if(cache[n]!=0){
      return cache[n];
    }

    if(n<=1){
      return 0;
    }

    if(n==2){
      return n;
    }

    int num = fibHelper(n-1,cache)+fibHelper(n-2,cache);

    cache[n] = num;

    return cache[n];

  }


  public ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> list){

    ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();
    powerSet.add(new ArrayList<Integer>());
    for(int num : list){
      int length = powerSet.size();

      for(int j=0 ;j<length;j++){

        ArrayList<Integer> subSet = new ArrayList<>(powerSet.get(j));
        subSet.add(num);
      }

    }
    return powerSet;
  }


  public static int[] searchInSortedMatrix(int[][] matrix, int target) {

    int[] result = new int[]{-1,-1};

    if(matrix==null || matrix.length==0 || matrix[0].length==0) return result;

    int rowIndex = 0;
    int columnIndex = matrix[0].length-1;

    while(rowIndex<matrix.length || columnIndex>=0){

      if(matrix[rowIndex][columnIndex] == target) {
        return new int[]{rowIndex,columnIndex};
      } else if(matrix[rowIndex][columnIndex] < target){
        rowIndex++;
      }else{
        columnIndex--;
      }

    }
    return result;
  }

  public static int shiftedBinarySearch(int[] array, int target) {
    // Write your code here.
    return searchInRotatedArray(array,0,array.length-1,target);
  }

  public static int searchInRotatedArray(int[] a , int start , int end , int target){

    while(start<=end){
      int mid = (start+end)/2;
      if(a[mid]==target){
        return mid;
      } else if(a[mid]<=a[end]){

        if(a[mid]<target && target<=a[end]){
          start=mid+1;
        } else {
          end= mid-1;
        }
      }
      else if(a[mid]>=a[start]){

        if(a[mid]<target && target>=a[start]){
          start=mid+1;
        } else {
          end= mid-1;
        }
      }
    }
    return -1;
  }

  public static int shiftedBinarySearchT(int[] array, int target) {
    // Write your code here.

    if(array==null || array.length==0) return -1;

    int start = 0;
    int end = array.length-1;;
    int mid=0;
    while(start<=end) {

      mid = (start+end)/2;

      if(array[mid]==target) {
        return mid;
      }

      else if(array[mid]<=array[end]) {

        if(target> array[mid] && target <=array[end]) {
          start  = mid+1;
        } else {
          end = mid-1;
        }

      }

      else if(array[start]<=array[mid]) {
        if(target>=array[start] && target< array[mid]) {
          end = mid-1;
        } else {
          start = mid+1;
        }
      }



    }

    return -1;

  }

  public void longestPalindrumSubString(String string){

    if(string.length()==0 || string==null){
      return;
    }

    if(string.length()==1) System.out.println(string);

    int[] longestSubString = new int[]{0,1};

    for(int i=1 ; i<string.length();i++){

      int[] oddPalin = longestPalinFrom(i-1,i+1,string);
      int[] evenPalin = longestPalinFrom(i-1,i,string);

      int[] longest = oddPalin[1]-oddPalin[0] > evenPalin[1]-evenPalin[0]?oddPalin:evenPalin;
      longestSubString = longest[1]-longest[0] > longestSubString[1]-longestSubString[0]?longest:longestSubString;
    }

    System.out.println(string.substring(longestSubString[0],longestSubString[1]));




  }

  public int[] longestPalinFrom(int start , int end , String target){

    while(start>=0 && end<=target.length()-1){

      if(target.charAt(start)==target.charAt(end)){
        start--;
        end++;
      }else {
        break;
      }

    }

    return new int[]{start,end};
  }


  public void longestStringWithRepetingChars(String s){

    Map<Character,Integer> map = new HashMap<>();

    int[] longest = new int[]{0,1};

    int startIndx = 0;

    for(int i=0; i<s.length();i++) {
      if(map.containsKey(s.charAt(startIndx))){
        startIndx = Math.max(startIndx,map.get(s.charAt(startIndx)+1));
      }
      map.put(s.charAt(startIndx),startIndx);

      if(longest[1]- longest[0] < i+1-startIndx){
        longest = new int[]{startIndx,i+1};
      }



    }


    System.out.println(s.substring(longest[0],longest[1]));

  }

//o(nk)
  public void groupAnagrams(){

    String[] anaggrams = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
    Map<String,List<String>> groupAnagrams = new HashMap<>(anaggrams.length);

    // o(n)
    for(String string : anaggrams){

      String hashCode = generateHashCode(string);

      if(groupAnagrams.containsKey(hashCode)){
        groupAnagrams.get(hashCode).add(string);
      }else {
        List<String> anagrams = new ArrayList<>();
        anagrams.add(string);
        groupAnagrams.put(hashCode,anagrams);
      }


    }

    for(Map.Entry<String,List<String>> entry : groupAnagrams.entrySet()){
      System.out.println(entry.getKey());
      entry.getValue().forEach(str->{
        System.out.print(str+ "   ");
      });
      System.out.println();
    }


  }

 // o(k)
  public String generateHashCode(String string){

    Map<Character,Integer> count = new HashMap<>(string.length());

    for(char ch : string.toCharArray()){
      if(count.containsKey(ch)){
        count.put(ch,count.get(ch)+1);
      }else {
        count.put(ch,1);
      }
    }



    StringBuilder sb = new StringBuilder();

    // o(1)
    for(int i=97;i<123;i++){
      if(count.containsKey((char)i)) {
        sb.append((char) i).append(count.get((char)i));
      }else {
        continue;
      }
    }

    return sb.toString();

  }


  public void topKFreqElements(int[] array , int k){

    Map<Integer,Integer> countMap = new HashMap<>(array.length);

    for(int number : array){

      if(countMap.containsKey(number)){
        countMap.put(number, countMap.get(number)+1);
      }else {
        countMap.put(number,1);
      }

    }


    PriorityQueue<Integer> queue = new PriorityQueue<>((n1,n2)->countMap.get(n1)-countMap.get(n2));

    for(int entry : countMap.keySet()){
      queue.add(entry);

      if(queue.size() > k){
        queue.poll();
      }

    }

    List<Integer> finalResult = new ArrayList<>();

    while(!queue.isEmpty()){
      finalResult.add(queue.poll());
    }

    Collections.reverse(finalResult);

    finalResult.forEach(System.out::println);


  }


  public void topKElemetn(int[] array){









  }



  public void topKFreqWords(String[] array , int k){

    Map<String,Integer> countMap = new HashMap<>(array.length);

    for(String word : array){

      if(countMap.containsKey(word)){
        countMap.put(word, countMap.get(word)+1);
      }else {
        countMap.put(word,1);
      }

    }

    PriorityQueue<String> queue = new PriorityQueue<>((s1,s2)->countMap.get(s1).equals(countMap.get(s2))?s2.compareTo
        (s1):countMap
        .get
        (s2)
        -countMap
        .get(s1));

    for(String key: countMap.keySet()){
      queue.add(key);

      if(queue.size()>k){
        queue.poll();
      }

    }


    List<String> finalList = new ArrayList<>();

    while(!queue.isEmpty()) {
      finalList.add(queue.poll());
    }

    finalList.forEach(System.out::println);


  }


  public void maxSumSubArray(int[] array , int k) {

    int sumSofar = array[0];
    int start = 0;

    int i;
    for (i = 1; i < array.length; i++) {

      while (sumSofar > k && start < i - 1) {
        sumSofar -= array[start];
        start++;
      }

      if (sumSofar == k) {
        System.out.print(start + "  " + (i-1));
        return;
      }


      if (i < array.length) {
        sumSofar += array[i];


      }




    }
    System.out.print("No Subarray");
  }


  public void subArrayWithGivenSum(int[] array , int k){

    int currentSum= 0;

    Map<Integer,Integer> subArray = new HashMap<>();
    int start = 0;

    for(int i=0 ; i<array.length;i++) {

      currentSum+=array[i];

      if(currentSum-k==0){
        System.out.print(start + " " + i);
        return;
      }

      if(subArray.containsKey(currentSum-k)) {
        System.out.print(subArray.get(currentSum-k)+1 + "  " + i);
        return;
      }

      subArray.put(currentSum,i);

    }


    System.out.print("No Sum");


  }

  static int equalizeArray(int[] array) {

    Map<Integer,Integer> countMap = new HashMap<>();
    for(int i=0 ; i<array.length;i++){
      if(countMap.containsKey(array[i])){
        countMap.put(array[i],countMap.get(array[i])+1);
      } else {
        countMap.put(array[i],1);
      }
    }

    int count = 0;



    int max = 0;
    for(int key : countMap.keySet()){

      if(max < countMap.get(key)){
        max = countMap.get(key);
      }

    }


    for(int key : countMap.keySet()){
      if(countMap.containsKey(key)){

        if(countMap.get(key)==max){
          continue;
        }else{
          count+=countMap.get(key);
        }

      }


    }
    return count;

  }


  public void roundOff(double no){
    System.out.print(new BigDecimal(no).setScale(2,BigDecimal.ROUND_HALF_UP));
  }

}
