package com.company;

public class Enemy {
    private String enemyName;
    private int enemyHealth;
    private Item_Weapon weapon;

    public Enemy(String enemyName, int enemyHealth, Item_Weapon weapon){
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
        this.weapon = weapon;
    }

    public Item_Weapon getWeapon(){
        return weapon;
    }

    public int getEnemyHealth(){
        return enemyHealth;
    }

    public String getEnemyName(){
        return enemyName;
    }

    public void takeDmg (int dmg){
        enemyHealth -= dmg;
    }
}


