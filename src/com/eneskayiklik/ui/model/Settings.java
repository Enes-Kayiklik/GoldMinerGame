package com.eneskayiklik.ui.model;

public class Settings {
    private int xSize = 20;
    private int ySize = 20;
    private int goldRatio = 20;
    private int hiddenGoldRatio = 10;
    private int goldAmountPerPlayer = 200;
    private int stepSizePerRound = 3;

    public int getXSize() {
        return xSize;
    }

    public void setXSize(int xSize) {
        this.xSize = xSize;
    }

    public int getYSize() {
        return ySize;
    }

    public void setYSize(int ySize) {
        this.ySize = ySize;
    }

    public int getGoldRatio() {
        return goldRatio;
    }

    public void setGoldRatio(int goldRatio) {
        this.goldRatio = goldRatio;
    }

    public int getHiddenGoldRatio() {
        return hiddenGoldRatio;
    }

    public void setHiddenGoldRatio(int hiddenGoldRatio) {
        this.hiddenGoldRatio = hiddenGoldRatio;
    }

    public int getGoldAmountPerPlayer() {
        return goldAmountPerPlayer;
    }

    public void setGoldAmountPerPlayer(int goldAmountPerPlayer) {
        this.goldAmountPerPlayer = goldAmountPerPlayer;
    }

    public int getStepSizePerRound() {
        return stepSizePerRound;
    }

    public void setStepSizePerRound(int stepSizePerRound) {
        this.stepSizePerRound = stepSizePerRound;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "xSize=" + xSize +
                ", ySize=" + ySize +
                ", goldRatio=" + goldRatio +
                ", hiddenGoldRatio=" + hiddenGoldRatio +
                ", goldAmountPerPlayer=" + goldAmountPerPlayer +
                ", stepSizePerRound=" + stepSizePerRound +
                '}';
    }
}
