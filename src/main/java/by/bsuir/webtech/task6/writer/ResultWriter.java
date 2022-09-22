package by.bsuir.webtech.task6.writer;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ResultWriter {

    public void printMatrix(double[][] matrix) {
        System.out.println(Arrays.stream(matrix)
                .map(row -> Arrays.stream(row)
                        .mapToObj(element -> new StringBuilder(String.format("%.2f", element)))
                        .collect(Collectors.joining(", ")))
                .collect(Collectors.joining("\n")));
    }
}
