package com.company;

public class Card {
    String name;
    String type;
    int cost;
    int owner;
    Boolean used;
    int id;
    String description;

    public Card(String name, int cost, String type, String description, int id, Boolean used, int owner) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.owner = owner;
        this.used = used;
        this.id = id;
        this.description = description;

        System.out.println("Adding " + name + " to " + type + " deck with energy cost " + cost + " and unique ID " + id);
        //System.out.println(description);
    }

    public void setName(String name){
        this.name = name;
        System.out.println(name);
    }

    public void setOwner(int owner){
        this.owner = owner;
        this.name = name;
        System.out.println(name + " has been purchased by player " + owner);
    }

    public void setCost(int cost){
        this.cost = cost;
        System.out.println(name + " costs " + cost + " energy to use");
    }

    public void setUsed(Boolean used){
        this.used = used;
        if (used==true){
            System.out.println(name + " has been used");
        }
    }

    @Override
    public String toString () {
        return "Name=" + name + ", Cost=" + cost + ", Owner=" + owner + ", Type=" + type;
    }
}
