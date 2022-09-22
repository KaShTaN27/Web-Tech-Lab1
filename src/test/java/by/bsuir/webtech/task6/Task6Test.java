package by.bsuir.webtech.task6;

import by.bsuir.webtech.task6.service.MatrixService;
import by.bsuir.webtech.task6.writer.ResultWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task6Test {

    private final MatrixService matrixService = new MatrixService();
    private final ResultWriter resultWriter = new ResultWriter();

    private static Stream<Arguments> matrixFormingRow() {
        return Stream.of(
                Arguments.of(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, "elements amount is odd"),
                Arguments.of(new double[]{1.0, 2.0, 3.0, 4.0}, "elements amount is even"),
                Arguments.of(new double[]{-2.0, 44.1, 37.6, 0, -3.17}, "elements are negative, zeros and positive"),
                Arguments.of(new double[]{}, "it is empty"),
                Arguments.of(new double[]{1.0}, "it contains one element")
        );
    }

    @ParameterizedTest(name = "{index}. {1}")
    @MethodSource("matrixFormingRow")
    @DisplayName("Build matrix if")
    void buildMatrix(double[] matrixFormingRow, String displayingTestName) {
        double[][] matrix = matrixService.buildMatrix(matrixFormingRow);
        resultWriter.printMatrix(matrix);

        IntStream.range(0, matrix.length)
                .forEach(row -> IntStream.range(0, matrixFormingRow.length)
                        .forEach(index ->
                                assertEquals(matrixFormingRow[(row + index) % matrixFormingRow.length], matrix[row][index])));
    }
}
