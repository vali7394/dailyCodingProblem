package com.dailyCodingProblem.algoExpert;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by mshaik on 1/4/19.
 */
public class AlgoExpertArrays {





  public static void main(String[] args ) {

   // int[] arrayOne = {10,70,20,30,50,11,30};

   // int[] list = lonestRange(arrayOne);

   // int[] arrayOne = {1};
  //  Arrays.stream(largestRange(arrayOne)).forEach(System.out::println);
  //  printMax(arrayOne,arrayOne.length,3);

  //  Arrays.stream(list).forEach(System.out::println);

  //  List<Integer[]> list = fourNumberSum(arrayOne,16);

  /*  list.forEach(array->{
      System.out.println("List : ");
      Arrays.stream(array).forEach(System.out::println);
    });
*/

   // List<Integer[]> list = findTriplet(array,0);
   //   int[] list = closetDiff(arrayOne,arrayTwo);
  //  if(list.length==0) {
  //    System.out.println("No Qualified items");
  //  }

   // for(Integer[] triple : list) {
  //    Arrays.stream(list).forEachOrdered(System.out::println);
  //  }

    AlgoExpertArrays expertArrays = new AlgoExpertArrays();
  //  int[][] temp = {{0,0,0},{0,0,0},{0,0,0}};
   // expertArrays.findTotalPaths(temp);
   // System.out.println(expertArrays.findRepeatFirst("abbccccc"));

   // expertArrays.maxSumAIncreSubSeq(arrayOne).forEach(list->list.forEach(System.out::println));

 //   expertArrays.maxIncreSubSeqBS(arrayOne);

    SuffixTrie suffixTrie = new SuffixTrie();
    suffixTrie.populateSuffixTrieFrom("babc");

  }

  public static List<Integer[]> findTriplet(int[] array , int targetSum) {

    List<Integer[]> tripletList = new ArrayList<>();

    if(array==null || array.length<3) return tripletList;

    Arrays.sort(array);

    int currentSum = 0;


    for(int i=0 ; i<=array.length-2;i++) {

      int left = i+1;
      int right = array.length-1;
      int currentNo = array[i];

      while(left < right) {

        currentSum = currentNo + array[left] + array[right];

        if(targetSum == currentSum) {
          Integer[] triplet = {currentNo,array[left],array[right]};
          tripletList.add(triplet);
          left++;
        } else if(targetSum < currentSum) {
          right --;
        } else {
          left++;
        }


      }

    }

    return tripletList;

  }

  public int[] twoNumberSum(int[] array, int targetSum) {

    int[] empty = {};
    if(array==null || array.length<2) return empty;

    Arrays.sort(array);

    int left = 0;
    int right = array.length-1;

    int currentSum = 0;

    while(left<right) {

      currentSum = array[left] + array[right];

      if(currentSum == targetSum ) {

        int[] finalArray = {array[left],array[right]};
        return finalArray;

      } else if (currentSum < targetSum) {
        left++;
      } else {
        right--;
      }

    }

    return empty;

  }


  public static int[] twoNumberSumUsingMap(int[] array, int targetSum) {

    int[] emptyArray = {};
    if(array==null || array.length < 2) return emptyArray;
    Map<Integer,Integer> valueMap = new HashMap<>();

    for(int i=0;i<array.length;i++) {
      if(valueMap.get(array[i])!=null) {

        return new int[]{Math.min(array[valueMap.get(array[i])],array[i]),Math.max(array[valueMap.get
            (array[i])],array[i])};

      } else {
        valueMap.put(targetSum-array[i],i);
      }
    }

    return emptyArray;



  }

  public static int[] closetDiff(int[] arrayOne, int[] arrayTwo) {

    int[] finalResult = new int[2];
    if(arrayOne== null || arrayOne.length==0 || arrayTwo==null && arrayTwo.length==0 )  return finalResult;

    Arrays.sort(arrayOne);
    Arrays.sort(arrayTwo);

    int one = arrayOne.length-1;
    int second = arrayTwo.length-1;

    int i=0 ;
    int j=0 ;

    int smallDiff = Integer.MAX_VALUE;



    while(i<=one && j<=second) {

      int diff = Math.abs(arrayTwo[j]-arrayOne[i]);

      if(diff == 0) {
        return new int[] {arrayOne[i],arrayTwo[j]};
      }

      if(diff < smallDiff) {
        smallDiff = diff;
        finalResult = new int[]{arrayOne[i],arrayTwo[j]};
      }

      if(arrayOne[i] < arrayTwo[j]) {
        i++;
      } else {
        j++;
      }

    }

    return finalResult;


  }


