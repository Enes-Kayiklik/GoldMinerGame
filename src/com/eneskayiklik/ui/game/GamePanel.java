package com.eneskayiklik.ui.game;

import com.eneskayiklik.model.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel {
    static final int UNIT_SIZE = 25;
    static int SCREEN_WIDTH;
    static int SCREEN_HEIGHT;
    static int GAME_UNITS;
    Random random;
    int[] goldX;
    int[] goldY;
    int[][] dimensions;

    public GamePanel(Settings settings) {
        setupOptions(settings);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
    }

    private void setupOptions(Settings settings) {
        random = new Random();
        SCREEN_HEIGHT = UNIT_SIZE * settings.getXSize();
        SCREEN_WIDTH = UNIT_SIZE * settings.getYSize();
        GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
        dimensions = new int[GAME_UNITS][GAME_UNITS];
        goldX = new int[(GAME_UNITS * settings.getGoldRatio()) / 100];
        goldY = new int[(GAME_UNITS * settings.getGoldRatio()) / 100];
        System.out.println("Game Units: " + GAME_UNITS);
        System.out.println("Size: " + goldX.length);
        setupGold();
    }

    private void setupGold() {
        for (int i = 0; i < goldX.length; i++) {
            goldX[i] = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
            goldY[i] = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawGrid(g);
    }

    public void drawGrid(Graphics graphics) {
        // Drawing game lines
        graphics.setColor(Color.WHITE);
        for (int i = 0; i < SCREEN_WIDTH / UNIT_SIZE; i++) {
            graphics.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
        }

        for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
            graphics.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }

        // Drawing golds
        graphics.setColor(Color.orange);
        for (int i = 0; i < goldX.length; i++) {
            graphics.fillOval(goldX[i], goldY[i], UNIT_SIZE, UNIT_SIZE);
        }
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
        }
    }
}
