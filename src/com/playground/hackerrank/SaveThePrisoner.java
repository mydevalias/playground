package com.playground.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A jail has NN prisoners, and each prisoner has a unique id number, SS, ranging from 11 to NN. There are MM sweets that must be distributed to the prisoners.
 * <p>
 * The jailer decides the fairest way to do this is by sitting the prisoners down in a circle (ordered by ascending SS), and then, starting with some random SS, distribute one candy at a time to each sequentially numbered prisoner until all MM candies are distributed. For example, if the jailer picks prisoner S=2S=2, then his distribution order would be (2,3,4,5,…,n−1,n,1,2,3,4,…)(2,3,4,5,…,n−1,n,1,2,3,4,…) until all MM sweets are distributed.
 * <p>
 * But wait—there's a catch—the very last sweet is poisoned! Can you find and print the ID number of the last prisoner to receive a sweet so he can be warned?
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer, TT, denoting the number of test cases.
 * The TT subsequent lines each contain 33 space-separated integers:
 * NN (the number of prisoners), MM (the number of sweets), and SS (the prisoner ID), respectively.
 * <p>
 * Constraints
 * <p>
 * 1≤T≤1001≤T≤100
 * 1≤N≤1091≤N≤109
 * 1≤M≤1091≤M≤109
 * 1≤S≤1091≤S≤109
 * Output Format
 * <p>
 * For each test case, print the ID number of the prisoner who receives the poisoned sweet on a new line.
 * <p>
 * Sample Input
 * <p>
 * 1
 * 5 2 1
 * Sample Output
 * <p>
 * 2
 * Explanation
 * <p>
 * There are N=5N=5 prisoners and M=2M=2 sweets. Distribution starts at ID number S=1S=1, so prisoner 11 gets the first sweet and prisoner 22 gets the second (last) sweet. Thus, we must warn prisoner 22 about the poison, so we print 22 on a new line.
 * <p>
 * Created by liviu on 19.03.2016.
 */
public class SaveThePrisoner {

    public static void main(String... args) throws FileNotFoundException {
        HackeRrankUtils hru = new HackeRrankUtils();
        int testCaseCount = hru.scanner.nextInt();
        for (int t = 0; t < testCaseCount; t++) {
            long n = hru.scanner.nextLong();
            long m = hru.scanner.nextLong();
            long s = hru.scanner.nextLong();
            m = m % n;
            if (m == 0) {
                s = s - 1;
                if (s < 1) {
                    s = n;
                }
                hru.output.append(s);
            } else {
                if (s + m <= n + 1) {
                    hru.output.append(s + m - 1);
                } else {
                    hru.output.append(s + m - n - 1);
                }
            }
            hru.line();
        }
        hru.printBuilder();
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
