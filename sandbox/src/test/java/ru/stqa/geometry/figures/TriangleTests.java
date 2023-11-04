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

    @Test
    void testEquality() {
        var t1 = new Triangle(2.0, 3.0, 4.0);
        var t2 = new Triangle(2.0, 3.0, 4.0);
        var t3 = new Triangle(2.0, 4.0, 3.0);
        var t4 = new Triangle(4.0, 3.0, 2.0);
        var t5 = new Triangle(4.0, 2.0, 3.0);
        var t6 = new Triangle(3.0, 2.0, 4.0);
        var t7 = new Triangle(3.0, 4.0, 2.0);
        Assertions.assertEquals(t1, t2);
        Assertions.assertEquals(t1, t3);
        Assertions.assertEquals(t1, t4);
        Assertions.assertEquals(t1, t5);
        Assertions.assertEquals(t1, t6);
        Assertions.assertEquals(t1, t7);
    }

    @Test
    void testNonEquality() {
        var t1 = new Triangle(2.0, 3.0, 4.0);
        var t2 = new Triangle(5.0, 2.0, 5.0);
        Assertions.assertNotEquals(t1, t2);
    }
}
