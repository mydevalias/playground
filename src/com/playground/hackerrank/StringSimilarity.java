package com.playground.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by liviu on 19.03.2016.
 */
public class StringSimilarity {

    public static void main(String... args) throws FileNotFoundException {
        HackeRrankUtils hru = new HackeRrankUtils();
        int testCaseCount = Integer.parseInt(hru.scanner.nextLine());
        for (int t = 0; t < testCaseCount; t++) {
            String s = hru.scanner.nextLine();

        }
    }


    public static class HackeRrankUtils {

        File file = new File("inputs/maximumsubarray/in.txt");

        Scanner scanner = new Scanner(System.in);

        StringBuilder output = new StringBuilder();

        public HackeRrankUtils() throws FileNotFoundException {
           // scanner = new Scanner(file);
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
