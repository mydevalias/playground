package com.playground.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by liviu on 21.03.2016.
 */
public class PalindromeIndex {

    public static void main(String... args) throws FileNotFoundException {
        HackeRrankUtils hru = new HackeRrankUtils();
        int testCaseCount = Integer.parseInt(hru.scanner.nextLine());
        for (int t = 0; t < testCaseCount; t++) {
            String s = hru.scanner.nextLine();
            if (isPalindrome(s)) {
                hru.println("-1");
            } else {
                for (int i = 0; i < s.length() / 2; i++) {
                    if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                        StringBuilder sb = new StringBuilder(s);
                        sb.deleteCharAt(i);
                        if (isPalindrome(sb.toString())) {
                            hru.println("" + i);
                        } else {
                            hru.println("" + (s.length() - i - 1));
                        }
                        break;
                    }
                }
            }
        }
        hru.printBuilder();

    }

    public static boolean isPalindrome(String a) {
        for (int i = 0; i < a.length() / 2; i++) {
            if (a.charAt(i) != a.charAt(a.length() - i - 1)) {
                return false;
            }
        }
        return true;
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

        public void println(String s) {
            output.append(s);
            line();
        }
    }

}
