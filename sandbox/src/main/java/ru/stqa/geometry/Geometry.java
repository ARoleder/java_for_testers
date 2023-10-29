package ru.stqa.geometry;

import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Triangle.printTriangleArea(new Triangle(8.0,12.0,8.0));
        Triangle.printTrianglePerimeter(new Triangle(11.0,12.0,9.0));
    }
}
