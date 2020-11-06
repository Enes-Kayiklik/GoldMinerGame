package com.eneskayiklik.ui.start;

import com.eneskayiklik.model.Settings;
import com.eneskayiklik.ui.game.GameScreen;
import com.eneskayiklik.ui.settings.SettingsScreen;

import javax.swing.*;

public class StartScreen extends JFrame {
    private JButton btnSettings;
    private JPanel panelStart;
    private JButton btnStartGame;
    private Settings settings;

    public StartScreen() {
        setupUtils();
        setupPanel();
        setupButtonsOnClick();
    }

    private void setupUtils() {
        settings = new Settings();
    }

    private void setupButtonsOnClick() {
        btnSettings.addActionListener(e ->
                showNewScreen(new SettingsScreen(settings))
        );

        btnStartGame.addActionListener(e -> {
            this.dispose();
            showNewScreen(new GameScreen(settings));
        });
    }

    private void showNewScreen(JFrame panel) {
        SwingUtilities.invokeLater(() -> panel.setVisible(true));
    }

    private void setupPanel() {
        add(panelStart);
        setSize(400, 400);
        setTitle("Start Screen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}