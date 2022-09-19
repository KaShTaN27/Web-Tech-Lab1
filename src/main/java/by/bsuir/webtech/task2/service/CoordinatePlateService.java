package by.bsuir.webtech.task2.service;

import by.bsuir.webtech.task2.model.Point;
import by.bsuir.webtech.task2.model.Rectangle;

import java.util.List;

public class CoordinatePlateService {

    public boolean isPointInsideArea(Point point, List<Rectangle> rectangles) {
        return rectangles.stream()
                .anyMatch(rectangle -> isPointInsideRectangle(point, rectangle));
    }

    private boolean isPointInsideRectangle(Point point, Rectangle rectangle) {
        return Double.compare(point.getX(), rectangle.getTopLeft().getX()) >= 0 &&
                Double.compare(point.getX(), rectangle.getBottomRight().getX()) <= 0 &&
                Double.compare(point.getY(), rectangle.getTopLeft().getY()) <= 0 &&
                Double.compare(point.getY(), rectangle.getBottomRight().getY()) >= 0;
    }
}
