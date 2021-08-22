package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Dice {
    //Only 6 sided vs 6 sided
    public void roll(int attackingPlayer, int defendingPlayer, int attackingSixes, int attackingEights, int defendingSixes, int defendingEights){
        //Create int arrays to hold attacking and defending results
        int defenderLosses=0;
        int attackerLosses=0;
        Integer[] attackingResult = new Integer[attackingSixes+attackingEights];
        Integer[] defendingResult = new Integer[defendingSixes+defendingEights];
        Random random = new Random();

        //Populate attacking results
        int x=0;
        for (int i=x;i<attackingSixes;i++){
            attackingResult[i]=random.nextInt(5)+1;
            x++;
            //System.out.println("Six sided die was rolled to get a " + attackingResult[i]);
        }
        for (int i=x;i<attackingSixes+attackingEights;i++){
            attackingResult[i]=random.nextInt(7)+1;
            x++;
            //System.out.println("Eight sided die was rolled to get a " + attackingResult[i]);
        }
        System.out.println("Player " + attackingPlayer + " (attacker) has rolled " + attackingSixes + " six sided dice and " + attackingEights + " eight sided dice.");
        Arrays.sort(attackingResult);
        Arrays.sort(attackingResult, Collections.reverseOrder());
        System.out.println(Arrays.toString(attackingResult));

        //Populate defending results
        x=0;
        for (int i=x;i<defendingSixes;i++){
            defendingResult[i]=random.nextInt(5)+1;
            x++;
            //System.out.println("Six sided die was rolled to get a " + defendingResult[i]);
        }
        for (int i=x;i<defendingSixes+defendingEights;i++){
            defendingResult[i]=random.nextInt(7)+1;
            x++;
            //System.out.println("Eight sided die was rolled to get a " + defendingResult[i]);
        }
        System.out.println("Player " + defendingPlayer + " (defender) has rolled " + defendingSixes + " six sided dice and " + defendingEights + " eight sided dice.");
        Arrays.sort(defendingResult);
        Arrays.sort(defendingResult, Collections.reverseOrder());
        System.out.println(Arrays.toString(defendingResult));

        //Compare the two highest values, then the two second highest values
        for (int i=0;i<2;i++){
            if (attackingResult[i]>defendingResult[i]){
                defenderLosses++;
            }
            else{
                attackerLosses++;
            }
        }
        System.out.println("The attacker has lost " + attackerLosses + " MODs and the defender has lost " + defenderLosses + " MODs");
    }

    public int roll(int playerNumber){
        Random random = new Random();
        int result=random.nextInt(5)+1;
        return result;
    }
}
