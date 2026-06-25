package playground.leetcode2;

public class FindtheHighestAltitude {

    public int largestAltitude(int[] gain) {
        int c =0;
        int max =0;
        for(int vae:gain){
            c+=vae;
            max = Math.max(c, max);
        }
        return max;
    }

}
