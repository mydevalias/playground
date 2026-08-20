package playground.leetcode3;

public class PredicttheWinner {

    int[] nums;

    public boolean predictTheWinner(int[] nums) {
        this.nums = nums;
        return pdw(0, 0, nums.length, true);
    }

    private boolean pdw(int delta, int start, int end, boolean playerOne) {
        if (start == end) {
            if (delta >= 0) {
                return true;
            }
            return false;
        }
        if(playerOne){
            return pdw(delta+nums[start], start+1, end, false)
                    ||  pdw(delta+nums[end-1], start, end-1, false);
        }else{
            return pdw(delta- nums[start], start+1, end, true)
                    &&  pdw(delta-nums[end-1], start, end-1, true);
        }
    }
}