  public static ArrayList<Integer[]> fourNumberSum(int[] array, int targetSum) {
    // Write your code here.

    Map<Integer,ArrayList<Integer[]>> pairMap = new HashMap<>();
    ArrayList<Integer[]> pairs = new ArrayList<>();

    for(int i=0 ; i<array.length-1 ; i++) {

      for(int j=i+1; j<array.length;j++) {

        int diff = targetSum- (array[i]+array[j]);

        if(pairMap.containsKey(diff)) {
          for(Integer[] result : pairMap.get(diff)) {
            pairs.add(new Integer[]{array[i],array[j],result[0],result[1]});

          }

        }


      }


      for(int k=0 ;k<i ;k++) {

        int sum = array[i] +array[k];

        if(pairMap.containsKey(sum)) {
          pairMap.get(sum).add(new Integer[]{array[i],array[k]});
        }else {
          ArrayList<Integer[]> list = new ArrayList<>();
          list.add(new Integer[]{array[i],array[k]});
          pairMap.put(sum,list);

        }



      }


    }

    return pairs;
  }



  public static int[] subarraySortUsingSort(int[] array) {
    int[] temp = Arrays.copyOf(array,array.length);
    Arrays.sort(array);
    if(Arrays.equals(array,temp)) return new int[] {-1,-1};
    int startRange = -1;
    int endRange = -1;
    int left = 0;
    int right = array.length-1;
    while(left <= array.length-1) {
      if(temp[left] == array[left]) left++;
      else {
        startRange = endRange;
        break;
      }

    }

    while(right >= 0) {
      if(temp[right]==array[right]) right--;
      else {
        endRange = right;
        break;
      }
    }

    if(startRange==array.length-1) return new int[]{0,array.length-1};
    else return new int[]{startRange,endRange};

  }


  public static int[] subarraySort(int[] array) {
    int minValue = Integer.MAX_VALUE;
    int maxValue = Integer.MIN_VALUE;

    for(int i=0 ; i<array.length;i++) {

      if(isOutOfOrder(i,array)) {
        minValue = Math.min(array[i],minValue);
        maxValue = Math.max(array[i],maxValue);
      }


    }

    if (minValue ==Integer.MAX_VALUE) return new int[] {-1,-1};

    int left= 0;
    int right = array.length-1;

    while(array[left] <= minValue) {
      left++;
    }

    while(array[right]>=maxValue) {
      right--;
    }

    return new int[] {left,right};

  }

  private static boolean isOutOfOrder(int i , int[] array) {

    if(i==0) {
      return array[i]>=array[i+1];
    }

    if(i==array.length-1) {
      return array[i-1] >= array[i];
    }

    return !(array[i] >= array[i-1] && array[i]<=array[i+1]);

  }


  public static int[] lonestRange(int[] array) {

    Arrays.sort(array);

    int range = 0;
    int longestRange = 0;

    int start = 0;
    int end = -1;

    int s = 0;

    for(int i=0 ; i<array.length-1 ; i++) {
      range++;
      if(array[i]+1==array[i+1]) {

        if(longestRange<range) {
          end = i;
          longestRange = range;
        } else {
          range = 0;
          start = s;
          s = i;
        }

      }

    }
    return new int[] {array[start],array[end]};
  }



  static void printMax(int arr[],int n, int k)
  {

    Deque<Integer> queue = new ArrayDeque<>();
    List<Integer> output = new ArrayList<>();
    int i=0;
    for( i=0 ; i<k ;i++) {

      while(!queue.isEmpty() && arr[i]>=arr[queue.peekLast()]) {
        queue.removeLast();
      }

      queue.addLast(i);


    }


    for(;i<n;i++) {

      output.add(arr[queue.peekFirst()]);

      while(!queue.isEmpty() && queue.peekFirst()<=i-k) {
        queue.removeFirst();
      }

      while(!queue.isEmpty() && arr[i]>=arr[queue.peekLast()]){
            queue.removeLast();
      }

      queue.addLast(i);

    }

    output.add(arr[queue.peekLast()]);

    output.stream().forEach(System.out::println);
  }


  public static void islands(int[][] matrix) {

    if(matrix == null) System.out.println(0);

    int island = 0;
    for(int i=0 ; i<matrix.length;i++) {

      for(int j=0 ; j<matrix[0].length;j++) {

        if(matrix[i][j]==1) {
          island++;
        }


      }


    }

    System.out.println(island);

  }


