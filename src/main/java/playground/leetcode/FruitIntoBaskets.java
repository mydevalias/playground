package playground.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/fruit-into-baskets/description
 */
public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        if (fruits.length < 2) {
            return fruits.length;
        }
        int max = 1;
        int behind = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(fruits[0], 1);
        int sum = 1;
        for (int i = 1; i < fruits.length; i++) {
            sum++;
            inc(map, fruits[i]);
            while (map.size() > 2) {
                dec(map, fruits[behind]);
                behind++;
                sum--;
            }
            max = Math.max(max, sum);
        }

        return max;
    }


    private void dec(Map<Integer, Integer> map, int fruit) {
        Integer prev = map.get(fruit);
        if (prev == 1) {
            map.remove(fruit);
            return;
        }
        prev--;
        map.put(fruit, prev);
    }

    private void inc(Map<Integer, Integer> map, int fruit) {
        Integer prev = map.get(fruit);
        if (prev == null) {
            prev = 0;
        }
        prev++;
        map.put(fruit, prev);
    }

    public static void main(String[] args) {
        FruitIntoBaskets fib = new FruitIntoBaskets();
//        System.out.println(fib.totalFruit(new int[]{1, 2, 1}));
        System.out.println(fib.totalFruit(new int[]{0, 1, 2, 2}));
    }

}
