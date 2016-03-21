package com.playground.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by liviu on 19.03.2016.
 */
public class ExtraLongFactorials {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        BigInteger bi = BigInteger.valueOf(1);
        for (int i = 1; i < n + 1; i++) {
            bi = bi.multiply(BigInteger.valueOf(i));
        }
        System.out.println(bi);
    }
}