  private static void changeLandToWater(int[][] matrix, int i, int j) {

    if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || matrix[i][j]==0) return;
    matrix[i][j] = 0;
      changeLandToWater(matrix,i-1,j);
    changeLandToWater(matrix,i+1,j);
    changeLandToWater(matrix,i,j-1);
    changeLandToWater(matrix,i,j+1);
  }



  public static void  maxElementFromSubArray(int[] array , int k) {

    List<Integer> finalList = new ArrayList<>();

    Deque<Integer> queue = new ArrayDeque();
    int i=0 ;
    for(; i<k;i++) {

      while(!queue.isEmpty() && array[i]>=array[(int)queue.peekLast()]) {
        queue.removeLast();
      }

      queue.addLast(i);

    }


    for(;i<array.length;i++) {

      finalList.add(array[(int)queue.peekLast()]);

      while(!queue.isEmpty() && queue.getFirst()<=i-k)  {
        queue.removeFirst();
      }

      while(!queue.isEmpty() && array[i]>=array[queue.peekLast()] ) {
        queue.removeLast();
      }
      queue.addLast(i);

    }

    finalList.add(array[queue.peekLast()]);

  }

  public static void findRange(int[] array) {

    Map<Integer,Boolean> temp = new HashMap<>(array.length);

    int[] finalRange = new int[2];

    for(int num : array) {
      temp.put(num,true);
    }

    int logestRnage = 0;
    int startRange = Integer.MIN_VALUE;
    int endRange = Integer.MAX_VALUE;

    for(int num : array) {

      if(!temp.containsKey(num)) {
        continue;
      }

      int left = num-1;
      int right = num+1;

      int currentLength=0;

      while(temp.containsKey(left)) {
        temp.put(left,false);
        currentLength++;
        left--;
      }

      while(temp.containsKey(right)) {
        temp.put(right,false);
        currentLength++;
        right++;
      }

      if(currentLength > logestRnage) {
        logestRnage = currentLength;
        finalRange[0] = left+1;
        finalRange[1] = right-1;
      }

    }





  }

  public static int[] largestRange(int[] array) {
    // Write your code here.
    int[] result = new int[2] ;
    Map<Integer,Boolean> valueMap = new HashMap<>();
    int longestRange = 0;
    for(int num : array) {
      valueMap.put(num,true);
    }

    for(int num : array) {
      if(!valueMap.containsKey(num)) {
        continue;
      }

      int left = num-1;
      int right = num+1;
      int currentLength = 0;

      while(valueMap.containsKey(left)) {
        valueMap.put(left,false);
        currentLength++;
        left--;
      }

      while(valueMap.containsKey(right)) {
        valueMap.put(right,false);
        currentLength++;
        right++;
      }

      if(currentLength >= longestRange) {
        result = new int[]{left+1, right-1};
        longestRange = currentLength;
      }

    }
    return result;
  }

  public int[] findLargestRange(int[] array) {

    int[] result = new int[2];

    if(array==null || array.length==0) return result;

    Map<Integer,Boolean> rangeMap = new HashMap<Integer,Boolean>();

    int largestrange = 0;

    for(int num : array) {
      rangeMap.put(num,true);
    }

    for(int num : array) {

      if(!rangeMap.containsKey(num)) {
        continue;
      }

      int currentRange = 0;

      int left = num-1;
      int right = num+1;

      while(rangeMap.containsKey(left)) {
        rangeMap.put(left,false);
        currentRange++;
        left--;
      }

      while(rangeMap.containsKey(right)) {
        rangeMap.put(right,false);
        currentRange++;
        right++;
      }

      if(currentRange > largestrange) {
        largestrange = currentRange;
        return new int[] {left+1,right-1};
      }

    }

    return result;


  }


  public static int maxSumNoAdj(int[] array) {

    int maxSum = 0;

    int first = array[0];
    int second = Math.max(first,array[1]);

    int current = 0;
    for(int num : array) {
      current = Math.max(first+num,second);
      first = second;
      second = current;
    }

    return second;
  }


  public static void totalNoOfPaths(int[][] matrix) {

    for(int i=0; i<matrix.length; i++) {

      for(int j=0 ; j<matrix[0].length;j++) {


      }

    }


  }

  public void findTotalPaths(int[][] array) {

    System.out.println(findPath(array,0,0,0));

  }


  public int findPath(int[][] array , int row , int col,int sum) {

    if((col>=array[0].length && row>=array.length) || array[array.length-1][array[0].length-1]==0) return sum+=1;

    if(col>=array[0].length) return sum+=findPath(array,row+1,col,sum);
    if(row>=array.length) return sum+=findPath(array,row,col+1,sum);

    if(array[row][col]==1) return 0;

    sum+= findPath(array,row,col+1,sum);
    sum+= findPath(array,row+1,col,sum);

    return sum;

  }



  public void firstRecurrsingLetter(String s){

    char[] letters = s.toCharArray();
    Set<Character> cSet = new HashSet<>(s.length());
    for(Character c : letters) {
      if(!cSet.contains(c)) {
        cSet.add(c);
      }else {
        System.out.println(" repeating first charcter" + c);
        break;
      }
    }

  }


  public  int findRepeatFirst(String s)
  {

    int repeat = -1;
    int m,n;

    int hashArray[] = new int[256];
    int position[] = new int[256];


    for(int i=0;i<s.length();i++ ) {

      int temp = (int) s.charAt(i);

      if(hashArray[temp]==0) {

        hashArray[temp]++;
        position[temp] = i;
      }

      else {

        hashArray[temp]++;


      }

    }


    for(int i=0 ; i<hashArray.length;i++) {
      if(hashArray[i]==2) {

        if(repeat==-1) {
          repeat = position[i];
        } else if(repeat > position[i]) {
          repeat = position[i];
        }


      }
    }

    return repeat;
  }




  public int longestCommonSubSeqRec(char[] s1 , char[] s2, int length, int length2) {

    if(s1.length==length || s2.length==length2) return 0;

    if(s1[length]==s2[length2]) return 1+ longestCommonSubSeqRec(s1,s2,length+1,length2+1);
     else return Math.max(longestCommonSubSeqRec(s1,s2,length+1,length2),longestCommonSubSeqRec(s1,s2,length,
        length2+1));

  }


  public int longestCommonSubSeqDp(String s1 , String s2) {

      int[][] temp = new int[s1.length()+1][s2.length()];

      int max= 0;

      for(int i=1 ; i<temp.length ; i++) {

        for(int j=1; j<temp[i].length ; j++) {

          if(s1.charAt(i-1)==s2.charAt(j-1)) {
            temp[i][j] = temp[i-1][j-1] +1;
          } else {
            temp[i][j] = Math.max(temp[i-1][j],temp[i][j-1]);
          }

          if( max < temp[i][j] ) {
            max = temp[i][j];
          }

        }


      }


    int i = s1.length() ;
    int j = s2.length();

    String finalString = "";

    while(i>0 && j>0) {

      if(s1.charAt(i-1)==s2.charAt(j-1)) {
        finalString = s1.charAt(i-1) + finalString;
        i--;
        j--;
      } else if( temp[i-1][j] < temp[i][j-1]) {
          j--;
      } else {
        i--;
      }

    }

    System.out.println(finalString);
    return max;

  }


  public int longgestIncSubSeq(int[] array) {

    int temp[] = new int[array.length];

    for(int i=0 ; i<temp.length ; i++) {
      temp[i] = 1;
    }

    int max = 0;

    for(int i= 1 ; i<array.length; i++) {

      for(int j=0 ; j<i ; j++) {

        if(array[i] > array[j]) {
          temp[i] = Math.max(temp[i],temp[j]+1);
        }

        if(max < temp[i]) {
          max = temp[i];
        }

      }

    array.clone();
    }

    return max;
  }


  public List<ArrayList<Integer>> maxSumAIncreSubSeq(int[] array) {

    if(array==null || array.length==0) return new ArrayList<>(Collections.emptyList());

    if(array.length==1) {

      List<ArrayList<Integer>> list = new ArrayList<>();
      list.get(0).add(array[0]);
      list.get(1).add(array[0]);
      return list;

    }

    int[] temp = array.clone();
    int[] seqs = new int[array.length];

    Arrays.fill(seqs,Integer.MIN_VALUE);

    int maxSumIndex = 0;

    for(int i=0 ; i< array.length ; i++) {


      for(int j=0; j< i ; j++) {

        if(array[j] < array[i] && temp[i] <= (temp[j]+ array[i])) {

          temp[i] = temp[j]+ array[i];
          seqs[i] = j;

        }

      }

      if(temp[i] > temp[maxSumIndex]) {
        maxSumIndex = i;
      }


    }

    return findActualSet(array,seqs,maxSumIndex,temp[maxSumIndex]);

  }


  public List<ArrayList<Integer>> findActualSet(int[] array , int[] seqs , int maxSumIndex,Integer maxSum) {


    List<ArrayList<Integer>> result = new ArrayList<>(2);

    ArrayList<Integer> sum = new ArrayList<>(1);
    sum.add(maxSum);
    result.add(0,sum);

    ArrayList<Integer> values = new ArrayList<>();

    result.add(1,values);
    while(maxSumIndex!=Integer.MIN_VALUE) {
      result.get(1).add(0,array[maxSumIndex]);
      maxSumIndex = seqs[maxSumIndex];
    }


    return  result;
  }



  public void maxIncreSubSeqBS(int[] array){

    int[] seqs = new int[array.length+1];
    int[] parent = new int[array.length];

    Arrays.fill(parent,-1);

    int length=0;

    for(int i=0; i<array.length;i++){

      int current = array[i];
      int low = 1;
      int high = length;
      while(low<=high){

        int mid = Math.floorDiv(low+high,2);

        if(array[seqs[mid]] < array[i]){
          low = mid+1;
        }else {
          high = mid-1;
        }

      }

      int pos = low;

      parent[i] = seqs[pos-1];
      seqs[pos] = i;

      if(pos>length){
        length = pos;
      }



    }






  }


}
