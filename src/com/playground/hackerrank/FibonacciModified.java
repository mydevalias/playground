package com.playground.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by liviu on 14.03.2016.
 */
public class FibonacciModified {
    public static void main(String... args) throws FileNotFoundException {
        HackeRrankUtils hru = new HackeRrankUtils();
        BigInteger first = BigInteger.valueOf(hru.scanner.nextLong());
        BigInteger second = BigInteger.valueOf(hru.scanner.nextLong());
        long n = hru.scanner.nextLong();
        for (int i = 0; i < n - 2; i++) {
            BigInteger third = second.pow(2).add(first);
            first = second;
            second = third;
        }

        System.out.println(second);
    }

    public static class HackeRrankUtils {

        File file = new File("inputs/contacts/in.txt");

        Scanner scanner = new Scanner(System.in);

        StringBuilder output = new StringBuilder();

        public HackeRrankUtils() throws FileNotFoundException {
            //  scanner = new Scanner(file);
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
