package com.sbrf.reboot;

public class Calculator {
    public static int getAddition(int a, int b) {
        int res=a+b;
        return res;
    }

    public static int getSubtraction(int a, int b) {
        int res=a-b;
        return res;
    }
    public static double getMultiplication(double a, double b) {
        double res=a*b;
        return res;
    }
    public static double getDivision(double a, double b) {
        return a/b;
    }
    public static double getSin(int a) {
        double res=Math.sin(Math.toRadians(a));
        return res;
    }

    public static double getCos(double a) {
        double res=Math.cos(Math.toRadians(a));
        return res;
    }

    public static double getTan(double a) {
        double res=Math.tan(Math.toRadians(a));
        return res;
    }


}
