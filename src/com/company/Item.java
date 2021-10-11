package com.company;

public class Item {
    protected String name;
    protected String longName;
    protected int weight;

    public Item(String name, String longName, int weight){
        this.name = name;
        this.longName = longName;
        this.weight = weight;
    }

    public String getName(){
        return name;
    }
    public  String getLongName(){
        return longName;
    }
    public int getWeight(){
        return weight;
    }



}
