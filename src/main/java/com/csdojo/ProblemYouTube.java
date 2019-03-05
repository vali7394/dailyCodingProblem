package com.csdojo;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by mshaik on 2/21/19.
 */
public class ProblemYouTube {


  public static void main(String[] args){
    ProblemYouTube youTube = new ProblemYouTube();
   // youTube.noWaysToDecodeAString("121");
   // System.out.print(variOfWays(5,new int[]{1,3,5}));
   // String url = youTube.noOfWayToENcode("www.google.com");
   // System.out.print(url);
   // System.out.print(youTube.get(url));
   // for(int i : youTube.longestSubArray(new int[]{5,1,3,5,2,3,4,1}))System.out.println(i);

    /*youTube.totalIslands(new int[][] {{1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1}
    },5,5);*/

   // youTube.sumInCircularArray(new int[]{8, -1, 3, 4});
  //  youTube.psblDecodingsOfaString(new char[]{'1','2','3'});
    youTube.smallPalnidrum("aefaedaefaefa");
  }


  private static int minCost(int cost[][], int m, int n)
  {
    int i, j;
    int tc[][]=new int[m+1][n+1];

    tc[0][0] = cost[0][0];

        /* Initialize first column of total cost(tc) array */
    for (i = 1; i <= m; i++)
      tc[i][0] = tc[i-1][0] + cost[i][0];

        /* Initialize first row of tc array */
    for (j = 1; j <= n; j++)
      tc[0][j] = tc[0][j-1] + cost[0][j];

        /* Construct rest of the tc array */
    for (i = 1; i <= m; i++)
      for (j = 1; j <= n; j++)
        tc[i][j] = Math.min(tc[i-1][j-1],
            Math.min(tc[i-1][j],
                tc[i][j-1])) + cost[i][j];

    return tc[m][n];
  }

  public void NoOccuredOddTimes(int[] array){

    int result = array[0];

    for(int i=1;i<array.length;i++ ){
      result^=array[i];
    }

    System.out.println(result);


  }

  public void missingNo(int[] array , int[] next){

    int result = array[0];

    for(int i=1; i<array.length;i++){
      result^=array[i];
    }

    for(int i=0;i<next.length;i++){
      result^=next[i];
    }

    System.out.println(result);

  }


  public void noWaysToDecodeAString(String s){

    Queue<Integer> queue = new LinkedList<>();

    queue.offer(0);
    int ways = 0;

    while (!queue.isEmpty()){

      int pos = queue.poll();

      if(pos == s.length()){
        ways++;
        continue;
      }

      if(s.charAt(pos)=='0'){
        continue;
      }


      int val =0 ;

      queue.offer(pos+1);

      if(pos+1 < s.length()){
        val = Integer.parseInt(s.substring(pos,pos+2));
        if(val>=10 && val<=26){
          queue.offer(pos+2);
        }


      }


    }

    System.out.print(ways);


  }

  public static int noOfWays(int n){
    if(n==0 || n==1){
      return 1;
    }

    else {
      return noOfWays(n-1)+noOfWays(n-2);
    }

  }


  public static int noOfWaysBottomUp(int n){
    int[] cache = new int[n+1];
    cache[0] = 1;
    cache[1] = 1;

    for(int i=2 ; i<=n ; i++){
      cache[i] = cache[i-1]+cache[i-2];
    }

    return cache[n];

  }


  public static int onOfWaysMemoryOpt(int n){

    int first = 1;
    int second = 1;

    int totalWays = 0;

    for(int i=2; i<=n;i++ ){
      totalWays= first+ second;
      first = second;
      second = totalWays;
    }

    return second;

  }


  public static int variOfWays(int n , int[] steps){

    int[] cache = new int[n+1];

    cache[0] = 1;



    for(int i=1;i<=n;i++){
      int total = 0;
      for(int j : steps){

        if(i-j>=0){
          total+=cache[i-j];
        }

      }
      cache[i] = total;





    }



  return cache[n];

  }

  String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

  Random random = new Random();
  String key = getRand();
  Map<String,String> map = new HashMap<>();
  public String noOfWayToENcode(String url){



    while (map.containsKey(key)){
      key = getRand();
    }

    map.put(key,url);
return "http://tinyurl.com/"+key;
  }


  public String get(String key){
    String temp = key.replace("http://tinyurl.com/","");
    if(map.containsKey(temp)){
      return map.get(temp);
    }else {
      return "Not found";
    }
  }



