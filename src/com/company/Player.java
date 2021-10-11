package com.company;

import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> items = new ArrayList<>();
    private final int maxWeight = 100;
    private int HP = 50;
    private boolean itemEquiped = false;
    private Item_Weapon weaponEquiped;


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
    public void equipWeapon(Item weapon){
        for (int i=0; i < items.size();i++){
            if (items.get(i).getName().equals(weapon.name)){
                weaponEquiped = (Item_Weapon) weapon;
                itemEquiped = true;
                System.out.println("You have equipped "+weaponEquiped.getName()+".");
            }
            else {
                System.out.println("You do not have that item in your inventory");
            }
        }
    }
    public void unequipWeapon(Item_Weapon weapon, Item_Weapon weaponEquiped){
        for (int i=0; i < items.size();i++){
            if (items.get(i).getName().equals(weaponEquiped.name)){
                System.out.println("You have unequipped "+weaponEquiped+".");
                weaponEquiped = null;
                itemEquiped = false;
            } else {
                System.out.println("You do not have that item equipped");}
    }}


    public void dropItem(String name){
        for (int i=0; i < items.size();i++){
            if(items.get(i) == weaponEquiped){
                unequipWeapon((Item_Weapon) items.get(i), weaponEquiped);
            }
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

    public void regHp (int hpReg){
        HP += hpReg;
    }

    public void takeDmg (int dmg){
        HP -= dmg;
    }
    public int getHP (){
        return HP;
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

    public String getWeaponEquiped(){
        return weaponEquiped.getName();
    }
    public boolean isItemEquiped(){
        return itemEquiped;
    }

}



