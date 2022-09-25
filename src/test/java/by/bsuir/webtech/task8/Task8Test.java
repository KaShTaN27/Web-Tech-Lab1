package by.bsuir.webtech.task8;

import by.bsuir.webtech.task8.service.InsertionService;
import by.bsuir.webtech.task8.writer.ResultWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task8Test {

    private final InsertionService insertionService = new InsertionService();
    private final ResultWriter resultWriter = new ResultWriter();

    private static Stream<Arguments> arrays() {
        return Stream.of(
                Arguments.of(new double[]{1.0, 2.0, 3.0}, new double[]{2.1, 2.9}, new int[]{1, 1}),
                Arguments.of(new double[]{0.1, 3.3, 4.1}, new double[]{2.9, 3.7, 5.4}, new int[]{0, 1, 2}),
                Arguments.of(new double[]{}, new double[]{1.0, 3.0, 3.0}, new int[]{-1, -1, -1}),
                Arguments.of(new double[]{1.0, 2.0, 2.3}, new double[]{}, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("arrays")
    @DisplayName("Get insertion indexes")
    void getInsertionIndexes(double[] sequence, double[] anotherSequence, int[] result) {
        int[] insertionIndexes = insertionService.getInsertionIndexes(sequence, anotherSequence);
        resultWriter.printArray(insertionIndexes);

        assertArrayEquals(result, insertionIndexes);
    }
}
