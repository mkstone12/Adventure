package com.company;

public class Room {

    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private String name;
    private String roomDesc;

    public Room(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setNorth(Room room){
        north = room;
        room.south = this;
    }
    public void setSouth(Room room){
        south = room;
        room.north = this;
    }
    public void setEast(Room room){
        east = room;
        room.west = this;
    }
    public void setWest(Room room){
        west = room;
        room.west = this;
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
    public String getRoomDesc(){
        return roomDesc;
    }
    public void setRoomDesc(String roomDesc){
        this.roomDesc = roomDesc;
    }
}

