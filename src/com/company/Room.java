package com.company;

public class Room {

    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private String name;

    public Room(Room north, Room south, Room east, Room west, String name){
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setNorth(Room room){
        north = room;
    }
    public void setSouth(Room room){
        south = room;
    }
    public void setEast(Room room){
        east = room;
    }
    public void setWest(Room room){
        west = room;
    }
    public Room getNorth(){
        return north;
    }
    public Room getSouth(){
        return south;
    }
    public Room getEast(){
        return east;
    }
    public Room getWest(){
        return west;
    }
}

