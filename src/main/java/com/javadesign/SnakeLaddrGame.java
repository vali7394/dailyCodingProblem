package com.javadesign;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by mshaik on 3/4/19.
 */
public class SnakeLaddrGame {

  static int WIN_POINT = 100;
  static Map<Integer,Integer> snake = new HashMap<>();
  static Map<Integer,Integer> ladder = new HashMap<>();

   {

    snake.put(99,54);
    snake.put(70,55);
    snake.put(52,42);
    snake.put(25,2);
    snake.put(95,72);

    ladder.put(6,25);
    ladder.put(11,40);
    ladder.put(60,85);
    ladder.put(46,90);
    ladder.put(17,69);

  }



  public int getDiceValue(){

     int dice = 0;

     Random rn = new Random();
     dice = rn.nextInt(7);

     return dice==0?1:dice;


  }


  public int getPlayerPos(int player , int dice){
    player = player+dice;
    if(player > WIN_POINT){
      return player-dice;
    }
     else if(snake!=null && snake.containsKey(player)){
      System.out.println("Snake has swolled you at " + player);
      return snake.get(player);
    }
    else if(ladder!=null && ladder.containsKey(player)) {
      System.out.println("Used  Ladder  at " + player);
       return ladder.get(player);
    }

    return player;

  }


  public boolean isWin(int player){
    return WIN_POINT==player;
  }


  public void startGame(){

    String exit = "c";
    String value;

    int currentPlayer =-1;

    int p1 =0;
    int p2=0;

    Scanner scanner = new Scanner(System.in);
    int position = 0;

    do{

      value = scanner.next();
      int dice = getDiceValue();

      if(currentPlayer==-1){

        System.out.println("Player One has to roll the dice");

       p1= getPlayerPos(p1,dice);

        if(isWin(p1)){
          System.out.println("Player 1 has won");
          return;
        }

        System.out.println("Player one position " +p1);


      } else {

        System.out.println("Player two has to roll the dice");
        p2= getPlayerPos(p2,dice);

        if(isWin(p2)){
          System.out.println("Player 2 has won");
          return;
        }


        System.out.println("Player two position" + p2);



      }
      currentPlayer = -currentPlayer;

    } while (exit.equalsIgnoreCase(value));







  }



  public static void main(String[] args){
    SnakeLaddrGame laddrGame = new SnakeLaddrGame();
    laddrGame.startGame();
  }

}
