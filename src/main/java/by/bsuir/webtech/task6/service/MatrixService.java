package by.bsuir.webtech.task6.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class MatrixService {

    public double[][] buildMatrix(double[] numbers) {
        return IntStream.range(0, numbers.length)
                .mapToObj(offset -> shiftRow(numbers, offset))
                .toArray(double[][]::new);
    }

    private double[] shiftRow(double[] row, int offset) {
        List<Double> shiftedRow = new ArrayList<>(Arrays.stream(row).boxed().toList());
        Collections.rotate(shiftedRow, shiftedRow.size() - offset);
        return shiftedRow.stream()
                .mapToDouble(Double::doubleValue)
                .toArray();
    }
}
