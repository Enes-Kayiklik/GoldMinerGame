package com.eneskayiklik.ui.game;

import com.eneskayiklik.model.Gold;
import com.eneskayiklik.model.Player;
import com.eneskayiklik.model.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    static final int UNIT_SIZE = 25;
    static int SCREEN_WIDTH;
    static int SCREEN_HEIGHT;
    static int GAME_UNITS;
    static int HIDDEN_GOLD;
    static Timer timer;
    Random random;
    ArrayList<Gold> golds = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    int[][] dimensions;
    Graphics graphics;

    public GamePanel(Settings settings) {
        setupOptions(settings);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
    }

    private void setupOptions(Settings settings) {
        random = new Random();
        timer = new Timer(500, this);
        setupPanelSettings(settings);
        int goldSize = (GAME_UNITS * settings.getGoldRatio()) / 100;
        HIDDEN_GOLD = (goldSize * 10) / 100;
        setupGold(goldSize);
        setupPlayers(settings.getGoldAmountPerPlayer());
        timer.start();
    }

    private void playGame() {
        if (golds.size() >= 4)
            for (Player currentPlayer : players) {
                currentPlayer.setDimensionX(golds.get(0).getDimensionX());
                currentPlayer.setDimensionY(golds.get(0).getDimensionY());
                golds.remove(0);
            }
        /*if (golds.size() > 4) {

            golds.remove(1);
            golds.remove(2);
            golds.remove(3);
        }*/

        repaint();
    }

    private void setupPlayers(int goldAmountPerPlayer) {
        players.add(new Player((char) (65), goldAmountPerPlayer, 0, 0));
        players.add(new Player((char) (66), goldAmountPerPlayer, 0, SCREEN_WIDTH - UNIT_SIZE));
        players.add(new Player((char) (67), goldAmountPerPlayer, SCREEN_WIDTH - UNIT_SIZE, 0));
        players.add(new Player((char) (68), goldAmountPerPlayer, SCREEN_WIDTH - UNIT_SIZE, SCREEN_WIDTH - UNIT_SIZE));
    }

    private void setupGold(int goldSize) {
        for (int i = 0; i < goldSize; i++) {
            // setting up gold items. Amount must grater than 5 and smaller than 20
            golds.add(new Gold(
                    random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE,
                    random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE,
                    (random.nextInt(4) + 1) * 5,
                    i >= HIDDEN_GOLD));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        graphics = g;
        drawGame();
    }

    private void drawGame() {
        // Clear board
        clearBoard();

        // Drawing game lines
        drawGrids();

        // Drawing golds
        drawGolds();

        // Drawing players
        for (Player player : players) {
            drawPlayer(player);
        }
    }

    private void clearBoard() {
        graphics.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    private void drawGolds() {
        graphics.setColor(Color.orange);
        for (Gold currentGold : golds) {
            if (currentGold.isVisible())
                graphics.fillOval(
                        currentGold.getDimensionX() + (UNIT_SIZE - currentGold.getAmount()) / 2,
                        currentGold.getDimensionY() + (UNIT_SIZE - currentGold.getAmount()) / 2,
                        currentGold.getAmount(),
                        currentGold.getAmount());
        }
    }

    private void drawGrids() {
        graphics.setColor(Color.WHITE);
        for (int i = 0; i < SCREEN_WIDTH / UNIT_SIZE; i++) {
            graphics.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
        }

        for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
            graphics.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }
    }

    private void setupPanelSettings(Settings settings) {
        SCREEN_HEIGHT = UNIT_SIZE * settings.getXSize();
        SCREEN_WIDTH = UNIT_SIZE * settings.getYSize();
        GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
        dimensions = new int[GAME_UNITS][GAME_UNITS];
    }

    private void drawPlayer(Player player) {
        graphics.setColor(Color.RED);
        graphics.fillRect(player.getDimensionX(), player.getDimensionY(), UNIT_SIZE, UNIT_SIZE);
        graphics.setColor(Color.WHITE);
        graphics.drawString(String.valueOf(player.getName()), player.getDimensionX() + UNIT_SIZE / 2, player.getDimensionY() + UNIT_SIZE / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        playGame();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
        }
    }
}