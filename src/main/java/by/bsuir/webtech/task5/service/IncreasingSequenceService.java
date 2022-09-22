package by.bsuir.webtech.task5.service;

import java.util.Arrays;

public class IncreasingSequenceService {

    public int getNumberItemsToRemove(int[] sequence) {
        if (sequence.length == 0)
            return 0;

        int[] increasingSubsequence = new int[sequence.length];
        increasingSubsequence[0] = sequence[0];
        int length = 1;

        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] > increasingSubsequence[length - 1]) {
                increasingSubsequence[length++] = sequence[i];
            } else {
                int insertionIndex = getInsertionIndex(increasingSubsequence, length, sequence[i]);
                increasingSubsequence[insertionIndex] = sequence[i];
            }
        }
        return sequence.length - length;
    }

    private int getInsertionIndex(int[] sequence, int actualLength, int itemToInsert) {
        int insertionIndex = Arrays.binarySearch(sequence, 0, actualLength - 1, itemToInsert);
        return insertionIndex < 0 ? Math.abs(insertionIndex) - 1 : insertionIndex;
    }
}
