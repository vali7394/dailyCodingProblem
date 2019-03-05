package com.csdojo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mshaik on 2/13/19.
 */
public class ArraysProblems {


  public static void main(String[] args){

    ArraysProblems problems = new ArraysProblems();

    /*for(int num :problems.lonestContinousRange(new int[]{4,2,1,3,6})){
      System.out.print(num);
    }*/

  //  Stack<Integer> stack = new Stack<>();

  //  for(int num : new int[]{1,2,3,4}){
  //    stack.push(num);
  //  }

   // problems.firstRepeatedCharWithConstntSpace("geeksforgeeks");

     //   problems.interLeaveAStack(stack);
  //  problems.infixToPostfix("7-3+5-2");
  /*  int[][] arr = { {1, 3},
        {2, 4, 6},
        {0, 9, 10, 11}} ;
   for(int n :problems.mergeKSortedLinkedList(arr)){
     System.out.println(n);
   }*/
 // problems.mergeSort(new int[]{9,5,7,82,4,5,1});
    problems.rotateAnArray(new int[]{1,2,3,4,5,6,7},2);
  }


  public int[] getTwoNumSum(int[] array, int targetSum){


    Map<Integer,Integer> valueMap = new HashMap<>(array.length);

    for(int i=0 ; i<array.length;i++){

      if(valueMap.containsKey(array[i])){
        return new int[] {Math.min(array[i],array[valueMap.get(array[i])]),Math.max(array[i],array[valueMap.get(array[i])])};
      }

      valueMap.put(targetSum-array[i],i);

    }

    return new int[]{};

  }


  public List<Integer[]> threeNoSum(int[] array , int target) {

    List<Integer[]> triplets = new ArrayList<>();

    if(array==null || array.length==0) {
      return triplets;
    }

    Arrays.sort(array);

    for(int i=0 ; i< array.length;i++){

      int start = i+1;
      int end = array.length-1;

      while(start<end){

        int sum = array[i] + array[start] + array[end];

        if(sum==target){
          triplets.add(new Integer[]{array[i],array[start],array[end]});
          start++;
          end--;
        }

        if(sum < target) {
          start++;
        } else {
          end--;
        }


      }




    }

    return triplets;

  }


  public int[] minimalDiff(int[] one ,int[] two){

    if(one==null || two==null ||one.length==0 || two.length==0) return new int[]{};

    if(one.length==1 && two.length==1) return new int[]{one[0],two[0]};

    Arrays.sort(one);
    Arrays.sort(two);

    int first = 0;
    int second = 0;

    int diff = Integer.MAX_VALUE;

    int[] result = new int[2];

    while(first<one.length && second < two.length) {

       int currentDiff = Math.abs(one[first]-two[second]);

       if(currentDiff==0) {
         return new int[] {one[first],two[second]};
       }

      else if(diff > currentDiff){
         diff = currentDiff;
         result = new int[] {one[first],two[second]};
       }

       if(one[first] < two[second]) {
        first++;
       }else {
        second++;
       }


    }

    return result;
  }


  public int[] subArraySort(int[] array) {

    if(array== null || array.length==0) return new int[] {};

    int minSoFar = Integer.MAX_VALUE;
    int maxSoFar = Integer.MIN_VALUE;

    for(int i=0 ; i<array.length;i++) {
      if(!isOutOfOrder(array,i)) {
        minSoFar  = Math.min(minSoFar,array[i]);
        maxSoFar = Math.max(maxSoFar,array[i]);
      }

    }

    if(minSoFar==Integer.MAX_VALUE) return new int[] {-1,-1};

    int start = 0;
    int end = array.length-1;

    while (array[start] <= minSoFar) {
      start++;
    }

    while (array[end] >= maxSoFar) {
      end--;
    }

    return new int[]{ start,end};

  }


  public boolean isOutOfOrder(int[] array, int i){
    if(i==0){
      return array[i] <= array[i+1];
    }

    if(i==array.length-1){
      return array[i] >= array[i-1];
    }

    return array[i-1] <= array[i] &&  array[i]<= array[i+1];
  }



  public int[] lonestContinousRange(int[] array){

    Map<Integer,Boolean> range = new HashMap<>();

    for(int num : array){
      range.put(num,true);
      }

      int longestRange = Integer.MIN_VALUE;
      int[] bestRange = new int[2];

    for(int num : array){

      if(!range.get(num)) {
        continue;
      }

      range.put(num,false);

      int start = num-1;
      int end=num+1;
      int currentRange = 0;
      while(range.get(start)!=null && range.get(start)){
        range.put(start,false);
        start--;
        currentRange++;
      }

      while (range.get(end)!=null && range.get(end)){
        range.put(end,false);
        end++;
        currentRange++;
      }

      if(longestRange < currentRange){
        longestRange = currentRange;
        bestRange = new int[]{start+1,end-1};
      }


    }



    return bestRange;

  }

