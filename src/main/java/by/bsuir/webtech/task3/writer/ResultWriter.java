package by.bsuir.webtech.task3.writer;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultWriter {

    public void printTangentsMap(Map<Double, Double> tanResults) {
        System.out.println(tanResults.entrySet().stream()
                .map(entry -> new StringBuilder(String.format("%6.2f | %6.2f", entry.getKey(), entry.getValue())))
                .collect(Collectors.joining("\n")));
    }
}
