package by.bsuir.webtech.task9.model;

import by.bsuir.webtech.task9.exception.InvalidBallWeightException;

public class Ball {

    private final double weight;
    private final Color color;

    public Ball(double weight, Color color) {
        if (Double.compare(weight, 0) <= 0)
            throw new InvalidBallWeightException("Weight must be grater than zero");
        this.weight = weight;
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }
}
