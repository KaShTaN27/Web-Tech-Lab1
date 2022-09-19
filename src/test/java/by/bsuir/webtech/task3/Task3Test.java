package by.bsuir.webtech.task3;

import by.bsuir.webtech.task3.exception.InvalidSegmentBordersException;
import by.bsuir.webtech.task3.exception.InvalidSegmentStepException;
import by.bsuir.webtech.task3.service.TangentsService;
import by.bsuir.webtech.task3.writer.ResultWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task3Test {

    private final TangentsService tangentsService = new TangentsService();
    private final ResultWriter resultWriter = new ResultWriter();

    @Test
    @DisplayName("Calculate tan on segment")
    void calculateTanOnSegment() {
        Map<Double, Double> tangentsResults =
                tangentsService.calculateTanOnSegment(0.5, 6.0, 0.1);
        resultWriter.printTangentsMap(tangentsResults);
        tangentsResults.forEach((key, value) -> assertEquals(value, Math.tan(key)));
    }

    @Test
    @DisplayName("Skip values where tan is undefined")
    void calculateTanOnSegment_IfSegmentContainsValuesWhereTanUndefined() {
        Map<Double, Double> tangentsResults =
                tangentsService.calculateTanOnSegment(0.5 * Math.PI, 2.57, 0.1);
        resultWriter.printTangentsMap(tangentsResults);
        assertEquals(9, tangentsResults.size());
    }

    @Test
    @DisplayName("Catch InvalidSegmentStepException because step is negative")
    void calculateTanOnSegment_IfStepNegative() {
        assertThrows(InvalidSegmentStepException.class,
                () -> tangentsService.calculateTanOnSegment(0.0, 6.0, -1.0));
    }

    @Test
    @DisplayName("Catch InvalidSegmentBordersException because right border less than left")
    void calculateTanOnSegment_IfRightBorderLessThanLeft() {
        assertThrows(InvalidSegmentBordersException.class,
                () -> tangentsService.calculateTanOnSegment(0.0, -2.3, 1.0));
    }
}
