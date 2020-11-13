package com.eneskayiklik.ui.result;

import com.eneskayiklik.model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ResultScreen extends JFrame {
    private final Object[][] data = new Object[4][2];
    private JPanel panel1;

    public ResultScreen(ArrayList<Player> players) {
        setupPanel();
        setupTableData(players);

    }

    private void setupTableData(ArrayList<Player> players) {
        for (int i = 0; i < 4; i++) {
            Player currentPlayer = players.get(i);
            data[i][0] = currentPlayer.getName();
            data[i][1] = currentPlayer.getGoldAmount();
        }
        String[] columnNames = {"Name", "Gold Amount"};
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        panel1.setLayout(new BorderLayout());
        panel1.add(table.getTableHeader(), BorderLayout.PAGE_START);
        panel1.add(table, BorderLayout.CENTER);
    }

    private void setupPanel() {
        add(panel1);
        setSize(400, 400);
        setTitle("Result Screen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
