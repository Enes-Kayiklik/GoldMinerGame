package com.eneskayiklik.utils;

import com.eneskayiklik.model.Gold;
import com.eneskayiklik.model.Target;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;

public class Functions {
    public static void logException(Exception e) {
        System.err.println(e.getMessage());
    }

    public static double findDistance(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2.0) + Math.pow(y1 - y2, 2.0));
    }

    public static final String moveText = "%d-%d konumundan %d-%d konumuna hareket etti. Şu anki altın miktarı -> %d\n";

    public static int calculateMovement(int x1, int x2, int y1, int y2, int unitSize) {
        return (((Math.abs(x1 - x2) / unitSize) + (Math.abs(y1 - y2) / unitSize)));
    }

    public static final String getGoldText = "%d-%d konumundaki %d değerindeki altını ele geçirdi. Şu anki altın miktarı -> %d\n";

    public static int calculateAmount(int x1, int x2, int y1, int y2, int unitSize) {
        return calculateMovement(x1, x2, y1, y2, unitSize) * 5;
    }

    public static boolean isGoldTaken(HashSet<Gold> golds, Target target) {
        return !golds.contains(target.getGold());
    }

    public static boolean isNotAny(HashSet<Gold> golds, int x, int y) {
        for (Gold gold : golds) {
            if (gold.getDimensionX() == x && gold.getDimensionY() == y)
                return false;
        }
        return true;
    }

    public static boolean writeFile(String name, String text) {
        try {
            Files.write(Paths.get(name + ".txt"), text.getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (Exception e) {
            logException(e);
            return false;
        }
    }
}