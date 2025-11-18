package playground.leetcode;

public class CheckIfAllAreLeastLengthKPlacesAway {

    public boolean kLengthApart(int[] nums, int k) {
        int currentLength = 0;
        for (int val : nums) {
            if (val == 1) {
                if (currentLength == k) {
                    currentLength = 0;
                }else{
                    return false;
                }
            } else {
                if (currentLength >= k) {
                    return false;
                }
                currentLength++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfAllAreLeastLengthKPlacesAway checkIfAllAreLeastLengthKPlacesAway = new CheckIfAllAreLeastLengthKPlacesAway();
        System.out.println(checkIfAllAreLeastLengthKPlacesAway.kLengthApart(new int[]{1,0,0,0,1,0,0,1}, 2));
        System.out.println(checkIfAllAreLeastLengthKPlacesAway.kLengthApart(new int[]{1,0,0,1,0,1}, 2));
    }
}
