package com.eneskayiklik.model.player;

import com.eneskayiklik.model.Gold;
import com.eneskayiklik.model.Target;

import java.util.ArrayList;

public class Player {
    private final char name;
    private int goldAmount;
    private int dimensionX;
    private int dimensionY;
    private Target target;

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

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    // PlayerA's C's select target
    public void selectTargetA(ArrayList<Gold> golds) {
    }

    // PlayerB's select target
    public void selectTargetB(ArrayList<Gold> golds, int unitSize) {
    }

    // PlayerC's select target
    public void selectTargetC(ArrayList<Gold> golds, int unitSize) {
    }

    // PlayerD's select target
    public void selectTarget(ArrayList<Gold> golds, ArrayList<Player> players) {
    }

    @Override
    public String toString() {
        return "Name -> " + this.name + " Dimension X -> " + this.dimensionX + " Dimension Y -> " + this.dimensionY;
    }
}
