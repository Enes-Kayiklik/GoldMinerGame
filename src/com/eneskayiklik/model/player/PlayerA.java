package com.eneskayiklik.model.player;

import com.eneskayiklik.model.Gold;
import com.eneskayiklik.model.Target;
import com.eneskayiklik.utils.Functions;

import java.util.HashSet;

public class PlayerA extends Player {
    public PlayerA(char name, int goldAmount, int dimensionX, int dimensionY, int goldAmountPerRound, int selectTargetAmount) {
        super(name, goldAmount, dimensionX, dimensionY, goldAmountPerRound, selectTargetAmount);
    }

    @Override
    public void selectTargetA(HashSet<Gold> golds) {
        if (!golds.isEmpty() && this.getGoldAmount() > 0) {
            int x = this.getDimensionX();
            int y = this.getDimensionY();
            double min = Integer.MAX_VALUE;
            Target minTarget = new Target(x, y, null);
            for (Gold currentGold : golds) {
                double distance = Functions.findDistance(x, currentGold.getDimensionX(), y, currentGold.getDimensionY());
                if (min > distance && currentGold.isVisible()) {
                    min = distance;
                    minTarget.setDimensionX(currentGold.getDimensionX());
                    minTarget.setDimensionY(currentGold.getDimensionY());
                    minTarget.setGold(currentGold);
                }
            }
            this.setGoldAmount(this.getGoldAmount() - this.getSelectTargetAmount());
            this.setTarget(minTarget);
        } else this.setTarget(null);
    }
}
