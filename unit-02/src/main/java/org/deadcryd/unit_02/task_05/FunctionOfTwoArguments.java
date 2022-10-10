package org.deadcryd.unit_02.task_05;

@FunctionalInterface
public interface FunctionOfTwoArguments<T extends Number> {

    T calculate(T a, T b);
}
