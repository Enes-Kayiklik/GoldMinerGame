package com.eneskayiklik.utils;

public class Functions {
    public static void logException(Exception e) {
        System.err.println(e.getMessage());
    }

    public static double findDistance(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2.0) + Math.pow(y1 - y2, 2.0));
    }

    public static int calculateAmount(int x1, int x2, int y1, int y2, int unitSize) {
        return (((Math.abs(x1 - x2) / unitSize) + (Math.abs(y1 - y2) / unitSize)) * 5);
    }

    public static int calculateMovement(int x1, int x2, int y1, int y2, int unitSize) {
        return (((Math.abs(x1 - x2) / unitSize) + (Math.abs(y1 - y2) / unitSize)));
    }
}
