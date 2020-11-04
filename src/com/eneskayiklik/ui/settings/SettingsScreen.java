package com.eneskayiklik.ui.settings;

import com.eneskayiklik.ui.model.Settings;
import com.eneskayiklik.ui.utils.Functions;

import javax.swing.*;

public class SettingsScreen extends JFrame {

    private final Settings settings;
    private JPanel panelSettings;
    private JTextField tvSize;
    private JTextField tvGoldRatio;
    private JTextField tvHiddenGoldRatio;
    private JTextField tvGoldAmountPerPlayer;
    private JTextField tvStepSizePerRound;
    private JButton btnSave;

    public SettingsScreen(Settings settings) {
        this.settings = settings;
        setupPanel();
        setupButtonsOnClick();
    }

    private void setupButtonsOnClick() {
        btnSave.addActionListener(e ->
                saveSettings()
        );
    }

    private void saveSettings() {
        try {
            String[] size = tvSize.getText().split("x");
            String goldRatio = tvGoldRatio.getText();
            String hiddenGoldRatio = tvHiddenGoldRatio.getText();
            String goldAmountPerPlayer = tvGoldAmountPerPlayer.getText();
            String stepSizePerRound = tvStepSizePerRound.getText();

            int xSize = Integer.parseInt(size[0]);
            int ySize = Integer.parseInt(size[1]);
            int gold = Integer.parseInt(goldRatio);
            int hiddenGold = Integer.parseInt(hiddenGoldRatio);
            int goldAmount = Integer.parseInt(goldAmountPerPlayer);
            int stepSize = Integer.parseInt(stepSizePerRound);

            settings.setXSize(xSize);
            settings.setYSize(ySize);
            settings.setGoldRatio(gold);
            settings.setHiddenGoldRatio(hiddenGold);
            settings.setGoldAmountPerPlayer(goldAmount);
            settings.setStepSizePerRound(stepSize);
        } catch (Exception e) {
            Functions.logException(e);
        }
    }

    private void setupPanel() {
        add(panelSettings);
        setSize(400, 400);
        setTitle("Settings Screen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
