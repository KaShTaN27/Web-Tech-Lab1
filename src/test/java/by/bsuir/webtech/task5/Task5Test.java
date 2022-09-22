package by.bsuir.webtech.task5;

import by.bsuir.webtech.task5.service.IncreasingSequenceService;
import by.bsuir.webtech.task5.writer.ResultWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task5Test {

    private final IncreasingSequenceService increasingSequenceService =
            new IncreasingSequenceService();
    private final ResultWriter resultWriter = new ResultWriter();

    private static Stream<Arguments> sequenceAndNumberItemsToRemove() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 0),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, 4),
                Arguments.of(new int[]{1, 4, 2, 3, 9, 2, 6, 1 ,7, 8}, 4),
                Arguments.of(new int[]{}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("sequenceAndNumberItemsToRemove")
    @DisplayName("Get number items to remove")
    void getNumberItemsToRemove(int[] sequence, int resultAmount) {
        int numberItemsToRemove = increasingSequenceService.getNumberItemsToRemove(sequence);
        resultWriter.printItemsToRemove(sequence, numberItemsToRemove);

        assertEquals(resultAmount, numberItemsToRemove);
    }

}
