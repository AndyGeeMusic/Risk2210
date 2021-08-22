package com.company;

public class Territory {
    String name;
    String type;
    String continent;
    String adjacencies;
    Boolean nukedStatus;
    int owner = 1;
    int mods = 1;
    Boolean diplomat = false;
    Boolean landCommander = false;
    Boolean navalCommander = false;
    Boolean nuclearCommander = false;
    Boolean spaceCommander = false;
    Boolean spaceStation = false;

    public Territory(String name, String type, String adjacencies, String continent,Boolean nukedStatus, int owner, int mods, Boolean diplomat, Boolean landCommander, Boolean navalCommander, Boolean nuclearCommander, Boolean spaceCommander, Boolean spaceStation) {
        this.name = name;
        this.type = type;
        this.adjacencies = adjacencies;
        this.continent = continent;
        this.nukedStatus = nukedStatus;
        this.owner = owner;
        this.mods = mods;
        this.diplomat = diplomat;
        this.landCommander = landCommander;
        this.navalCommander = navalCommander;
        this.nuclearCommander = nuclearCommander;
        this.spaceCommander = spaceCommander;
        this.spaceStation = spaceStation;

        System.out.println("The " + type + " territory of " + name + " in continent " + continent + " has now been created.");
    }

    public void setNukedStatus(Boolean nukedStatus){
        this.nukedStatus=nukedStatus;
        System.out.println(name + " has now been nuked.");
    }

    public void getNukedStatus(){
        if (nukedStatus==true){
            System.out.println(name + " is a nuked territory");
        }
        else{
            System.out.println(name + " is not a nuked territory");
        }
        System.out.println(name + " has now been nuked.");
    }

    public void getDiplomat(){
        this.diplomat=diplomat;
        System.out.println(name + " contains a diplomat owned by player " + owner);
    }

    public void getLandCommander(){
        this.landCommander=landCommander;
        System.out.println(name + " contains a land commander owned by player " + owner);
    }

    public void getNavalCommander(){
        this.navalCommander=navalCommander;
        System.out.println(name + " contains a naval commander owned by player " + owner);
    }

    public void getNuclearCommander(){
        this.nuclearCommander=nuclearCommander;
        System.out.println(name + " contains a nuclear commander owned by player " + owner);
    }

    public void getSpaceCommander(){
        this.spaceCommander=spaceCommander;
        System.out.println(name + " contains a naval commander owned by player " + owner);
    }

    public void getSpaceStation(){
        this.spaceStation=spaceStation;
        System.out.println(name + " contains a space station owned by player " + owner);
    }

    public void setMods(int owner, int mods){
        this.mods=mods;
        System.out.println("Player " + owner + " now has " + mods + " mods in " + name);
    }

    public void getMods(){
            System.out.println(name + " contains " + mods + " MODs.");
    }

    public void setDiplomat(int owner, Boolean diplomat){
        this.diplomat=diplomat;
        if (diplomat==true){
            System.out.println("Player " + owner + " now has a diplomat in " + name);
        }
        else{
            System.out.println("Player " + owner + " now has no diplomat in " + name);
        }
    }

    public void setLandCommander(int owner, Boolean landCommander){
        this.landCommander=landCommander;
        if (landCommander==true){
            System.out.println("Player " + owner + " now has a land commander in " + name);
        }
        else{
            System.out.println("Player " + owner + " now has no land commander in " + name);
        }
    }

    public void setNavalCommander(int owner, Boolean navalCommander){
        this.navalCommander=navalCommander;
        if (landCommander==true){
            System.out.println("Player " + owner + " now has a land commander in " + name);
        }
        else{
            System.out.println("Player " + owner + " now has no land commander in " + name);
        }
    }

    public void setNuclearCommander(int owner, Boolean nuclearCommander){
        this.nuclearCommander=nuclearCommander;
        if (nuclearCommander==true){
            System.out.println("Player " + owner + " now has a nuclear commander in " + name);
        }
        else{
            System.out.println("Player " + owner + " now has no nuclear commander in " + name);
        }
    }

    public void setSpaceCommander(int owner, Boolean spaceCommander){
        this.spaceCommander=spaceCommander;
        if (spaceCommander==true){
            System.out.println("Player " + owner + " now has a space commander in " + name);
        }
        else{
            System.out.println("Player " + owner + " now has no space commander in " + name);
        }
    }

    public void setSpaceStation(int owner, Boolean spaceStation){
        this.spaceStation=spaceStation;
        if (spaceStation==true){
            System.out.println("Player " + owner + " now has a space station in " + name);
        }
        else{
            System.out.println("Player " + owner + " now has no space station in " + name);
        }
    }
}