  public String getRand(){
    StringBuilder sb = new StringBuilder(6);
    for(int i=0 ; i<6;i++){
      sb.append(alphabet.charAt(random.nextInt(62)));
    }

    return sb.toString();

  }


  public void noOfWaysToDecode(String s){

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(0);
    int ways = 0;
    while(!queue.isEmpty()){

      int poll = queue.poll();

      if(poll==s.length()){
        ways++;
        continue;
      }

      if(s.charAt(poll)=='0'){
        continue;
      }

      queue.offer(poll+1);

      if(poll+1 < s.length()){

        int val = Integer.parseInt(s.substring(poll,poll+2));

        if(val>=10 && val<=26){
          queue.offer(poll+2);
        }


      }


    }






  }


  public void occuredOddNoOftimesInDuplicateArray(int[] array, int n){

    int[] countArray = new int[32];

    for(int i=0; i< array.length;i++){

      for(int k=0; k<32;k++){

        int setBit = 1<<k;

        if((array[i]&setBit)==setBit){
         countArray[k]++;
        }

      }


    }

    int occuredOddTimes = 0;

    for(int i=0; i<32;i++){
      countArray[i]= countArray[i]%n;

      if(countArray[i]==1){
        occuredOddTimes = occuredOddTimes | 1<<i;
      }

    }



  }


  public void maxSqSubMatrix(int[][] matrix){

    int[][] temp = new int[matrix.length][matrix[0].length];

    int maxSize = 0;

    for(int i=0 ; i<matrix.length;i++){

      for(int j=0;j<matrix[0].length;j++){


        if(i==0 || j==0){
          temp[i][j] = matrix[i][j];
        }

        if(matrix[i][j]==0){
          temp[i][j] = 0;
        } else {
          temp[i][j] = Math.min(matrix[i-1][j-1],Math.min(matrix[i][j-1],matrix[i-1][j]))+1;
        }

        if(maxSize < temp[i][j]){
          maxSize = temp[i][j];
        }


      }


    }




  }


  public void printMatrixDiaganally(int[][] matrix){



    int row = matrix.length;
    int col = matrix[0].length;

    int k= 0 ;

    for(;k<row;k++){

      for(int i=k;i>=0;i--){

        for(int j=0;j<col;j++){
          System.out.println(matrix[i][j]);
        }


      }




    }

    for(k=1; k<col;k++){

      for(int i=row-1; i>=0; i--){

        for(int j=k;j<col;j++){
          System.out.println(matrix[i][j]);
        }

      }


    }




  }


  public int[] longestSubArray(int[] array){

    if(array==null || array.length==0 || array.length==1) return array;

    Map<Integer,Integer> visited = new HashMap<>(array.length);

    int start = 0;
    int[] result = new int[2];

    for(int i=0; i<array.length;i++){

      if(visited.containsKey(array[i])) {
        start = Math.max(start, visited.get(array[i])+1);
      }

        if(result[1]-result[0] < i+1-start){
          result[0] = start;
          result[1] = i+1;
        }



      visited.put(array[i],i);



    }


    return Arrays.copyOfRange(array,result[0],result[1]);

  }



  public void totalIslands(int[][] matrix , int row , int col){

    boolean[][] vistied = new boolean[row][col];

    int count = 0;

    for(int i=0; i<row;i++) {

      for(int j=0; j<col; j++){

        if(vistied[i][j]==true){
          continue;
        }


        if(matrix[i][j]==0){
          continue;
        }
        makeVisitedOfEachNode(matrix,i,j,vistied);

        count++;




      }


    }

    System.out.println(count);

  }


  public void makeVisitedOfEachNode(int[][]matrix , int i ,int j , boolean[][]
      visited){

    if(i<0 || i>=matrix.length || j < 0 || j>=matrix[0].length){
      return;
    }

    if(matrix[i][j]==0){
      visited[i][j] = true;
      return;
    }

    if(visited[i][j]==true){
      return;
    }

    visited[i][j] = true;
    makeVisitedOfEachNode(matrix,i-1,j,visited);
    makeVisitedOfEachNode(matrix,i-1,j+1,visited);
    makeVisitedOfEachNode(matrix,i+1,j-1,visited);
    makeVisitedOfEachNode(matrix,i+1,j+1,visited);
    makeVisitedOfEachNode(matrix,i+1,j,visited);
    makeVisitedOfEachNode(matrix,i,j+1,visited);
    makeVisitedOfEachNode(matrix,i,j-1,visited);
    makeVisitedOfEachNode(matrix,i-1,j-1,visited);


  }


