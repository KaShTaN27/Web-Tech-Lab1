package by.bsuir.webtech.task1;

import by.bsuir.webtech.task1.service.MathService;
import by.bsuir.webtech.task1.writer.ResultWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {

    private final MathService mathService = new MathService();
    private final ResultWriter resultWriter = new ResultWriter();

    private static Stream<Arguments> paramXAndParamYAndResult() {
        return Stream.of(
                Arguments.of(1.0, 2.0, 1.392, "both are positive"),
                Arguments.of(-2.3, 5.0, -6.755, "first negative, second positive"),
                Arguments.of(3.2, -4.0, 3.493, "first positive, second negative"),
                Arguments.of(0.0, 0.0, 0.5, "both are zero"),
                Arguments.of(-3.6, -0.2, -3.163, "both are negative")
        );
    }

    @ParameterizedTest(name = "{index}. {3}")
    @MethodSource("paramXAndParamYAndResult")
    @DisplayName("Calculate fraction if")
    void calculateFraction(Double x, Double y, Double result, String displayingName) {
        double fractionResult = mathService.countFraction(x, y);
        resultWriter.printFractionResult(fractionResult);

        assertEquals(result, Math.round(fractionResult * 1000) / 1000.0);
    }
}
