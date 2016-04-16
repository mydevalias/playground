package com.playground.codejam16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.BitSet;
import java.util.Scanner;

/**
 * User: liviu
 * Date: 4/9/16
 * Time: 6:41 PM
 */
public class RevengeOfThePancakes {

    public static void main(String... args) throws FileNotFoundException {
        HackeRrankUtils hru = new HackeRrankUtils();
        long t = Long.parseLong(hru.scanner.nextLine());
        for (int tt = 0; tt < t; tt++) {
            String in = hru.scanner.nextLine();
            System.out.print("Case #" + (tt + 1) + ": ");
            solve(in);
        }

    }

    private static void solve(String in) {
        BitSet bs = new BitSet(in.length());
        for (int i = 0; i < in.length(); i++) {
            if ('+' == in.charAt(i)) {
                bs.set(i);
            }
        }

        int k = 0;
        for (int pos = in.length(); pos >= 0; pos--) {
            if (bs.cardinality() == in.length()) {
                System.out.println(k);
                return;
            }
            if (!bs.get(pos-1)) {
                k++;
                bs.flip(0, pos);
            }
        }
        System.out.println(k);
    }


    public static class HackeRrankUtils {

        File file = new File("inputs/g/in2.txt");

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