  public void maxInSubarray(int[] array, int k){

    if(array.length < k ) return;

    ArrayDeque<Integer> queue = new ArrayDeque<>(k);

    for(int i=0; i<k;i++){

        while(!queue.isEmpty()&&array[i] >= array[queue.peekLast()]){
          queue.removeLast();
        }

      queue.addLast(i);

    }


    for(int i=k; i<array.length;i++){

      System.out.println(array[queue.peekLast()]);

      while (!queue.isEmpty() && queue.getFirst() <= i-k){
        queue.removeLast();
      }

      while(!queue.isEmpty()&&array[i] >= array[queue.peekLast()]){
        queue.removeLast();
      }

      queue.addLast(i);


    }




  }


  public void nextGreaterElement(int[] array){


    int lastSeenMax = array[array.length-1];

    int i,j;

    for(i=array.length-2 ; i>=0;i--){

      if(array[i] < lastSeenMax){
        break;
      }

    }

    for( j=array.length-1;j>=0;j--){
      if(array[j] > array[i]){
        break;
      }
    }

    swap(array,i,j);

    reverse(array,i+1);



  }

  public void reverse(int[] array, int i){

  }


  public void swap(int[] array, int j, int i){

  }


  public void knapSack(int[] w , int[] v , int weight){
      Map<Integer,Integer> cache = new HashMap<>();
      knapSackhler(w,v,weight,v.length-1,cache);
  }


  public int knapSackhler(int[] w , int[] v , int weight , int n,Map<Integer,Integer> cache){

    if(weight==0 || n==0){
      return 0;
    }

    if(w[n-1]>weight){
     return knapSackhler(w,v,weight,n-1,cache);
    }

    return Math.max(v[n-1]+ knapSackhler(w,v,weight-w[n-1],n-1,cache),
        knapSackhler(w,v,weight,n-1,cache));

  }


  public void buildSeq(String one , String two){
    int[][] temp  =new int[one.length()+1][two.length()+1];

    int index = temp[one.length()][two.length()];

    char[] common = new char[index];
    int i = one.length();
    int j = two.length();
    while (i>0 && j>0){

      if(one.charAt(i-1)==two.charAt(j-1)){
        common[index] = one.charAt(i-1);
        i--;
        j--;
      }

      else if(temp[i-1][j] > temp[i][j-1]){
        i--;
      }else {
        j--;
      }


    }

    String.valueOf(common);


  }



  public void knapSackTwo(int[] w, int[] v , int weight){

  }


  public int kanpSackHelper(int[] w, int[] v, int weight , int count,int[][] cache){

    if(weight==0 || count==0){
      cache[weight][count] = 0;
      return 0;
    }

    if(w[count-1]>weight){
   //   cache[weight][count-2] = kanpSackHelper()
    }




    return -1;


  }


  public void sumInCircularArray(int[] array){

    int sum = kadane(array);

    int wrppinarpund = 0;

    for(int i=0; i<array.length;i++){
      wrppinarpund+=array[i];
      array[i] = -array[i];
    }

    int kandes = kadane(array);

    wrppinarpund+=kandes;

    System.out.println(wrppinarpund< sum?sum:wrppinarpund);




  }



  public int kadane(int[] maxSum){

    int maxSofar = maxSum[0];
    int maxEndingHere = 0;

    for(int i=1;i<maxSum.length;i++){

      maxEndingHere = maxEndingHere+ maxSum[i];

      if(maxEndingHere <0){
        maxEndingHere = 0;
      }

      if(maxSofar < maxEndingHere){
        maxSofar = maxEndingHere;
      }


    }

    return maxSofar;

  }


  public void diskStackingProblem(ArrayList<Integer[]> disks){

    disks.sort((disk1,disk2)->disk1[2]-disk2[2]);

    int[] heights = new int[disks.size()];
    int[] seqs = new int[disks.size()];

    Arrays.fill(seqs,-1);

    for(int i=0; i<heights.length;i++){
      heights[i] = disks.get(i)[2];
    }

    int maxHeightSoFar = 0;
    int maxIndex = -1;

    for(int i=0;i<disks.size();i++){

      Integer[] currentDisk = disks.get(i);

      for(int j=0; j<i;j++){

        Integer[] otherDisk = disks.get(j);

        if(otherDisk[0] < currentDisk[0] && otherDisk[1] < currentDisk[1] && otherDisk[2] < currentDisk[2]){

          if(heights[i] < currentDisk[2]+heights[j])
          heights[i] = currentDisk[2]+heights[j];
          seqs[i] = j;
        }


      }

      if(maxHeightSoFar < heights[i]){
        maxHeightSoFar = heights[i];
        maxIndex = i;
      }

    }




  }


