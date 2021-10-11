package com.company;

import java.util.ArrayList;

public class Room {

    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private Room down;
    private Room up;
    private String name;
    private String roomDesc;
    private ArrayList<Item> items = new ArrayList<>();

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
        room.east = this;
    }

    public void setDown(Room room){
        down = room;
        room.up = this;
    }
    public void setUp(Room room){
        up = room;
        room.down = this;
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

    public Room getDown(){
        return down;
    }

    public Room getUp(){
        return up;
    }
    public String getRoomDesc(){
        return roomDesc;
    }
    public void setRoomDesc(String roomDesc){
        this.roomDesc = roomDesc;
    }

    public void addNewItem(String name, String longName,int weight){
        Item item = new Item(name,longName,weight);
        items.add(item);
    }

    public void addFood(String name, String longName, int weight, int hpReg ){
        Food food = new Food(name,longName,weight,hpReg);
        items.add(food);
    }


    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(String name){
        for (int i=0; i < items.size();i++){
            if (items.get(i).getName().equals(name)){
                items.remove(i);
    }}}


    public ArrayList<String> getAllItems() {
        ArrayList<String> stringItems = new ArrayList<>();

        for (int i = 0; i < items.size(); i++){
            stringItems.add(items.get(i).getName());
        }

        return stringItems;
    }

    public ArrayList<String> getAllItemLong() {
        ArrayList<String> stringItems = new ArrayList<>();
        for (int i = 0; i < items.size(); i++){
            stringItems.add(items.get(i).getLongName()) ;;
        }

        return stringItems;
    }

    public ArrayList<Item> getItemArrayList(){
        return items;
    }

    public Item getItem(String itemName){
        Item item = null;
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getName().equals(itemName)){
            item = items.get(i);
            }
        }
        return item;
    }

}

