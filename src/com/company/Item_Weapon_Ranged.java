package com.company;

public class Item_Weapon_Ranged extends Item_Weapon {
    private int uses;

    public Item_Weapon_Ranged(String name, String longName, int weight,int weaponDamage, int uses){
        super(name,longName,weight,weaponDamage);
        this.uses = uses;
    }

    public int usesLeft(){
        return uses;
    }
    public void useAmmo(){
       uses = uses-1;
    }





}
