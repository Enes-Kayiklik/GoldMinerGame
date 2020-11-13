package com.eneskayiklik.ui.start;

import com.eneskayiklik.model.Settings;
import com.eneskayiklik.ui.game.GameScreen;
import com.eneskayiklik.ui.settings.SettingsScreen;
import com.eneskayiklik.utils.Functions;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
            createTxt();
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

    private void createTxt() {
        try {
            if (!new File("A.txt").createNewFile()) {
                new FileWriter("A.txt").write("");
            }
            if (!new File("B.txt").createNewFile()) {
                new FileWriter("B.txt").write("");
            }
            if (!new File("C.txt").createNewFile()) {
                new FileWriter("C.txt").write("");
            }
            if (!new File("D.txt").createNewFile()) {
                new FileWriter("D.txt").write("");
            }
        } catch (IOException e) {
            Functions.logException(e);
        }
    }
}