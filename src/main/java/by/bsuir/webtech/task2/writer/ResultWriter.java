package by.bsuir.webtech.task2.writer;

import by.bsuir.webtech.task2.model.Point;

public class ResultWriter {

    public void printResult(Point point, boolean result) {
        System.out.println(point.toString() + " is " + (result ? "inside" : "outside") + " given area");
    }
}
