package ru.stqa.geometry.figures;

import java.util.Objects;

import static java.lang.Math.sqrt;

public record Triangle(double a, double b, double c) {

    public Triangle {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Сторона треугольника не может быть отрицательной");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Такого треугольника не существует. Сумма двух сторон не должна быть меньше третьей стороны.");
        }
    }

    public static void printTriangleArea(Triangle triangle) {
        String text = String.format("Площадь треугольника со сторонами %f, %f, %f равен %f", triangle.a, triangle.b, triangle.c, triangle.area());
        System.out.println(text);
    }

    public static void printTrianglePerimeter(Triangle triangle) {
        String text = String.format("Периметр треугольника со сторонами %f, %f, %f равен %f", triangle.a, triangle.b, triangle.c, triangle.perimeter());
        System.out.println(text);
    }

    public double area() {
        double semiPerimeter = perimeter() / 2;
        return sqrt(semiPerimeter * (semiPerimeter - this.a) * (semiPerimeter - this.b) * (semiPerimeter - this.c));
    }

    public double perimeter() {
        return this.a + this.b + this.c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(this.a, triangle.a) == 0 && Double.compare(this.b, triangle.b) == 0 && Double.compare(this.c, triangle.c) == 0)
                || (Double.compare(this.a, triangle.a) == 0 && Double.compare(this.c, triangle.b) == 0 && Double.compare(this.b, triangle.c) == 0)
                || (Double.compare(this.b, triangle.a) == 0 && Double.compare(this.a, triangle.b) == 0 && Double.compare(this.c, triangle.c) == 0)
                || (Double.compare(this.c, triangle.a) == 0 && Double.compare(this.b, triangle.b) == 0 && Double.compare(this.a, triangle.c) == 0)
                || (Double.compare(this.c, triangle.a) == 0 && Double.compare(this.a, triangle.b) == 0 && Double.compare(this.b, triangle.c) == 0)
                || (Double.compare(this.b, triangle.a) == 0 && Double.compare(this.c, triangle.b) == 0 && Double.compare(this.a, triangle.c) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}