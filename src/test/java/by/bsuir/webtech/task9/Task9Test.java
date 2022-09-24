package by.bsuir.webtech.task9;

import by.bsuir.webtech.task9.exception.InvalidBallWeightException;
import by.bsuir.webtech.task9.model.Ball;
import by.bsuir.webtech.task9.model.Basket;
import by.bsuir.webtech.task9.model.Color;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task9Test {

    private static final List<Ball> balls = List.of(
            new Ball(2.1, Color.RED),
            new Ball(3.0, Color.YELLOW),
            new Ball(15.0, Color.GREEN),
            new Ball(4.7, Color.BLUE),
            new Ball(6.0, Color.BLUE)
    );

    private static Stream<Arguments> basketAndBasketWeightAndBlueBallsAmount() {
        return Stream.of(
                Arguments.of(balls.stream().limit(3).toList(), 20.1, 0),
                Arguments.of(balls.stream().skip(3).toList(), 10.7, 2),
                Arguments.of(balls, 30.8, 2)
        );
    }

    @Test
    void createBall_IfWeightNegative() {
        assertThrows(InvalidBallWeightException.class, () ->
                new Ball(-0.1, Color.BLUE));
    }

    @ParameterizedTest
    @MethodSource("basketAndBasketWeightAndBlueBallsAmount")
    void getBasketWeightAndBlueBallAmount(List<Ball> balls, double basketWeight, long blueBallsAmount) {
        Basket basket = new Basket(balls);

        assertEquals(basketWeight, basket.getBallsWeight());
        assertEquals(blueBallsAmount, basket.getBallsAmountByColor(Color.BLUE));
    }
}
