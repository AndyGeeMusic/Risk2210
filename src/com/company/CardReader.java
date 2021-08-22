package com.company;

import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;
public class CardReader
{
    public static ArrayList<Card> extractCardInfo(String fileName)
    {
        //For every line in the file, split the line by tab and put each element into a different object.
        //Then add a unique identifier for that card.
        CountLinesInFile lineCounter = new CountLinesInFile();
        Long linesInFile = lineCounter.getLinesInFile(fileName);
        System.out.println("There are " + linesInFile + " cards in " + fileName);
            String line = "";
            int lineNumber;
            ArrayList<Card> cardList = new ArrayList<Card>();
            try {
                FileReader readfile = new FileReader(fileName);
                BufferedReader readbuffer = new BufferedReader(readfile);
                for (lineNumber = 1; lineNumber <= linesInFile; lineNumber++) {
                    line = readbuffer.readLine();
                    String[] lineSplit = line.split("\t");
                    String name = lineSplit[0];
                    int cost = Integer.parseInt(lineSplit[1]);
                    String type = lineSplit[2];
                    String description = lineSplit[3];
                    int id = lineNumber;
                    Boolean used = false;
                    int owner = 0;
                    Card card = new Card(name, cost, type, description, id, used, owner);
                    cardList.add(card);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        return cardList;
    }
}

