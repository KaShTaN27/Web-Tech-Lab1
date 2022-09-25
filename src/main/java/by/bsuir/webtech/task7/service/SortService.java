package by.bsuir.webtech.task7.service;

public class SortService {

    public void shellSort(double[] array) {
        int i = 0;
        while (i < array.length - 1) {
            if (Double.compare(array[i], array[i + 1]) > 0) {
                arithmeticSwap(array, i);
                if (i > 0)
                    i--;
            } else
                i++;
        }
    }

    private void arithmeticSwap(double[] array, int i) {
        array[i] += array[i + 1];
        array[i + 1] = array[i] - array[i + 1];
        array[i] -= array[i + 1];
    }
}
