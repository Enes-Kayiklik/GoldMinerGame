package com.eneskayiklik.model.player;

import com.eneskayiklik.model.Gold;
import com.eneskayiklik.model.Target;
import com.eneskayiklik.utils.Functions;

import java.util.ArrayList;
import java.util.HashSet;

public class PlayerD extends Player {
    public PlayerD(char name, int goldAmount, int dimensionX, int dimensionY, int goldAmountPerRound, int selectTargetAmount) {
        super(name, goldAmount, dimensionX, dimensionY, goldAmountPerRound, selectTargetAmount);
    }

    @Override
    public void selectTarget(HashSet<Gold> golds, ArrayList<Player> players) {
        if (!golds.isEmpty() && this.getGoldAmount() > 0) {
            int x = this.getDimensionX();
            int y = this.getDimensionY();
            double min = Integer.MAX_VALUE;
            Target minTarget = new Target(x, y, null);
            for (Gold currentGold : golds) {
                double distance = Functions.findDistance(x, currentGold.getDimensionX(), y, currentGold.getDimensionY());
                if (min > distance && currentGold.isVisible() && isCloserThanAnyPlayer(players, currentGold, distance)) {
                    min = distance;
                    minTarget.setDimensionX(currentGold.getDimensionX());
                    minTarget.setDimensionY(currentGold.getDimensionY());
                    minTarget.setGold(currentGold);
                }
            }
            this.setGoldAmount(this.getGoldAmount() - this.getSelectTargetAmount());
            this.setTarget(minTarget);
            this.setSpentGoldAmount(this.getSpentGoldAmount() + this.getSelectTargetAmount());
        } else this.setTarget(null);
    }

    private boolean isCloserThanAnyPlayer(ArrayList<Player> players, Gold currentGold, double distance) {
        for (Player player : players) {
            Target target = player.getTarget();
            if (target != null) {
                if (target.getDimensionX() == currentGold.getDimensionX() && target.getDimensionY() == currentGold.getDimensionY()) {
                    if (distance < Functions.findDistance(target.getDimensionX(), currentGold.getDimensionX(), target.getDimensionY(), currentGold.getDimensionY())) {
                        return true;
                    }
                } else return true;
            }
        }
        return false;
    }
}
