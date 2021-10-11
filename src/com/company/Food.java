package com.company;

public class Food extends Item{
    private int hpReg;

    public Food(String name, String longName, int weight, int hpReg) {
        super(name, longName, weight);
        this.hpReg = hpReg;
    }

    public int getHpReg(){
        return hpReg;
    }


}
