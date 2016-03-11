package com.playground.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by liviu on 08.03.2016.
 */
public class MatrixRotation {

    public static void main(String... args) throws FileNotFoundException {
        HackeRrankUtils hru = new HackeRrankUtils();
        String aux[] = hru.nextLine().split("[ ]");
        int n = Integer.parseInt(aux[0]);
        int m = Integer.parseInt(aux[1]);
        int rotate = Integer.parseInt(aux[2]);

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            aux = hru.nextLine().split("[ ]");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(aux[j]);
            }
        }

        //printMatrix(matrix);
        //rotate = rotate % (2 * (m + n - 2));
        //for (int i = 0; i < rotate; i++) {
        rotate(matrix, rotate);
        //}
        printMatrix(matrix);

    }

    /**
     * You are given a 2D matrix, a, of dimension MxN and a positive integer R. You have to rotate the matrix R times
     * and print the resultant matrix. Rotation should be in anti-clockwise direction.
     *
     * @param matrix
     * @param rotate
     */

    private static void rotate(int[][] matrix, int rotate) {
        int level = 0;

        int n = matrix.length;
        int m = matrix[0].length;
        while (true) {
            int tmpR = rotate % (2 * (m + n - 4 * level - 2));
            for (int r = 0; r < tmpR; r++) {
                int carry = matrix[level][level];
                for (int i = level; i < m - level - 1; i++) {
                    matrix[level][i] = matrix[level][i + 1];
                }
                for (int i = level; i < n - level - 1; i++) {
                    matrix[i][m - level - 1] = matrix[i + 1][m - level - 1];
                }
                for (int i = m - level - 1; i > level; i--) {
                    matrix[n - level - 1][i] = matrix[n - level - 1][i - 1];
                }
                for (int i = n - level - 1; i > level; i--) {
                    matrix[i][level] = matrix[i - 1][level];
                }
                matrix[level + 1][level] = carry;
            }
            level++;
            if (level >= Math.min(n, m) / 2) {
                break;
            }
        }
        //System.out.println("done");
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static class HackeRrankUtils {

        File file = new File("in.txt");

        Scanner scanner = new Scanner(System.in);

        StringBuilder output = new StringBuilder();

        public HackeRrankUtils() throws FileNotFoundException {
            scanner = new Scanner(file);
        }

        void printBuilder() {
            System.out.print(output.toString());
        }

        void line() {
            output.append(System.lineSeparator());
        }

        String nextLine() {
            return scanner.nextLine();
        }

    }
}
