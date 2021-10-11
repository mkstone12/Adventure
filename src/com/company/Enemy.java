package com.company;

public class Enemy {
    private String enemyName;
    private int enemyHealth;
    private int attackDamage;

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void setHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public void setName(String name) {
        this.enemyName = enemyName;
    }

    public String enemyAttack(int attackDamage, int playerHealth, String enemyName){
        playerHealth = playerHealth - attackDamage;
        return enemyName+" attacked you!\nYou are at "+playerHealth+" health";
    }}

