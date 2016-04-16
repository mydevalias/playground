package com.playground.codejam16.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

/**
 * User: liviu
 * Date: 4/11/16
 * Time: 2:08 PM
 */
public class MinimumScalarProduct {

    public static void main(String... args) throws FileNotFoundException {
        HackeRrankUtils hru = new HackeRrankUtils();
        long t = hru.scanner.nextLong();
        for (int tt = 0; tt < t; tt++) {
            System.out.print("Case #" + (tt + 1) + ": ");
            solve(hru.scanner);

        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        List<Integer> first = readArrayN(scanner, n);
        List<Integer> second = readArrayN(scanner, n);

        Collections.sort(first);
        Collections.sort(second, Collections.reverseOrder());
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            sum = sum.add(BigInteger.valueOf(first.get(i)).multiply(BigInteger.valueOf(second.get(i))));
        }
        System.out.println(sum);
    }

    private static List<Integer> readArrayN(Scanner scanner, int n) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        return list;
    }


    public static class HackeRrankUtils {

        File file = new File("inputs/g/in4.txt");

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
