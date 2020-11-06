package com.eneskayiklik.model;

public class Player {
    private final char name;
    private int goldAmount;
    private int dimensionX;
    private int dimensionY;

    public Player(char name, int goldAmount, int dimensionX, int dimensionY) {
        this.name = name;
        this.goldAmount = goldAmount;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
    }

    public int getGoldAmount() {
        return goldAmount;
    }

    public void setGoldAmount(int goldAmount) {
        this.goldAmount = goldAmount;
    }

    public char getName() {
        return name;
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

    @Override
    public String toString() {
        return "Name -> " + this.name + " Dimension X -> " + this.dimensionX + " Dimension Y -> " + this.dimensionY;
    }
}