  public void firstNonRepeatingCharInSubString(String input){

    input = input.toLowerCase();

    if(input==null || input.length()==0){
      System.out.print("Invalid Input");
    }

    if(input.length()==1){
      System.out.print(input);
    }

    Map<Character,Integer> count = new HashMap<>(26);

    for(int i=97; i<124;i++){
      count.put((char)i,-1);
    }

   // String[] chars = input.split("");

    for(int i=0; i<input.length();i++) {
      if(count.get(input.charAt(i))==-1){
        count.put(input.charAt(i),i);
      }

      else {
        count.put(input.charAt(i),-2);
      }

    }

    int minSofar = Integer.MAX_VALUE;
    char nonRepeating = ' ' ;

    for(Map.Entry<Character,Integer> entry : count.entrySet()){

      if(entry.getValue() >= 0){

        if(entry.getValue() < minSofar){
          minSofar = entry.getValue();
          nonRepeating = entry.getKey();
        }

      }


    }

    System.out.print(nonRepeating);


  }

  public void firstRepeatingChar(String input){

     if(input==null || input.length()==0){
       System.out.print("Invalid input");
     }

    Set<Character> charSet = new HashSet<>();

     for(int i=0; i<input.length();i++){
       if(charSet.contains(input.charAt(i))){
         System.out.print(input.charAt(i));
         break;
       }else {
         charSet.add(input.charAt(i));
       }
    }




  }


  public void firstRepeatedCharWithConstntSpace(String input){

    int[] countMap = new int[256];
    int[] position = new int[256];


    for(int i=0 ; i<input.length();i++){

      int letter = (int)input.charAt(i);
      if(countMap[letter]==0){
        countMap[letter]++;
        position[letter] = i;
      }
      else if(countMap[letter]==1){
        countMap[letter]++;
      }


    }

      int pos = -1;
    for(int i=0; i<256;i++) {

      if(countMap[i]==2){

        if(pos==-1){
          pos = position[i];
        }

       else if(pos > position[i]){
           pos = position[i];
        }

      }



    }


    System.out.print(input.charAt(pos));

  }


  public void interLeaveAStack(Stack<Integer> stack){

    ArrayDeque<Integer> deque = new ArrayDeque<>();

    while(!stack.isEmpty()){
      deque.add(stack.pop());
    }

    while (!deque.isEmpty()){
      System.out.print(deque.removeLast());
      if(!deque.isEmpty()){
        System.out.print(deque.removeFirst());
      }
    }

  }



  public void postFixEval(String input) {
    String[] values = input.split("");

    Stack<Integer> valueStack = new Stack<>();

    for (int i = 0; i < values.length; i++) {

      if (values[i].equalsIgnoreCase("+") || values[i].equalsIgnoreCase("-") || values[i].equalsIgnoreCase("*")
          || values[i].equalsIgnoreCase("/")) {

        if (valueStack.isEmpty() || valueStack.size() == 1) {
          System.out.print("Invalid Exp");
          return;
        } else {

          int op1 = valueStack.pop();
          int op2 = valueStack.pop();
            valueStack.push(calculate(op2,op1,values[i]));
        }

      } else {
        valueStack.push(Integer.parseInt(values[i]));
      }


    }

    System.out.print(valueStack);
  }


  public int calculate(int a , int b , String operation){

    switch (operation){

      case "+" : return a+b ;
      case "-" : return a-b;
      case "*" : return a*b;
      case "/": return a/b;

      default:throw new UnsupportedOperationException(a+b+operation);

    }


  }


  public void infixToPostfix(String input){


    Stack<String> stack = new Stack<>();

    String token_pattern = "[0-9]+|[-+*/()]";

    Pattern pattern = Pattern.compile(token_pattern);
    Matcher matcher = pattern.matcher(input);


    StringBuilder output = new StringBuilder();


    while (matcher.find()){

      String token = matcher.group();

      if(token.matches("[0-9]+")){
        output.append(token);
      }

     else if("(".equalsIgnoreCase(token)){

        stack.push(token);
      }
      else if(")".equalsIgnoreCase(token)){

        while(!stack.isEmpty() && !stack.peek().equalsIgnoreCase("(")){
          output.append(stack.pop());
        }

        stack.pop();

      }

      else if(token.matches("[*-/+]")){

        while (!stack.isEmpty()&&  token.matches("[*-/+]") && findPrecedence(stack.peek()) >= findPrecedence(token)){
      output.append(stack.pop());
        }

        stack.push(token);




      }



    }


  while(!stack.isEmpty()){
      output.append(stack.pop());
  }



  }


  public int findPrecedence(String input){

    switch(input) {

      case "+" : return 0;
      case "-" : return 0;
      case "*" : return 1;
      case "/" : return 2;
      default:
        throw new UnsupportedOperationException("prec: " + input);
    }


  }


