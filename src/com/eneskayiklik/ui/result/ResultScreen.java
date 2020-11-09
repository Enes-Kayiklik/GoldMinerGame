package com.eneskayiklik.ui.result;

import com.eneskayiklik.model.player.Player;

import java.util.ArrayList;

public class ResultScreen {
    public ResultScreen(ArrayList<Player> players) {
        for (Player player : players) {
            System.out.println(player.getGoldAmount());
        }
    }
}
