package com.eneskayiklik.model;

public class Gold {
    private final int dimensionX;
    private final int dimensionY;
    private int amount;
    private boolean isVisible;

    public Gold(int dimensionX, int dimensionY, int amount, boolean isVisible) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.amount = amount;
        this.isVisible = isVisible;
    }

    public int getDimensionX() {
        return dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
