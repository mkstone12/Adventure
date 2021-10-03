package com.company;

public class Item {
    private String name;
    private String longName;

    public Item(String name, String longName){
        this.name = name;
        this.longName = longName;
    }
    public Item(String name){
        this.name = name;
        longName = null;
    }

    public String getName(){
        return name;
    }
    public  String getLongName(){
        return longName;
    }


}
