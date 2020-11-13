package com.eneskayiklik.ui.game;

import com.eneskayiklik.model.Gold;
import com.eneskayiklik.model.Settings;
import com.eneskayiklik.model.Target;
import com.eneskayiklik.model.player.*;
import com.eneskayiklik.ui.result.ResultScreen;
import com.eneskayiklik.utils.Functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class GamePanel extends JPanel {
    static final int UNIT_SIZE = 25;
    static int SCREEN_WIDTH;
    static int SCREEN_HEIGHT;
    static int GAME_UNITS;
    static int HIDDEN_GOLD;
    Random random;
    Settings settings;
    HashSet<Gold> golds = new HashSet<>();
    ArrayList<Player> players = new ArrayList<>();
    Graphics graphics;

    public GamePanel(Settings settings) {
        setupOptions(settings);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
    }

    private void setupOptions(Settings settings) {
        random = new Random();
        this.settings = settings;
        setupPanelSettings();
        int goldSize = (GAME_UNITS * settings.getGoldRatio()) / 100;
        HIDDEN_GOLD = (goldSize * settings.getHiddenGoldRatio()) / 100;
        setupGold(goldSize);
        setupPlayers();
    }

    private void playGame() {
        if (!checkGameEnded()) {
            chooseTarget();
            move();
            repaint();
        }
    }

    private boolean checkGameEnded() {
        if (isAnyVisibleGold() || isAllPlayersGoldZero()) {
            int result = JOptionPane.showOptionDialog(this, "Oyun Bitti Kanka", "Seç Kanka", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Tamam"}, null);
            switch (result) {
                case 0 -> new ResultScreen(players).setVisible(true);
                case 1 -> System.out.println("Delete me");
            }
        }

        return isAnyVisibleGold() || isAllPlayersGoldZero();
    }

    private boolean isAnyVisibleGold() {
        for (Gold gold : golds)
            if (gold.isVisible()) return false;
        return true;
    }

    private boolean isAllPlayersGoldZero() {
        int count = 0;
        for (Player player : players)
            if (player.getGoldAmount() <= 0) count++;
        return players.size() == count;
    }

    private void move() {
        for (Player player : players) {
            if (player.getTarget() != null && golds.contains(player.getTarget().getGold())) {
                movePlayers(player);
            }
        }
    }

    private void movePlayers(Player player) {
        if (player.getTarget() != null && player.getGoldAmount() > 0) {
            Target target = player.getTarget();
            int moveCount = Functions.calculateMovement(target.getDimensionX(), player.getDimensionX(), target.getDimensionY(), player.getDimensionY(), UNIT_SIZE);
            int targetX = target.getDimensionX();
            int targetY = target.getDimensionY();
            if (moveCount <= settings.getStepSizePerRound()) {
                player.setDimensionX(targetX);
                player.setDimensionY(targetY);
                player.setGoldAmount(player.getGoldAmount() + (target.getGold().getAmount() - moveCount * 5));
                formatText(player.getName(), target.getGold(), player.getGoldAmount());
                golds.remove(target.getGold());
                for (Player currentPlayer : players) {
                    if (currentPlayer.getTarget() == player.getTarget()) {
                        currentPlayer.setTarget(null);
                    }
                }
            } else {
                int startX = player.getDimensionX();
                int startY = player.getDimensionY();
                for (int i = 0; i < settings.getStepSizePerRound(); i++) {
                    int playerX = player.getDimensionX();
                    int playerY = player.getDimensionY();
                    if (targetX - playerX == 0) { // When X dimensions are equal move in Y Dimension
                        if (targetY > playerY) {
                            player.setDimensionY(playerY + UNIT_SIZE);
                        } else {
                            player.setDimensionY(playerY - UNIT_SIZE);
                        }
                    } else if (targetY - playerY == 0) { // When Y dimensions are equal move in X Dimension
                        if (targetX > playerX) {
                            player.setDimensionX(playerX + UNIT_SIZE);
                        } else {
                            player.setDimensionX(playerX - UNIT_SIZE);
                        }
                    } else {
                        if (targetX > playerX) {
                            player.setDimensionX(playerX + UNIT_SIZE);
                        } else {
                            player.setDimensionX(playerX - UNIT_SIZE);
                        }
                    }
                    player.setGoldAmount(player.getGoldAmount() - player.getGoldAmountPerRound());
                }
                int endX = player.getDimensionX();
                int endY = player.getDimensionY();
                formatText(startX, startY, endX, endY, player.getGoldAmount(), String.valueOf(player.getName()));
            }
        }
    }

    private void formatText(int startX, int startY, int endX, int endY, int currentGold, String name) {
        String format = String.format(Functions.moveText, startX, startY, endX, endY, currentGold);
        Functions.writeFile(name, format);
    }

    private void formatText(char name, Gold gold, int point) {
        String format = String.format(Functions.getGoldText, gold.getDimensionX(), gold.getDimensionY(), gold.getAmount(), point);
        Functions.writeFile(String.valueOf(name), format);
    }

    private void chooseTarget() {
        if (players.get(0).getTarget() == null || Functions.isGoldTaken(golds, players.get(0).getTarget()))
            players.get(0).selectTargetA(golds);
        if (players.get(1).getTarget() == null || Functions.isGoldTaken(golds, players.get(1).getTarget()))
            players.get(1).selectTargetB(golds, UNIT_SIZE);
        if (players.get(2).getTarget() == null || Functions.isGoldTaken(golds, players.get(2).getTarget()))
            players.get(2).selectTargetC(golds, UNIT_SIZE);
        if (players.get(3).getTarget() == null || Functions.isGoldTaken(golds, players.get(3).getTarget()))
            players.get(3).selectTarget(golds, players);
        repaint();
    }

    private void setupPlayers() {
        players.add(new PlayerA('A', settings.getGoldAmountPerPlayer(), 0, 0, settings.getPlayerARoundAmount(), settings.getPlayerASelectTargetAmount()));
        players.add(new PlayerB('B', settings.getGoldAmountPerPlayer(), 0, SCREEN_WIDTH - UNIT_SIZE, settings.getPlayerBRoundAmount(), settings.getPlayerBSelectTargetAmount()));
        players.add(new PlayerC('C', settings.getGoldAmountPerPlayer(), SCREEN_WIDTH - UNIT_SIZE, 0, settings.getPlayerCRoundAmount(), settings.getPlayerCSelectTargetAmount()));
        players.add(new PlayerD('D', settings.getGoldAmountPerPlayer(), SCREEN_WIDTH - UNIT_SIZE, SCREEN_WIDTH - UNIT_SIZE, settings.getPlayerDRoundAmount(), settings.getPlayerDSelectTargetAmount()));
    }

    private void setupGold(int goldSize) {
        int i = 0;
        while (i < goldSize) {
            // setting up gold items. Amount must grater than 5 and smaller than 20
            int x = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
            int y = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
            if (Functions.isNotAny(golds, x, y)) {
                golds.add(new Gold(
                        x,
                        y,
                        (random.nextInt(4) + 1) * 5,
                        i >= HIDDEN_GOLD));
                i++;
            }
        }
        System.out.println("Gold size -> " + golds.size());
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
            paintTarget(player);
        }
    }

    private void paintTarget(Player player) {
        if (player.getTarget() != null) {
            graphics.setColor(Color.magenta);
            graphics.drawRect(player.getTarget().getDimensionX(), player.getTarget().getDimensionY(), 25, 25);
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

    private void drawPlayer(Player player) {
        graphics.setColor(Color.RED);
        graphics.fillRect(player.getDimensionX(), player.getDimensionY(), UNIT_SIZE, UNIT_SIZE);
        graphics.setColor(Color.WHITE);
        graphics.drawString((player.getName() + " " + player.getGoldAmount()), player.getDimensionX(), player.getDimensionY() + UNIT_SIZE / 2);
    }

    private void setupPanelSettings() {
        SCREEN_HEIGHT = UNIT_SIZE * settings.getXSize();
        SCREEN_WIDTH = UNIT_SIZE * settings.getYSize();
        GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    playGame();
                } else {
                    chooseTarget();
                    repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
}