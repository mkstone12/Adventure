package com.company;

public class Item_Weapon extends Item {
    private Item_Weapon(String name, String longName, int weight) {
        super(name, longName, weight);
    }
    private int weaponDamage;

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }
    public int usesLeft(){

        }
    }
}
