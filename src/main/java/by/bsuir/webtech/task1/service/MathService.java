package by.bsuir.webtech.task1.service;

public class MathService {

    public double countFraction(double x, double y) {
        return countNumerator(x, y) / countDenumerator(x, y) + x;
    }

    private double countNumerator(double x, double y) {
        return 1.0 + countSinSquared(x, y);
    }

    private double countSinSquared(double x, double y) {
        return Math.pow(Math.sin(x + y), 2);
    }

    private double countDenumerator(double x, double y) {
        return 2.0 + countModulo(x, y);
    }

    private double countModulo(double x, double y) {
        return x - ((2 * x) / (1 + Math.pow(x, 2) * Math.pow(y, 2)));
    }
}
