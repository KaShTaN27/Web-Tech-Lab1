package by.bsuir.webtech.task7;

import by.bsuir.webtech.task7.service.SortService;
import by.bsuir.webtech.task7.writer.ResultWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Task7Test {

    private final SortService sortService = new SortService();
    private final ResultWriter resultWriter = new ResultWriter();

    private static Stream<Arguments> arrays() {
        return Stream.of(
                Arguments.of(new double[]{3.0, 1.0, 2.0}, "common case"),
                Arguments.of(new double[]{}, "empty array"),
                Arguments.of(new double[]{-1.0, 0.0, 30.1, 40.3}, "sorted ascending array"),
                Arguments.of(new double[]{6.9, 6.85, 7.77,  0.11, -11.1}, "sorted descending array")
        );
    }

    @ParameterizedTest
    @MethodSource("arrays")
    @DisplayName("Sort:")
    void sortArray(double[] array) {
        sortService.shellSort(array);
        resultWriter.printArray(array);

        assertTrue(IntStream.range(0, array.length - 1)
                .noneMatch(i -> array[i] > array[i+ 1]));
    }
}
