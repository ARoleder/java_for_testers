package ru.stqa.geometry.figures;

import static java.lang.Math.sqrt;

public class Triangle {

  private double a;
  private double b;
  private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void printTriangleArea(Triangle triangle){
        String text = String.format("Площадь треугольника со сторонами %f, %f, %f равен %f", triangle.a,triangle.b,triangle.c, triangle.area());
        System.out.println(text);
    }

    public static void printTrianglePerimeter(Triangle triangle) {
        String text = String.format("Периметр треугольника со сторонами %f, %f, %f равен %f", triangle.a,triangle.b,triangle.c, triangle.perimeter());
        System.out.println(text);
    }

    public double area() {
        double semiPerimeter = perimeter()/2;
        return sqrt(semiPerimeter*(semiPerimeter-this.a)*(semiPerimeter-this.b)*(semiPerimeter-this.c));
    }

    public double perimeter() {
        return this.a +this.b +this.c;
    }

}