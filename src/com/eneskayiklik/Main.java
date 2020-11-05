package com.eneskayiklik;

import com.eneskayiklik.ui.start.StartScreen;
import com.eneskayiklik.utils.Functions;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        setSystemUI();
        showStartScreen();
    }

    private static void setSystemUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            Functions.logException(e);
        }
    }

    private static void showStartScreen() {
        // Showing "Start" Screen to user.
        SwingUtilities.invokeLater(() -> new StartScreen().setVisible(true));
    }
}
