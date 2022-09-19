package by.bsuir.webtech.task2;

import by.bsuir.webtech.task2.model.Point;
import by.bsuir.webtech.task2.model.Rectangle;
import by.bsuir.webtech.task2.service.CoordinatePlateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {

    private final CoordinatePlateService coordinatePlateService =
            new CoordinatePlateService();

    private final List<Rectangle> checkedArea = List.of(
            new Rectangle(new Point(-4.0, 5.0), new Point(4.0, 0.0)),
            new Rectangle(new Point(-6.0, 0.0), new Point(6.0, -2.0))
    );

    private static Stream<Arguments> pointsAndResult() {
        return Stream.of(
                Arguments.of(new Point(1.36, 2), true),
                Arguments.of(new Point(0, 0), true),
                Arguments.of(new Point(14.0, -6.0), false)
        );
    }

    @ParameterizedTest(name = "{index} point inside area: {1}")
    @MethodSource("pointsAndResult")
    @DisplayName("Check if point inside area:")
    void checkIfPointInsideArea(Point checkingPoint, boolean result) {
        boolean isPointInsideArea = coordinatePlateService.isPointInsideArea(checkingPoint, checkedArea);

        assertEquals(result, isPointInsideArea);
    }
}