  public void kadensAlgo(int[] array){

    int maxSofar = array[0];
    int current=0;
    for(int i=1; i<array.length;i++){
       current= current+array[i];

      if(maxSofar <current){
        maxSofar = current;
      }

      if(current<0){
        current = 0;
      }

    }




  }


  public void medianOfTwoSortedArrays(int[] input1 , int[] input2){

    if(input1.length > input2.length){
      medianOfTwoSortedArrays(input2,input1);
    }

    int x = input1.length;
    int y = input2.length;

    int start = 0;
    int end = input1.length-1;

    while(start<=end){

      int partionX = (start+end)/2;
      int parY = (x+y+1)/2-partionX;

      int maxXOFLeft = partionX==0?Integer.MIN_VALUE:input1[partionX-1];
      int minXOfRight = partionX==x?Integer.MAX_VALUE:input1[partionX];

      int maxYOFLeft = parY==0?Integer.MIN_VALUE:input2[parY-1];
      int minYOfRight = parY==y?Integer.MAX_VALUE:input2[parY];


      if(maxXOFLeft <= minYOfRight && minXOfRight <= maxYOFLeft){

        if(x+y%2==0){

        }

      } else if(maxXOFLeft > minYOfRight){
        end = partionX-1;
      } else {
        start = partionX+1;
      }


    }





  }


  public int[] mergeKSortedLinkedList(int[][] sortedList) {

    PriorityQueue<QueueNode> queue = new PriorityQueue<>();

    int size = 0;

    for(int i=0; i<sortedList.length;i++){
      size+=sortedList[i].length;
      if(sortedList[i].length>0)
      queue.add(new QueueNode(i,0,sortedList[i][0]));
    }

    int[] finalResult = new int[size];

    for(int i=0; !queue.isEmpty() ; i++){

      QueueNode node = queue.poll();
      int nexIndx = node.index+1;
      finalResult[i] = node.value;
      if(nexIndx < sortedList[node.array].length){
        queue.add(new QueueNode(node.array,nexIndx,sortedList[node.array][nexIndx]));
      }




    }

    return finalResult;
  }

  public void quickSort(int[] array){
    quickSortHelper(array,0,array.length-1);
      for(int num : array){
        System.out.println(num);
      }
  }


  public void quickSortHelper(int[] array , int start, int end) {

    if (start >= end) {
      return;
    }

    int partionInd = start;
    int left = partionInd + 1;
    int right = end;

    while (left <= right) {

      if (array[left] > array[partionInd] && array[right] < array[partionInd]) {
        swap(left,right,array);
      }
      else if(array[left]<=array[partionInd]){
        left++;
      }else if (array[right] >=array[partionInd]) {
        right--;
      }


    }

    swap(partionInd,right,array);

    boolean isLeftArraySmaller = right - start-1 < end-right+1;

    if(isLeftArraySmaller){
      quickSortHelper(array,start,right-1);
      quickSortHelper(array,right+1,end);
    }
    else {
      quickSortHelper(array,right+1,end);
      quickSortHelper(array,start,right-1);
    }

  }


    public void swap(int i , int j , int[] array){

      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;

  }



  public void mergeSort(int[] array){

      for(int temp : mergeSortHelper(array)){
        System.out.println(temp);
      }

  }


  public int[] mergeSortHelper(int[] array){

    if(array.length<=1){
      return array;
    }

    int mid = array.length/2;

    int[] left = Arrays.copyOfRange(array,0,mid);
    int[] right = Arrays.copyOfRange(array,mid,array.length);

    return mergeSortedArrays(mergeSortHelper(left),mergeSortHelper(right));


  }


  public int[] mergeSortedArrays(int[] left , int[] right){

    int[] temp = new int[left.length+right.length];

    int i=0 ;
    int j=0;
    int k=0;

    while (i<left.length && j<right.length){

      if(left[i] <= right[j]){
        temp[k] = left[i];
        i++;
      }
      else {

        temp[k] = right[j];
        j++;


      }

      k++;
    }

    while (i<left.length){
      temp[k] = left[i];
      i++;
      k++;
    }

    while (j<right.length){
      temp[k] = right[j];
      j++;
      k++;
    }

    return temp;

  }



  public void quickSelect(int[] array , int k){
    quickSelectHelper(array,0,array.length-1,k-1);
  }


  public int quickSelectHelper(int[]  array , int start , int end , int k){



    while (true){

      if(start > end){
        return Integer.MIN_VALUE;
      }

      int partion = start;
      int left = partion+1;
      int right = end;


      while (left<=right){

        if(array[left] > array[partion] && array[right] < array[partion]){
          swap(left,right,array);
        }
        else if(array[left] <= array[partion]){
          left++;
        }
        else {
          right--;
        }

      }

      swap(partion,right,array);

      if(right==k){
        return array[right];
      }else if(right < k){
        start = right+1;
      }else {
        end = right-1;
      }



    }




  }


