package by.bsuir.webtech.task3.service;

import by.bsuir.webtech.task3.exception.InvalidSegmentBordersException;
import by.bsuir.webtech.task3.exception.InvalidSegmentStepException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class TangentsService {

    public Map<Double, Double> calculateTanOnSegment(double startSegment, double endSegment, double segmentStep) {
        if (Double.compare(endSegment, startSegment) <= 0)
            throw new InvalidSegmentBordersException("Right border must be grater than left");
        if (Double.compare(segmentStep, 0.0) <= 0)
            throw new InvalidSegmentStepException("Step must be grater than zero");
        return DoubleStream
                .iterate(startSegment, d -> d <= endSegment, i -> i + segmentStep)
                .filter(d -> d % (0.5 * Math.PI) != 0)
                .boxed()
                .collect(Collectors.toMap(Double::doubleValue, Math::tan, (x, y) -> y, LinkedHashMap::new));
    }
}
