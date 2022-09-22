package by.bsuir.webtech.task4.service;

import java.util.stream.IntStream;

public class PrimeNumberService {

    public int[] getPrimeNumbersIndexes(int[] numbers) {
        return IntStream.range(0, numbers.length)
                .filter(index -> isPrimeNumber(numbers[index]))
                .toArray();
    }

    private boolean isPrimeNumber(int number) {
        return number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(index -> number % index == 0);
    }
}
