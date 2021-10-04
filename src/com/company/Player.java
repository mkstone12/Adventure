package com.company;

import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> items = new ArrayList<>();
    private int maxWeight;

    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }
    public Room getCurrentRoom(){
        return currentRoom;
    }

    public void takeItem(String name){
        Item item = new Item(name);
        items.add(item);
        currentRoom.removeItem(name);
    }

    public void dropItem(String name){
        for (int i=0; i < items.size();i++){
            if (items.get(i).getName().equals(name)){
                currentRoom.addItem(items.get(i));
                items.remove(i);
    }}}


    public ArrayList<String> getPlayerItems() {
        ArrayList<String> stringItems = new ArrayList<>();
        for (int i = 0; i < items.size(); i++){
            stringItems.add(items.get(i).getName()) ;
        }

        return stringItems;
    }

    public int getPlayerWeight(){
        int playerWeight = 0;
        for (int i = 0; i <items.size();i++){
            playerWeight += items.get(i).getWeight();
        }

        return playerWeight;
    }

}

