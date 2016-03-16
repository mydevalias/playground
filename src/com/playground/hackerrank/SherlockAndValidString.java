package com.playground.hackerrank;


import java.util.*;

/**
 * Created by liviu on 16.03.2016.
 */
public class SherlockAndValidString {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[index(str.charAt(i))]++;
        }
        Map<Integer, Integer> collect = new HashMap<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                Integer v = collect.get(count[i]);
                if (v == null) {
                    v = 0;
                }
                int nv = v + 1;
                collect.put(count[i], nv);
            }
        }
        if (collect.size() > 2) {
            System.out.println("NO");
        } else {
            if (collect.size() == 1) {
                System.out.printf("YES");
            } else {
                Iterator<Map.Entry<Integer, Integer>> it = collect.entrySet().iterator();
                Map.Entry<Integer, Integer> first = it.next();
                Map.Entry<Integer, Integer> second = it.next();
                int expected = first.getValue() > second.getValue() ? first.getValue() : second.getValue();
                int toBeCorrectedExample = first.getValue() < second.getValue() ? first.getValue() : second.getValue();
                int toBeCorrectedExamplekey = first.getValue() < second.getValue() ? first.getKey() : second.getKey();
                if (toBeCorrectedExample > 1) {
                    System.out.println("NO");
                } else {
                    if (toBeCorrectedExample == 1 && toBeCorrectedExamplekey == 1) {
                        System.out.printf("YES");
                    } else {
                        if (Math.abs(first.getKey() - second.getKey()) > 1) {
                            System.out.println("NO");
                        } else {
                            System.out.printf("YES");
                        }
                    }

                }

            }
        }


        //System.out.println(collect);
    }


    private static int index(char c) {
        return c - 'a';
    }


}
