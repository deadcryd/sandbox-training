package org.deadcryd.unit_01.task_03;

import java.util.Arrays;
import java.util.Random;

public class SourceFileExample {

    private static final Random RANDOMIZER = new Random();

    public static void main(String[] args) {
        int[][] numbers = initNumbers(5, 8);
        int[][] result = new int[5][2];

        for (int i = 0; i < result.length; i++) {
            result[i][0] = maxNumberInRow(numbers, i);
        }

        printMatrix(numbers);
        printMatrix(result);
    }

    public static int[][] initNumbers(int row, int col) {
        int[][] matrix = new int[row][col];

        for (var i = 0; i < row; i++) {
            for (var j = 0; j < col; j++) {
                matrix[i][j] = RANDOMIZER.nextInt(-100, 100);
            }
        }

        return matrix;
    }

    public static int maxNumberInRow(int[][] matrix, int rowIndex) {
        var result = matrix[rowIndex][0];

        for (var i = 1; i < matrix[rowIndex].length; i++) {
            result = Math.max(result, matrix[rowIndex][i]);
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println(Arrays.deepToString(matrix));
    }
}
