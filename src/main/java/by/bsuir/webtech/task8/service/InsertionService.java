package by.bsuir.webtech.task8.service;

public class InsertionService {

    public int[] getInsertionIndexes(double[] sequence, double[] anotherSequence) {
        int[] insertionIndexes = new int[anotherSequence.length];
        int i = 0;
        int j = 0;
        int insertionIndex = -1;
        while (i < sequence.length && j < anotherSequence.length) {
            if (sequence[i] <= anotherSequence[j])
                insertionIndex = i++;
            else
                insertionIndexes[j++] = insertionIndex;
        }
        while (j < anotherSequence.length)
            insertionIndexes[j++] = sequence.length - 1;
        return  insertionIndexes;
    }
}
