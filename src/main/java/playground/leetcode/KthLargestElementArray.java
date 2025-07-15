package playground.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementArray {

    public int sortfindKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int naturalFindKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k+1);
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        KthLargestElementArray k = new KthLargestElementArray();
        System.out.println(k.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
