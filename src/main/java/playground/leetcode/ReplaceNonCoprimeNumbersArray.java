package playground.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReplaceNonCoprimeNumbersArray {

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            while (!result.isEmpty()) {
                int last = result.get(result.size() - 1);
                int g = gcd(last, num);
                if (g == 1) {
                    break;
                }
                result.remove(result.size() - 1);
                num = (last / g) * num;
            }

            result.add(num);
        }

        return result;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
