package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //Read number of players - must only accept an integer between 2 and 5
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = 0;
        do {
            System.out.print("Please enter a number of players between 2 and 5: ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            numberOfPlayers = scanner.nextInt();
        }
        while (numberOfPlayers<2 || numberOfPlayers > 5);
        System.out.println("There are " + numberOfPlayers + " players.");


        //Create object for each player
        scanner.nextLine();
        List <Player> listOfPlayers = new ArrayList<>();
        for (int x=1; x<numberOfPlayers+1; x++){
            String playerName ="";
            while (playerName.isEmpty()) {
                System.out.println("Enter name of player " + x);
                playerName = scanner.nextLine();  // Read user input
            }

            //Initialise each player with 3 energy
            Player player = new Player();
            player.setName(playerName);
            player.setEnergy(3);
            player.setPlayerNumber(x);
            listOfPlayers.add(player);
            System.out.println("Player " + x + " has been created with name " + playerName);
        }

        //Decrement a player's energy
        List<Player> result = listOfPlayers.stream().filter(item -> item.playerNumber==2).collect(Collectors.toList());
        result.get(0).setEnergy(result.get(0).getEnergy() - 1);

        //Buy a naval commander
        listOfPlayers.get(0).buyCommander("Naval");

        //Read each territory text file into a list of Territory objects
        File directoryPath = new File("C:\\Users\\andre\\IdeaProjects\\Risk2210\\src\\com\\company\\Territories");
        File filesList[] = directoryPath.listFiles();
        ArrayList<Territory> territoryList = new ArrayList<Territory>();
        TerritoryFileReader territoryFileReader = new TerritoryFileReader();
        for (int i = 0;i< filesList.length; i++){
            String filePath = filesList[i].getAbsolutePath();
            Territory territory = territoryFileReader.extractTerritoryInfo(filePath);
            territoryList.add(territory);
        }

        System.out.println("There are " + filesList.length + " territories.");

        //Test getting mods from a specific territory
        //territoryList.get(0).getMods();
        //territoryList.get(1).getMods();

        //Read all cards from a tex file into cardList
        System.out.println("Reading card data.");
        CardReader cardReader = new CardReader();
        String fileName = ("C:\\Users\\andre\\IdeaProjects\\Risk2210\\src\\com\\company\\Cards.txt");
        ArrayList<Card> listOfCards = cardReader.extractCardInfo(fileName);

        //Roll some dice
        Dice die = new Dice();
        die.roll(1,2,0,3,2,0);

        //Trying to make a list of unique IDs for every card in the decks
        //List<Integer> allDiplomatCardIndices = listOfCards.stream().indexOf(filter(item -> Objects.equals(item.type, "Diplomat"))).collect(Collectors.toList());
        //List<Integer> allDiplomatCardIndices = listOfCards.stream().filter(item -> Objects.equals(item.type, "Diplomat")).collect(Collectors.toList()).indexOf(listOfCards);
        //List<Integer> allDiplomatCardIndices = indexOf(listOfCards.stream().filter(item -> Objects.equals(item.type, "Diplomat"))).collect(Collectors.toList());
        // List<Integer> allDiplomatCardNumbers = listOfCards.stream().filter(item -> Objects.equals(item.type, "Diplomat")).map(item -> item.id).collect(Collectors.toList());
        List<Integer> allDiplomatCardNumbers = listOfCards.stream().filter(item -> Objects.equals(item.type, "Diplomat")).map(item -> item.id).collect(Collectors.toList());
        System.out.println(allDiplomatCardNumbers);

        List<Card> unownedLandCards = listOfCards.stream().filter(item -> Objects.equals(item.type, "Land") && item.owner == 0).collect(Collectors.toList());
        List<Card> unownedNavalCards = listOfCards.stream().filter(item -> Objects.equals(item.type, "Naval") && item.owner == 0).collect(Collectors.toList());
        List<Card> unownedNuclearCards = listOfCards.stream().filter(item -> Objects.equals(item.type, "Nuclear") && item.owner == 0).collect(Collectors.toList());
        List<Card> unownedSpaceCards = listOfCards.stream().filter(item -> Objects.equals(item.type, "Space") && item.owner == 0).collect(Collectors.toList());

        System.out.println(unownedLandCards);

        //Buy an unowned command card from the Diplomat deck
        //Create a list containing unowned Diplomat cards
        //Randomly choose one of these and set its value to the purchasing player
        List<Card> unownedDiplomatCards = listOfCards.stream().filter(item -> Objects.equals(item.type, "Diplomat") && item.owner == 0).collect(Collectors.toList());
        int min = 1;
        int max = unownedDiplomatCards.size();
        System.out.println("There are " + max + " cards remaining in the Diplomat deck.");
        int randomNumber = (int)Math.floor(Math.random()*(max-min+1)+min);

        //Begin the game
        int currentTurn = 1;

        //Decide turn order
        System.out.println("It is now turn 1.  Enter your bid to go first.");

    }
}
