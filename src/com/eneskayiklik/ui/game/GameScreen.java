package com.eneskayiklik.ui.game;

import com.eneskayiklik.model.Settings;

import javax.swing.*;

public class GameScreen extends JFrame {
    public GameScreen(Settings settings) {
        setupPanel(settings);
        System.out.println(settings.toString());
    }

    private void setupPanel(Settings settings) {
        add(new GamePanel(settings));
        setTitle("Game Screen");
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
    }
}
