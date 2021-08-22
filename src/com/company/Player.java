package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private static String name;
    int energy;
    int playerNumber;
    int spaceStations;
    Boolean diplomat = true;
    Boolean landCommander = true;
    Boolean navalCommander = false;
    Boolean nuclearCommander = false;
    Boolean spaceCommander = false;
    File directoryPath = new File("C:\\Users\\andre\\IdeaProjects\\Risk2210\\src\\com\\company\\Cards.txt");
    long totalNumberOfCards = countLineBufferedReader("C:\\Users\\andre\\IdeaProjects\\Risk2210\\src\\com\\company\\Cards.txt");
    List<String> cards=new ArrayList<String>();
    List<String> territories=new ArrayList<String>();
    private int costToUse;
    //String cardToAdd;
    //String cardToUse;

    public static long countLineBufferedReader(String fileName) {

        long lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) lines++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void setName(String name){
        this.name = name;
        System.out.println(name);
    }

    public void setPlayerNumber(int playerNumber){
        this.playerNumber = playerNumber;
        this.name = name;
        System.out.println(name + " has been assigned player number " + playerNumber);
    }

    public void setEnergy(int energy){
        this.energy = energy;
        System.out.println("Player " + playerNumber + " now has " + energy + " energy");
    }

    public void buyCards( String cardToBuy){
        this.cards = cards;
        this.name = name;
        this.energy = energy;
        if (energy <1){
            System.out.println("You cannot afford to buy a card.");
        }
        else{
            energy--;
            cards.add(cardToBuy);
            System.out.println("Added " + cardToBuy + " to the hand");
        }
        System.out.println("Your hand is now " + cards + " and you now have " + energy + " energy");

    }

    public void buyCommander(String commanderType) {
        //Is there enough energy to buy a commander
        this.energy = energy;
        if (energy >= 3) {
            switch (commanderType) {
                case "Diplomat":
                    if (diplomat) {
                        System.out.println("You already own a " + commanderType + ".");
                    }
                    else {
                        energy = energy - 3;
                        System.out.println("Player " + playerNumber + " has purchased a " + commanderType + ".  You now have " + energy + " energy.");
                        diplomat = true;
                        System.out.println("Where would you like to place your " + commanderType + "?");
                        //Some update to add commander to the board
                    }
                    break;
                case "Land":
                    if (landCommander) {
                        System.out.println("You already own a " + commanderType + " land commander.");
                    }
                    else {
                        energy = energy - 3;
                        System.out.println("You have purchased a " + commanderType + " commander.  You now have " + energy + " energy.");
                        landCommander = true;
                        System.out.println("Where would you like to place your " + commanderType + " commander?");
                        //Some update to add commander to the board
                    }
                    break;
                case "Naval":
                    if (navalCommander) {
                        System.out.println("You already own a " + commanderType + " commander.");
                    }
                    else {
                        energy = energy - 3;
                        System.out.println("You have purchased a " + commanderType + " commander.  You now have " + energy + " energy.");
                        navalCommander = true;
                        System.out.println("Where would you like to place your " + commanderType + " commander?");
                        //Some update to add commander to the board
                    }
                    break;
                case "Nuclear":
                    if (nuclearCommander) {
                        System.out.println("You already own a " + commanderType + " commander.");
                    }
                    else {
                        energy = energy - 3;
                        System.out.println("You have purchased a " + commanderType + " commander.  You now have " + energy + " energy.");
                        nuclearCommander = true;
                        System.out.println("Where would you like to place your " + commanderType + " commander?");
                        //Some update to add commander to the board
                    }
                    break;
                case "Space":
                    if (spaceCommander) {
                        System.out.println("You already own a " + commanderType + " commander.");
                    }
                    else {
                        energy = energy - 3;
                        System.out.println("You have purchased a " + commanderType + " commander.  You now have " + energy + " energy.");
                        spaceCommander = true;
                        System.out.println("Where would you like to place your " + commanderType + " commander?");
                        //Some update to add commander to the board
                    }
                    break;
            }
        }
        else {
            System.out.println("You do not have enough energy to buy a commander.  You have only " + energy + "energy");
        }
    }

    public void useCards(String cardToUse, int costToUse){
        this.cards = cards;
        this.costToUse = costToUse;
        cards.remove(cardToUse);
        System.out.println("Used " + cardToUse + " at a cost of " + energy);
        System.out.println("New hand is " + cards);
    }

    public void setTerritories(List<String> territories){
        this.territories = territories;
        System.out.println(territories);
    }

    public String getName() {
        return this.name;
    }

    public List<String> getCards(){
        return this.cards;
    }

    public int getEnergy() {
        return this.energy;
    }

    public List<String> getTerritories(){
        return this.territories;
    }

}
