package com.eneskayiklik.model.player;

import com.eneskayiklik.model.Gold;
import com.eneskayiklik.model.Target;
import com.eneskayiklik.utils.Functions;

import java.util.ArrayList;

public class PlayerC extends Player {
    public PlayerC(char name, int goldAmount, int dimensionX, int dimensionY) {
        super(name, goldAmount, dimensionX, dimensionY);
    }

    @Override
    public void selectTargetC(ArrayList<Gold> golds, int unitSize) {
        if (!golds.isEmpty() && this.getGoldAmount() > 0) {
            int x = this.getDimensionX();
            int y = this.getDimensionY();
            makeVisible(golds, x, y);
            int min = Integer.MAX_VALUE;
            Target selectedTarget = new Target(x, y, null);
            for (Gold currentGold : golds) {
                int amount = Functions.calculateAmount(x, currentGold.getDimensionX(), y, currentGold.getDimensionY(), unitSize);
                if (min > amount && currentGold.isVisible()) {
                    min = amount;
                    selectedTarget.setDimensionX(currentGold.getDimensionX());
                    selectedTarget.setDimensionY(currentGold.getDimensionY());
                    selectedTarget.setGold(currentGold);
                }
            }
            this.setGoldAmount(this.getGoldAmount() - 5);
            this.setTarget(selectedTarget);
        } else this.setTarget(null);
    }

    private void makeVisible(ArrayList<Gold> golds, int x, int y) {
        for (Gold currentGold : golds) {
            if (Functions.findDistance(x, currentGold.getDimensionX(), y, currentGold.getDimensionY()) <= 75) {
                currentGold.setVisible(true);
            }
        }
    }
}
