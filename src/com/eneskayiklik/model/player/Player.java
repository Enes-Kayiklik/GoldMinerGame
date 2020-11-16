package com.eneskayiklik.model.player;

import com.eneskayiklik.model.Gold;
import com.eneskayiklik.model.Target;

import java.util.ArrayList;
import java.util.HashSet;

public class Player {
    private final char name;
    private int goldAmount;
    private int dimensionX;
    private int dimensionY;
    private final int goldAmountPerRound;
    private final int selectTargetAmount;
    private Target target;
    private int totalStep;
    private int spentGoldAmount;
    private int collectedGoldAmount;

    public Player(char name, int goldAmount, int dimensionX, int dimensionY, int goldAmountPerRound, int selectTargetAmount) {
        this.name = name;
        this.goldAmount = goldAmount;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.goldAmountPerRound = goldAmountPerRound;
        this.selectTargetAmount = selectTargetAmount;
        this.totalStep = 0;
        this.spentGoldAmount = 0;
        this.collectedGoldAmount = 0;
    }

    public int getTotalStep() {
        return totalStep;
    }

    public void setTotalStep(int totalStep) {
        this.totalStep = totalStep;
    }

    public int getSpentGoldAmount() {
        return spentGoldAmount;
    }

    public void setSpentGoldAmount(int spentGoldAmount) {
        this.spentGoldAmount = spentGoldAmount;
    }

    public int getCollectedGoldAmount() {
        return collectedGoldAmount;
    }

    public void setCollectedGoldAmount(int collectedGoldAmount) {
        this.collectedGoldAmount = collectedGoldAmount;
    }

    public int getGoldAmountPerRound() {
        return goldAmountPerRound;
    }

    public int getSelectTargetAmount() {
        return selectTargetAmount;
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
    public void selectTargetA(HashSet<Gold> golds) {
    }

    // PlayerB's select target
    public void selectTargetB(HashSet<Gold> golds, int unitSize) {
    }

    // PlayerC's select target
    public void selectTargetC(HashSet<Gold> golds, int unitSize) {
    }

    // PlayerD's select target
    public void selectTarget(HashSet<Gold> golds, ArrayList<Player> players) {
    }

    @Override
    public String toString() {
        return "Name -> " + this.name + " Dimension X -> " + this.dimensionX + " Dimension Y -> " + this.dimensionY;
    }
}
