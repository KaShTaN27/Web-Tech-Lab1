package by.bsuir.webtech.task4;

import by.bsuir.webtech.task4.service.PrimeNumberService;
import by.bsuir.webtech.task4.writer.ResultWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task4Test {

    private final PrimeNumberService primeNumberService = new PrimeNumberService();
    private final ResultWriter resultWriter = new ResultWriter();

    private static Stream<Arguments> numbersAndPrimesIndexes() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 2}, new int[]{1, 2}),
                Arguments.of(new int[]{0, 1 , 4, 6}, new int[]{}),
                Arguments.of(new int[]{2, 3, 5, 7}, new int[]{0, 1, 2, 3}),
                Arguments.of(new int[]{-4, 2, 0, 17}, new int[]{1, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("numbersAndPrimesIndexes")
    @DisplayName("Get prime numbers indexes of array")
    void getPrimeNumbersIndexes(int[] numbers, int[] primesIndexes) {
        int[] primeNumbersIndexes = primeNumberService.getPrimeNumbersIndexes(numbers);
        resultWriter.printIntArray(primeNumbersIndexes);

        assertEquals(primesIndexes.length, primeNumbersIndexes.length);
        IntStream.range(0, primeNumbersIndexes.length)
                .forEach(index -> assertEquals(primesIndexes[index], primeNumbersIndexes[index]));
    }
}
