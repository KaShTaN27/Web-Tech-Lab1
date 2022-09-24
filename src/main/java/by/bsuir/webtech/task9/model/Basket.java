package by.bsuir.webtech.task9.model;

import java.util.List;

public class Basket {

    private final List<Ball> balls;
    private double ballsWeight;

    public Basket(List<Ball> balls) {
        this.balls = balls;
        this.ballsWeight = balls.stream()
                .mapToDouble(Ball::getWeight)
                .sum();
    }

    public void addBall(Ball ball) {
        balls.add(ball);
        ballsWeight += ball.getWeight();
    }

    public double getBallsWeight() {
        return ballsWeight;
    }

    public long getBallsAmountByColor(Color color) {
        return balls.stream()
                .filter(ball -> ball.getColor().equals(color))
                .count();
    }
}
