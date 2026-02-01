package playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, Math.abs(arr[i] - arr[i + 1]));
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            while (j < arr.length && Math.abs(arr[i] - arr[j]) == min) {
                ArrayList<Integer> current = new ArrayList<>();
                current.add(arr[i]);
                current.add(arr[j]);
                res.add(current);
                j++;
            }
        }

        return res;
    }

}
