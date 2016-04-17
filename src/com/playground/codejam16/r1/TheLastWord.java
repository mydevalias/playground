package com.playground.codejam16.r1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * User: liviu
 * Date: 4/16/16
 * Time: 4:12 AM
 */
public class TheLastWord {

    public static void main(String... args) throws FileNotFoundException {
        HackeRrankUtils hru = new HackeRrankUtils();
        long t = Long.parseLong(hru.scanner.nextLine());
        for (int tt = 0; tt < t; tt++) {
            System.out.print("Case #" + (tt + 1) + ": ");
            solve(hru.scanner);

        }
    }

    private static void solve(Scanner scanner) {
        String s = scanner.nextLine();
        StringBuilder sb = new StringBuilder(s.length());
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current >= sb.charAt(0)) {
                sb.insert(0, current);
            } else {
                sb.append(current);
            }

        }
        System.out.println(sb.toString());

    }

    public static class HackeRrankUtils {

        File file = new File("inputs/g/in5.txt");

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
