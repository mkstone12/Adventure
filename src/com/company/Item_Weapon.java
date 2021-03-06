package com.company;

public abstract class Item_Weapon extends Item {
    protected int weaponDamage;

    public Item_Weapon(String name, String longName, int weight, int weaponDamage) {
        super(name, longName, weight);
        this.weaponDamage = weaponDamage;
    }

    public abstract int usesLeft();

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
}


