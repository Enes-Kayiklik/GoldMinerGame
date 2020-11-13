package com.eneskayiklik.ui.settings;

import com.eneskayiklik.model.Settings;
import com.eneskayiklik.utils.Functions;

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
    private JTextField tvARoundGold;
    private JTextField tvASelectTargetAmount;
    private JTextField tvBRoundGold;
    private JTextField tvBSelectTargetAmount;
    private JTextField tvCRoundGold;
    private JTextField tvCSelectTargetAmount;
    private JTextField tvDRoundGold;
    private JTextField tvDSelectTargetAmount;

    public SettingsScreen(Settings settings) {
        this.settings = settings;
        setupPanel();
        setupButtonsOnClick();
    }

    private void setupButtonsOnClick() {
        btnSave.addActionListener(e -> {
            saveSettings();
            this.dispose();
        });
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
            settings.setPlayerARoundAmount(Integer.parseInt(tvARoundGold.getText()));
            settings.setPlayerBRoundAmount(Integer.parseInt(tvBRoundGold.getText()));
            settings.setPlayerCRoundAmount(Integer.parseInt(tvCRoundGold.getText()));
            settings.setPlayerDRoundAmount(Integer.parseInt(tvDRoundGold.getText()));
            settings.setPlayerASelectTargetAmount(Integer.parseInt(tvASelectTargetAmount.getText()));
            settings.setPlayerBSelectTargetAmount(Integer.parseInt(tvBSelectTargetAmount.getText()));
            settings.setPlayerCSelectTargetAmount(Integer.parseInt(tvCSelectTargetAmount.getText()));
            settings.setPlayerDSelectTargetAmount(Integer.parseInt(tvDSelectTargetAmount.getText()));
        } catch (Exception e) {
            Functions.logException(e);
        }
    }

    private void setupPanel() {
        add(panelSettings);
        setSize(600, 600);
        setTitle("Settings Screen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
