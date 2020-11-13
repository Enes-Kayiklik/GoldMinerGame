package com.eneskayiklik.model.player;

import com.eneskayiklik.model.Gold;
import com.eneskayiklik.model.Target;
import com.eneskayiklik.utils.Functions;

import java.util.HashSet;

public class PlayerB extends Player {
    public PlayerB(char name, int goldAmount, int dimensionX, int dimensionY, int goldAmountPerRound, int selectTargetAmount) {
        super(name, goldAmount, dimensionX, dimensionY, goldAmountPerRound, selectTargetAmount);
    }

    @Override
    public void selectTargetB(HashSet<Gold> golds, int unitSize) {
        if (!golds.isEmpty()) {
            int x = this.getDimensionX();
            int y = this.getDimensionY();
            int min = Integer.MAX_VALUE;
            Target selectedTarget = new Target(x, y, null);
            for (Gold currentGold : golds) {
                int amount = Functions.calculateAmount(x, currentGold.getDimensionX(), y, currentGold.getDimensionY(), unitSize) - currentGold.getAmount();
                if (currentGold.isVisible() && min > amount) {
                    min = amount;
                    selectedTarget.setDimensionX(currentGold.getDimensionX());
                    selectedTarget.setDimensionY(currentGold.getDimensionY());
                    selectedTarget.setGold(currentGold);
                }
            }
            this.setGoldAmount(this.getGoldAmount() - this.getSelectTargetAmount());
            this.setTarget(selectedTarget);
        } else this.setTarget(null);
    }
}
