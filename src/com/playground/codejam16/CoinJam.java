package com.playground.codejam16;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.BitSet;
import java.util.Scanner;

/**
 * User: liviu
 * Date: 4/9/16
 * Time: 7:23 PM
 */
public class CoinJam {

    public static void main(String... args) throws FileNotFoundException {
        HackeRrankUtils hru = new HackeRrankUtils();
        long t = hru.scanner.nextLong();
        for (int tt = 0; tt < t; tt++) {
            System.out.println("Case #" + (tt + 1) + ": ");
            int n = hru.scanner.nextInt();
            int j = hru.scanner.nextInt();
            solve(n, j);

        }
        //  test("100011");

    }

    private static void solve(int n, int f) {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 1; i < n - 1; i++) {
            sb.append('0');
        }
        sb.append('1');

        String start = sb.toString();
        //System.out.println(start);
        long value = Long.parseLong(start, 2);
        int ff = 0;
        while (ff < f) {
            String current = Long.toString(value, 2);
            if (current.charAt(current.length() - 1) == '1') {
                //System.out.println(current);
                if (test(current)) {
                    ff++;
                }
            }
            value++;
        }

    }

    private static boolean test(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= 10; i++) {
            long value = Long.parseLong(input, i);
            //System.out.println(value);
            if (isPrime(value, sb)) {
                return false;
            }
        }
        sb.insert(0, input);
        System.out.println(sb.toString());
        return true;
    }

    static boolean isPrime(long n, StringBuilder sb) {
        if (n % 2 == 0) {
            sb.append(" ").append("2");
            return false;
        }
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                sb.append(" ").append(i);
                return false;
            }
        }

        return true;
    }

    public static String bsString(BitSet bs) {
        StringBuilder reply = new StringBuilder();
        for (int x = 0; x < bs.length(); x++) {
            if (bs.get(x)) {
                reply.append('1');
            } else {
                reply.append('0');
            }
        }
        return reply.toString();

    }

    public static class HackeRrankUtils {

        File file = new File("inputs/g/in3.txt");

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