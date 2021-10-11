package com.company;

import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> items = new ArrayList<>();
    private final int maxWeight = 100;
    public int playerHealth = 50;
    private Item_Weapon itemEquiped;


    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }
    public Room getCurrentRoom(){
        return currentRoom;
    }

    public void takeItem(Item item){
        if(getPlayerWeight()+ item.getWeight() < maxWeight){
            items.add(item);
            currentRoom.removeItem(item.getName());
            System.out.println("You have taken the " + item.getName());}
        else{
            System.out.println("You cannot carry anymore");
        }
    }

    public void dropItem(String name){
        for (int i=0; i < items.size();i++){
            if (items.get(i).getName().equals(name)){
                currentRoom.addItem(items.get(i));
                System.out.println("You have dropped the " + items.get(i).getName());
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

    public int getItemWeight(String name){
        int weight = 0;
        for (int i=0; i < items.size();i++){
            if (items.get(i).getName().equals(name)){
                weight = items.get(i).getWeight();
            }}
        return weight;


    }

}

