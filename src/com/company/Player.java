package com.company;

import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> items = new ArrayList<>();
    private final int maxWeight = 100;
    private int HP = 50;
    private boolean itemEquiped = false;
    private Item weaponEquiped;


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
                if(weapon instanceof Item_Weapon){
                weaponEquiped = weapon;
                itemEquiped = true;
                System.out.println("You have equipped "+weaponEquiped.getName()+".");
            }}
            else if (i == items.size()-1){
                System.out.println("You do not have that item in your inventory or this is not a weapon");
            }
        }
    }
    public void unequipWeapon(String weapon){
        for (int i=0; i < items.size();i++){
            if (weapon.equals(weaponEquiped.name)){
                System.out.println("You have unequipped "+weaponEquiped.getName()+".");
                weaponEquiped = null;
                itemEquiped = false;
            } else {
                System.out.println("You do not have that item equipped");}
    }}


    public void dropItem(String name){
        for (int i=0; i < items.size();i++){
            if (items.get(i).getName().equals(name)){
                String item = items.get(i).getName();
                currentRoom.addItem(items.get(i));
                System.out.println("You have dropped the " + items.get(i).getName());
                if(itemEquiped == true){
                    if(item.equals(weaponEquiped.getName())){
                        unequipWeapon(item);
                    }}
                items.remove(i);
            }}}


    public ArrayList<Item> getPlayerItems() {
        ArrayList<Item> stringItems = new ArrayList<>();
        for (int i = 0; i < items.size(); i++){
            stringItems.add(items.get(i)) ;
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

    public Item getWeaponEquiped(){
        return weaponEquiped;
    }
    public boolean isItemEquiped(){
        return itemEquiped;
    }}
/*    public int useWeapon(int weaponDamage, int enemyHealth){
        if(itemEquiped == true){
            if(combat == true){
                shoot or sumfin
            }
            else {
                if(weaponEquiped instanceof Item_Weapon_Ranged ){

                    System.out.println("There is no enemy, so you shoot at some air...");

                }else{
                    System.out.println("There is no enemy, so you wack at air...");
                }
            }
        }
        else{
            System.out.println("You have no item equipped...");
        }
    }
}

/*/