  public void buildSeqs(int[] seqs , int maxIndex ,  ArrayList<Integer[]> array){

    ArrayList<Integer[]> result = new ArrayList<>();

    int index = maxIndex;

    while(index!=-1){
      result.add(0,array.get(index));
      index = seqs[index];
    }




  }


  public void maxKTransWithProfit(int[] array , int k){

    int[][] profits =  new int[k+1][array.length];

    for(int i=1; i<=k ;i++){

      int maxSofar = Integer.MIN_VALUE;
      for(int j=1; j<array.length;j++){

        maxSofar = Math.max(maxSofar,profits[i-1][j-1]-array[j-1]);
        profits[i][j] = Math.max(profits[i][j-1],array[j]+maxSofar);





      }


    }




  }



  public void mergeIntervals(int[][] arrays){

    List<Interval> intervalList = new ArrayList<>();

    for(int[] array : arrays){
      intervalList.add(new Interval(array[0],array[1]));
    }

    Collections.sort(intervalList);

    Stack<Interval> stack = new Stack<>();

    for(int i=1 ; i< intervalList.size(); i++){

      Interval top = stack.peek();

      if(top.end < intervalList.get(i).start){
        stack.push(intervalList.get(i));
      }

      else if(top.end < intervalList.get(i).end){
        top.end = intervalList.get(i).end;
        stack.pop();
        stack.push(top);
      }


    }






  }

  class Interval implements Comparable<Interval>{

    public int start;
    public int end;

    Interval(int start , int end){
        this.start = start;
        this.end = end;
    }

    public int compareTo(Interval interval){

      if(this.start > interval.start){
        return 1;
      } else if(this.start < interval.start){
        return -1;
      }else {
        return 0;
      }

    }


  }


  public void psblDecodingsOfaString(char[] s){


    int[] countArray = new int[s.length+1];

    if(s[0]=='0'){
      return;
    }

    countArray[0] = 1;
    countArray[1] = 1;

    for(int i=2;i<=s.length;i++){

      if(s[i-1]>'0'){
        countArray[i] = countArray[i-1];
      }

      if((s[i-2]=='1' || s[i-2]=='2') && (s[i-1]) <
          '7'){
        countArray[i]+=countArray[i-2];
      }



    }

    System.out.print(countArray[s.length]);

  }


  public void smallPalnidrum(String s){

    String reverser = reverse(s);

    int remove = buildPattern(s);

    String finalString = reverser.substring(0,reverser.length()-remove);

    System.out.print(finalString+s);



  }


  public String reverse(String s){

    StringBuilder sb = new StringBuilder(s);

    sb.reverse();

    return sb.toString();


  }


  public int buildPattern(String input) {

    int[] pattern = new int[input.length()];

    Arrays.fill(pattern,-1);

    int i=1;
    int j=0;

    while(i<input.length()){

      if(input.charAt(i)== input.charAt(j)){

        pattern[i] = j;
        i++;
        j++;


      }else if(j >0){

        j= pattern[j-1]+1;

      } else {
        i++;
      }

    }

    return pattern[input.length()-1];

  }

  public static int[] buildPattern2(String input){

    int[] pattern = new int[input.length()];
    int i=1;
    int j=0;

    Arrays.fill(pattern,-1);

    while(i<input.length()){
      if(input.charAt(i)==input.charAt(j)){
        pattern[i] = j;
        i++;
        j++;
      } else if(j >0){
        j = pattern[j-1]+1;
      } else{
        i++;
      }
    }
    return pattern;

  }


  public static void maxProfitInKtrans(int[] array , int k){

    int maxDiff = array[1] - array[0];

    int minElement = array[0];

    for(int i=01; i< array.length;i++){

      if(array[i] - minElement > maxDiff){
        maxDiff = array[i] - minElement;
      }

      if(minElement < array[i]){
        minElement = array[i];
      }


    }



  }


}
