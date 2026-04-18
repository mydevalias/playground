package playground.leetcode2;

import java.util.Objects;

public class ShortestDistancetoTargetStringinaCircularArray {

    public int closestTarget(String[] words, String target, int startIndex) {
        int dist = 0;
        while (true) {
            if (Objects.equals(target, words[(startIndex + dist) % words.length])) {
                break;
            }
            if (Objects.equals(target, words[(startIndex - dist + words.length) % words.length])) {
                break;
            }
            dist++;
            if(dist == words.length){
                return -1;
            }
        }
        return dist;
    }

}
