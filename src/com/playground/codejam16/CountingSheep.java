package com.playground.codejam16;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.BitSet;
import java.util.Scanner;

/**
 * User: liviu
 * Date: 4/9/16
 * Time: 5:40 PM
 */
public class CountingSheep {

    public static void main(String... args) throws FileNotFoundException {
        HackeRrankUtils hru = new HackeRrankUtils();
        long t = hru.scanner.nextLong();
       // solve(1692);
        for (int tt = 0; tt < t; tt++) {
            long l = hru.scanner.nextLong();
            System.out.print("Case #" + (tt + 1) + ": ");
            solve(l);
        }

    }

    private static void solve(long l) {
        long start = System.currentTimeMillis();
        int k = 0;
        BigInteger bi = BigInteger.valueOf(l);
        BitSet bs = new BitSet(10);
        while (true) {
            k++;
            if (k % 1000 == 0) {
                if (System.currentTimeMillis() - start > 1000) {
                    System.out.println("INSOMNIA");
                    break;
                }
            }
            BigInteger nbi = bi.multiply(BigInteger.valueOf(k));
            String digits = nbi.toString();
            for (int i = 0; i < digits.length(); i++) {
                int digit = (int) (digits.charAt(i) - '0');
                bs.set(digit);
                //System.out.println(bs);
                if (bs.cardinality() == 10) {
                    System.out.println(digits);
                    return;
                }
            }
        }

    }


    public static class HackeRrankUtils {

        File file = new File("inputs/g/in1.txt");

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
