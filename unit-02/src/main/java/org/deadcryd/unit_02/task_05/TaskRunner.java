package org.deadcryd.unit_02.task_05;

public class TaskRunner {

    public static void main(String[] args) {
        BooleanFunction f1 = x -> x / 13.0 == 0;
        print(f1.calculate(12));

        FunctionOfThreeArguments f2 = (a, b, c) -> b * b - 4 * a * c;
        print(f2.calculate(1, 2, 3));

        FunctionOfTwoArguments<Integer> f3 = (Integer a, Integer b) -> a + b;
        print(f3.calculate(5, 10));

        FunctionOfTwoArguments<Double> f4 = (Double a, Double b) -> a + b;
        print(f4.calculate(43.4, 43.76));

        FunctionOfTwoArguments<Float> f5 = (Float a, Float b) -> a + b;
        print(f5.calculate(13.9f, 32.5f));
    }

    static void print(Object obj) {
        System.out.println(obj);
    }
}
