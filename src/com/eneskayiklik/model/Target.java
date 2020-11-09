package com.eneskayiklik.model;

public class Target {
    private int dimensionX;
    private int dimensionY;
    private Gold gold;

    public Target(int dimensionX, int dimensionY, Gold gold) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.gold = gold;
    }

    public int getDimensionX() {
        return dimensionX;
    }

    public void setDimensionX(int dimensionX) {
        this.dimensionX = dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    public void setDimensionY(int dimensionY) {
        this.dimensionY = dimensionY;
    }

    public Gold getGold() {
        return gold;
    }

    public void setGold(Gold gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return "{" +
                "targetX=" + this.getDimensionX() +
                "\ntargetY=" + this.getDimensionY() +
                '}';
    }
}
