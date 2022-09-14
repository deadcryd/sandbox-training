package org.deadcryd.unit_01.task_04;

import java.util.Scanner;

public class TaskRunner {

    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Input a, b, c for ax^2 + bx + c = 0\n>");

        var a = INPUT.nextDouble();
        var b = INPUT.nextDouble();
        var c = INPUT.nextDouble();

        var d = b * b - 4 * a * c;
        var result = new StringBuilder("Equation solution:\n");

        if (d > 0) {
            var x1 = (-b - Math.sqrt(d)) / (2 * a);
            var x2 = (-b + Math.sqrt(d)) / (2 * a);
            result
                .append(String.format("x1 = %.2f%n", x1))
                .append(String.format("x2 = %.2f", x2));
        } else if (d < 0) {
            var realPart = -b / (2 * a);
            var imaginaryPart = Math.sqrt(Math.abs(d)) / (2 * a);
            result
                .append(String.format("x1 = %.2f + %.2fi%n", realPart, imaginaryPart))
                .append(String.format("x2 = %.2f - %.2fi", realPart, imaginaryPart));
        } else {
            var x = -b / (2 * a);
            result
                .append(String.format("x = %.2f", x));
        }

        System.out.println(result);
    }
}
