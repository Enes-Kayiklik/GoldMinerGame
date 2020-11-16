package com.eneskayiklik.model;

public class Settings {
    private int xSize = 20;
    private int ySize = 20;
    private int goldRatio = 20;
    private int hiddenGoldRatio = 10;
    private int goldAmountPerPlayer = 200;
    private int stepSizePerRound = 3;
    private int playerASelectTargetAmount = 5;
    private int playerBSelectTargetAmount = 10;
    private int playerCSelectTargetAmount = 15;
    private int playerDSelectTargetAmount = 20;
    private int playerARoundAmount = 5;
    private int playerBRoundAmount = 5;
    private int playerCRoundAmount = 5;
    private int playerDRoundAmount = 5;

    public int getPlayerASelectTargetAmount() {
        return playerASelectTargetAmount;
    }

    public void setPlayerASelectTargetAmount(int playerASelectTargetAmount) {
        this.playerASelectTargetAmount = playerASelectTargetAmount;
    }

    public int getPlayerBSelectTargetAmount() {
        return playerBSelectTargetAmount;
    }

    public void setPlayerBSelectTargetAmount(int playerBSelectTargetAmount) {
        this.playerBSelectTargetAmount = playerBSelectTargetAmount;
    }

    public int getPlayerCSelectTargetAmount() {
        return playerCSelectTargetAmount;
    }

    public void setPlayerCSelectTargetAmount(int playerCSelectTargetAmount) {
        this.playerCSelectTargetAmount = playerCSelectTargetAmount;
    }

    public int getPlayerDSelectTargetAmount() {
        return playerDSelectTargetAmount;
    }

    public void setPlayerDSelectTargetAmount(int playerDSelectTargetAmount) {
        this.playerDSelectTargetAmount = playerDSelectTargetAmount;
    }

    public int getPlayerARoundAmount() {
        return playerARoundAmount;
    }

    public void setPlayerARoundAmount(int playerARoundAmount) {
        this.playerARoundAmount = playerARoundAmount;
    }

    public int getPlayerBRoundAmount() {
        return playerBRoundAmount;
    }

    public void setPlayerBRoundAmount(int playerBRoundAmount) {
        this.playerBRoundAmount = playerBRoundAmount;
    }

    public int getPlayerCRoundAmount() {
        return playerCRoundAmount;
    }

    public void setPlayerCRoundAmount(int playerCRoundAmount) {
        this.playerCRoundAmount = playerCRoundAmount;
    }

    public int getPlayerDRoundAmount() {
        return playerDRoundAmount;
    }

    public void setPlayerDRoundAmount(int playerDRoundAmount) {
        this.playerDRoundAmount = playerDRoundAmount;
    }

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
                ", playerASelectTargetAmount=" + playerASelectTargetAmount +
                ", playerBSelectTargetAmount=" + playerBSelectTargetAmount +
                ", playerCSelectTargetAmount=" + playerCSelectTargetAmount +
                ", playerDSelectTargetAmount=" + playerDSelectTargetAmount +
                ", playerARoundAmount=" + playerARoundAmount +
                ", playerBRoundAmount=" + playerBRoundAmount +
                ", playerCRoundAmount=" + playerCRoundAmount +
                ", playerDRoundAmount=" + playerDRoundAmount +
                '}';
    }
}
