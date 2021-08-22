package com.company;

import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;
public class TerritoryFileReader
{
    public static List<String> readFileInList(String fileName)
    {
        //Create a List of Strings since we don't know how many Strings to expect
        //Place into this list every line of the input file
        List<String> lines = Collections.emptyList();
        try
        {
            lines = Files.readAllLines(Paths.get(String.valueOf(fileName)), StandardCharsets.UTF_8);
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
        return lines;
    }
    public Territory extractTerritoryInfo(String filePath)
    {
        List l = readFileInList(filePath);
        Iterator<String> itr = l.iterator();
        List<String> territoryInfo = new ArrayList<>();
        while (itr.hasNext()) {
            territoryInfo.add(itr.next());
        }
        String name = territoryInfo.get(0);
        String type = territoryInfo.get(1);
        String adjacencies = territoryInfo.get(2);
        String continent = territoryInfo.get(3);
        Boolean nukedStatus = false;
        int owner = 0;
        int mods = 1;
        Boolean diplomat = false;
        Boolean landCommander = false;
        Boolean navalCommander = false;
        Boolean nuclearCommander = false;
        Boolean spaceCommander = false;
        Boolean spaceStation = false;

        Territory territory = new Territory(name,type,adjacencies,continent,nukedStatus,owner,mods,diplomat,landCommander,navalCommander,nuclearCommander,spaceCommander,spaceStation);

        //System.out.println(name + " is a " + type + " territory in the continent of " + continent + " which borders " + adjacencies);
        return territory;
    }

}

