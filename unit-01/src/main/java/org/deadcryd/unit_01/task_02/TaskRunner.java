package org.deadcryd.unit_01.task_02;

import java.util.Random;

public class TaskRunner {

    private static final Random RANDOMIZER = new Random();

    public static void main(String[] args) {
        double a = RANDOMIZER.nextDouble(-100, 100);
        double b = RANDOMIZER.nextDouble(a, 100);
        double h = RANDOMIZER.nextDouble(0, 20);

        var tableBuilder = new TableBuilder( 2, 8)
            .appendLine()
            .appendRow("x", "F(x)")
            .appendLine();

        for (var i = a; i <= b; i += h) {
            tableBuilder.appendRow(
                String.format("%.2f", i),
                String.format("%.2f", mathFunction(i))
            );
        }

        tableBuilder.appendLine();

        System.out.printf("a = %.2f, b = %.2f, h = %.2f\n", a, b, h);
        System.out.println(tableBuilder.build());
    }

    public static double mathFunction(double x) {
        return Math.tan(2 * x) - 3;
    }
}
