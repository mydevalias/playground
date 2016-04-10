package com.playground.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by liviu on 19.03.2016.
 */
public class CircularPalindromes {


    private final int[] pns;

    private final String input;

    private final char[] texts;

    public static void main(String... args) throws FileNotFoundException {
        HackeRrankUtils hru = new HackeRrankUtils();
        int rotate = Integer.valueOf(hru.nextLine());
        String input = hru.nextLine();
        for (int i = 0; i < rotate; i++) {
            CircularPalindromes pal = new CircularPalindromes(input);
            hru.output.append(pal.longest().length());
            hru.line();
            String f = "" + input.charAt(0);
            input = input.substring(1) + f;
        }
        hru.printBuilder();

    }


    public CircularPalindromes(String s) {
        this.input = s;
        texts = new char[this.input.length() * 2 + 3];
        init();
        pns = new int[texts.length];
        prc();
    }

    private void init() {
        texts[0] = '$';
        texts[this.input.length() * 2 + 2] = '@';
        for (int i = 0; i < this.input.length(); i++) {
            texts[2 * i + 1] = '#';
            texts[2 * i + 2] = this.input.charAt(i);
        }
        texts[this.input.length() * 2 + 1] = '#';
    }

    private void prc() {
        int c = 0, r = 0;
        for (int i = 1; i < texts.length - 1; i++) {
            int mr = 2 * c - i;

            if (r > i)
                pns[i] = Math.min(r - i, pns[mr]);

            while (texts[i + (1 + pns[i])] == texts[i - (1 + pns[i])])
                pns[i]++;

            if (i + pns[i] > r) {
                c = i;
                r = i + pns[i];
            }
        }
    }


    public String longest() {
        int l = 0;
        int c = 0;
        for (int i = 1; i < pns.length - 1; i++) {
            if (pns[i] > l) {
                l = pns[i];
                c = i;
            }
        }
        return input.substring((c - 1 - l) / 2, (c - 1 + l) / 2);
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
