package com.dailyCodingProblem.algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mshaik on 2/2/19.
 */
public class FamousAlgos {


  public static void main(String args[]){
    FamousAlgos algos = new FamousAlgos();
   // algos.lonesgtCommonSubSeq(Arrays.asList(2,12,30,31));
    longestIncreasingSubsequence(new int[]{29,2,20,12,30,31}).forEach(System.out::println);
  }



  public void underScorifyString(String target , String pattern) {

    if(target==null || target.length()==0) return;

    //Step-1 - Find locations of Pattern






  }


  public ArrayList<Integer[]> findLocations(String target , String pattern){

    ArrayList<Integer[]> arrayList = new ArrayList<>();
    int i=0;
    while (i<target.length()){
      int index = target.indexOf(pattern,i);
      if(index!=-1) {
        Integer[] location = new Integer[2];
        location[0] = index;
        location[1] = index + pattern.length();
        i = index + 1;
        arrayList.add(location);
      }else {
        break;
      }
    }


    return arrayList;



  }

  public ArrayList<Integer[]> collisionOfLocations(ArrayList<Integer[]> locations){

    if(locations.size()==0) return locations;

    ArrayList<Integer[]> finalUnderScroeLocs = new ArrayList<>();

    finalUnderScroeLocs.add(locations.get(0));

    int previousIndex = locations.get(0)[1];

    for(int i=1 ; i< locations.size();i++) {

      Integer[] currentIndex = locations.get(i);

      if (currentIndex[0] <= previousIndex) {
        finalUnderScroeLocs.get(i - 1)[1] = currentIndex[1];
      } else {
        finalUnderScroeLocs.add(currentIndex);
      }
      previousIndex = currentIndex[1];
    }

      return finalUnderScroeLocs;

    }


    public String underScorify(ArrayList<Integer[]> finalLocations, String target){

      List<String> finalStrings = new ArrayList<>();

      int stringInde = 0;
      int locaIndex = 0;
      boolean isBetweenUnder = false;
      int i = 0;

      while(stringInde<target.length()&&locaIndex<finalLocations.size()){

        if(stringInde==finalLocations.get(locaIndex)[i]){

          finalStrings.add("_");
          isBetweenUnder = true;
          i=i==1?0:1;

        }

        if(!isBetweenUnder){
          locaIndex++;
        }


        finalStrings.add(String.valueOf(target.charAt(stringInde)));
        stringInde++;

      }

      if(locaIndex<finalLocations.size()){
        finalStrings.add("_");
      } else if(stringInde < target.length()){
        finalStrings.add(target.substring(stringInde));
      }
        return String.join("",finalStrings);


        }


    public void lonesgtCommonSubSeq(List<Integer> array){

      List<Integer> list = new ArrayList<>();

      int[] lengths = new int[array.size()];
      int[] indexes = new int[array.size()];

      Arrays.fill(lengths,1);
      Arrays.fill(indexes,-1);

      int maxSofar = Integer.MIN_VALUE;
      int maxIndex = -1;

      for(int i=1 ; i< array.size();i++) {

        for (int j = 0; j < i; j++) {

          if (array.get(i) > array.get(j)) {

            if (lengths[i] < lengths[j] + 1) {

              lengths[i] = lengths[j] + 1;
              indexes[i] = j;
            }

          }


        }

        if(maxSofar < lengths[i]){
          maxSofar = lengths[i];
          maxIndex = i;
        }


      }

      int index = maxIndex;
      while(index>=0){
        list.add(array.get(index));
        index = indexes[index];
      }
      list.forEach(System.out::println);

    }


  public static ArrayList<Integer> longestIncreasingSubsequence(int[] array) {

    if(array==null || array.length==0) return new ArrayList<Integer>();

    int[] lengths = new int[array.length];
    int[] seqs = new int[array.length];

    int maxIndexSofar = 0;
    int maxlength = 0;

    Arrays.fill(lengths,1);
    Arrays.fill(seqs,-1);

    for(int i=0 ; i<array.length;i++){

      for(int j=0 ; j<array.length;j++){

        if(array[i]> array[j]&&lengths[i] <= lengths[j]+1){
            lengths[i] = 	lengths[j]+1;
            seqs[i] = j;

        }


      }

      if(maxlength <= lengths[i]){
        maxlength = lengths[i];
        maxIndexSofar = i;
      }

    }

    return buildSeqs(array,seqs,maxIndexSofar);

  }


  public static ArrayList<Integer> buildSeqs(int[] array , int seqs[] , int maxIndex){

    ArrayList<Integer> finalList = new ArrayList<>();
    int index = maxIndex;
    while(index>=0){
      finalList.add(0,array[index]);
      index = seqs[index];
    }
    return finalList;
  }


  public  static ArrayList<Integer[]> diskStacking(ArrayList<Integer[]> disks) {

    disks.sort((disk1,disk2)->disk1[2].compareTo(disk2[2]));

    int[] heights = new int[disks.size()];
    int[] seqs = new int[disks.size()];

    Arrays.fill(seqs,-1);

    int k=0;

    for(Integer[] disk : disks){
      heights[k] = disk[2];
      k++;
    }

    int maxHeigght = 0;
    int maxHeightInd = -1;

    for(int i=1 ; i<disks.size();i++){

      Integer[] currentDisk = disks.get(i);

      for(int j=0; j<i; j++){

        Integer[] otherDisk = disks.get(j);

        if(allDimensionsValid(otherDisk,currentDisk)){

          if(heights[i]<=currentDisk[2]+heights[j]){
            heights[i] = currentDisk[2] + heights[j];
            seqs[i] = j;
          }


        }

      }

      if(maxHeigght < heights[i]){
        maxHeigght = heights[i];
        maxHeightInd = i;
      }


    }

    return buildSeqs(disks,seqs,maxHeightInd);
    // Write your code here.
  }


  public static boolean allDimensionsValid(Integer[] diskOne , Integer[] diskTwo){

    if(diskOne[0] < diskTwo[0] && diskOne[1]<diskTwo[1] && diskOne[2] < diskTwo[2]){
      return true;
    }

    return false;

  }


  public static ArrayList<Integer[]> buildSeqs(ArrayList<Integer[]> array , int seqs[] , int maxHeightInd) {

    int index = maxHeightInd;

    ArrayList<Integer[]> finalResult = new ArrayList<>();

    while(index >=0){

      finalResult.add(array.get(index));
      index = seqs[index];
    }


    return finalResult;


  }


}


// O(n)
//O(nm) o(n(n+m)
