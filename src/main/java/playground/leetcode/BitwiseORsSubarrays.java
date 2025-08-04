package playground.leetcode;

import java.util.HashSet;
import java.util.Set;

public class BitwiseORsSubarrays {

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> all = new HashSet<>(32);
        Set<Integer> prev = new HashSet<>(32);
        prev.add(0);
        for (int x : arr) {
            Set<Integer> current = new HashSet<>(32);
            for (int val : prev) {
                current.add(val | x);
            }
            current.add(x);
            prev = current;
            all.addAll(prev);
            if(all.size() == 32){
                return 32;
            }
        }

        return all.size();
    }


}
