package com.eneskayiklik.ui.game;

import com.eneskayiklik.ui.model.Settings;

import javax.swing.*;

public class GameScreen extends JFrame {
    public GameScreen(Settings settings) {
        setupPanel();
        System.out.println(settings.toString());
    }

    private void setupPanel() {
        setSize(600, 600);
        setTitle("Game Screen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
