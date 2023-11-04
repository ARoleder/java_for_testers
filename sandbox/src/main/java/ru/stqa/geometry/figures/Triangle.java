package ru.stqa.geometry.figures;

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

}