package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateArea() {
        var s = new Triangle(4.0, 5.0, 3.0);
        double result = s.area();
        Assertions.assertEquals(6.0, result);
    }

    @Test
    void canCalculatePerimeter() {
        var p = new Triangle(3.0, 10.0, 9.0);
        double result = p.perimeter();
        Assertions.assertEquals(22.0, result);
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-3.0, 2.0, 6.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ОК
        }
    }

    @Test
    void cannotCreateTriangle() {
        try {
            new Triangle(1.0, 2.0, 3.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ОК
        }
    }
}