  public int[] findRangeInArray(int[] array,int k){

    return new int[]{findFirstOccurrance(array,k),findlasttOccurrance(array,k)};
  }

  public int findFirstOccurrance(int[] array,int k){

    int start = 0;
    int end = array.length-1;
    int mid=0;
    int fisrtOcc=-1;
    while (start<=end){

      mid = start+end/2;

      if(array[mid]==k){
        fisrtOcc = mid;
        end = mid-1;
      } else if(array[mid] < k){
        start = mid+1;
      }
      else {
        end = mid-1;
      }


    }

    return fisrtOcc;

  }

  public int findlasttOccurrance(int[] array,int k){

    int start = 0;
    int end = array.length-1;
    int mid=0;
    int lastOcr=-1;
    while (start<=end){

      mid = start+end/2;

      if(array[mid]==k){
        lastOcr = mid;
        start = mid+1;
      } else if(array[mid] < k){
        start = mid+1;
      }
      else {
        end = mid-1;
      }


    }

    return lastOcr;

  }

  public int[] searchMatInSorted(int[][] array, int target){

    int i = 0;
    int j = array[0].length-1;

    while(i<array.length-1 && j>=0){

        if(array[i][j]==target){
          return new int[]{i,j};
        }else if(array[i][j] < target){
          i++;
        }else {
          j--;
        }

      }

      return new int[]{-1,-1};
    }


    public int searchInRotatedArray(int[] array , int target){

      int start = 0;
      int end = array.length-1;

      int mid = 0;

      while(start<=end){

        mid = Math.floorDiv(start+end,2);

        if(array[mid]==target){
          return mid;
        }

        else if(array[mid] <= array[end]){

          if(array[mid]<target && target<=array[end]){
            start = mid+1;
          }
          else {
            end = mid-1;
          }



        } else if(array[start]<=array[mid]){

          if(array[start]<=target && target<array[mid]){
            end = mid-1;
          }else {
            start = mid+1;
          }




        }





      }




    return -1;
    }


    public void rotateAnArray(int[] array, int k){

      int start = 0;
      int end = array.length-k-1;

      while(start<=end){
        swap(start,end,array);
        start++;
        end--;
      }

      start = array.length-k;
      end = array.length-1;

      while (start<=end){
        swap(start,end,array);
        start++;
        end--;
      }

      start = 0;
      end = array.length-1;

      while (start<=end){
        swap(start,end,array);
        start++;
        end--;
      }

    for(int i : array){
        System.out.println(i);
    }


    }


    public ArrayList<ArrayList<Integer>> maxSumSubArray(int[] array){

      if(array.length == 0) return new ArrayList<>();

      int[] temp = new int[array.length];
      int[] seqs = new int[array.length];

      Arrays.fill(array,-1);

      temp[0] = array[0];

      int maxInd = -1;

      for(int i=1 ; i<array.length;i++){

        int current = array[i];

        for(int j=0; j<i;j++ ){

         if(array[j] < current && temp[i] < temp[j]+current){
             temp[i] = temp[j] + current;
             seqs[i] = j;
           }


         }



        if(maxInd < seqs[i]) {
          maxInd = seqs[i];

        }
      }

      ArrayList< ArrayList<Integer>> finalIst = buildSeqArray(seqs,maxInd);
      ArrayList<Integer> value = new ArrayList<>();
      value.add(temp[array.length-1]);
      finalIst.add(0,value);

      return finalIst;

    }


  public ArrayList<ArrayList<Integer>> buildSeqArray(int[] temp , int maxInd){

      int index = maxInd;

    ArrayList< ArrayList<Integer>> finalIst = new ArrayList<>(2);
    ArrayList<Integer> list = new ArrayList<>();

      while(index!=-1){
        list.add(index);
        index = temp[index];
      }

    finalIst.add(list);
      return finalIst;

  }

  /* if i==j then 0

       a[i,j]= a[i,k] + a[k+1,j];

       m[i,j] = Math.min{ i<=k<j m[i,k]+ m[k+1,j] +p(i-1)p(k)p(j) }




   */


  public void matrixMultiplication(int[] p) {

    int[][] matrix = new int[p.length+1][p.length+1];

    for(int i=1 ; i<p.length;i++){

      for(int j=1 ; i<p.length;j++){

        if(i==j){
          matrix[i][j] = 0;
        }

      }

    }


    for(int j=2 ; j<=p.length;j++){
      for(int i=j-1; i<=p.length;i++){
        matrix[i][j] = matrix[i][i] + matrix[i+1][j] + p[i-1]*p[i]*p[j];
      }
    }




  }

  }







