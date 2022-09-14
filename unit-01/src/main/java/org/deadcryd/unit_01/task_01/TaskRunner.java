package org.deadcryd.unit_01.task_01;

import java.util.Arrays;

public class TaskRunner {

    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 10, 12};
        printArray(numbers);
        printArray(changeArrayWithForLoop(numbers));
        printArray(changeArrayWithForEachLoop(numbers));
        printArray(changeArrayWithWhileLoop(numbers));
        printArray(changeArrayWithDoWhileLoop(numbers));
    }

    public static int[] changeArrayWithForLoop(int[] array) {
        array = Arrays.copyOf(array, array.length);

        for (int i = 1; i < array.length; i += 2) {
            array[i] *= array[i - 1];
        }
        return array;
    }

    public static int[] changeArrayWithForEachLoop(int[] array) {
        array = Arrays.copyOf(array, array.length);

        var index = 0;
        for (var element : array) {
            if (index % 2 == 0 && index < array.length - 1) {
                array[index + 1] *= element;
            }
            index++;
        }

        return array;
    }

    public static int[] changeArrayWithWhileLoop(int[] array) {
        array = Arrays.copyOf(array, array.length);

        var index = 1;
        while (index < array.length) {
            array[index] *= array[index - 1];
            index += 2;
        }

        return array;
    }

    public static int[] changeArrayWithDoWhileLoop(int[] array) {
        array = Arrays.copyOf(array, array.length);

        if (array.length < 2) {
            return array;
        }

        var index = 1;
        do {
            array[index] *= array[index - 1];
            index += 2;
        } while (index < array.length);

        return array;
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
