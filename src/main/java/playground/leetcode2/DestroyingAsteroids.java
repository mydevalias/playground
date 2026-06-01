package playground.leetcode2;

import java.util.Arrays;

public class DestroyingAsteroids {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long cm = mass;
        for (var vla : asteroids) {
            if (cm > vla) {
                cm = cm + vla;
            } else {
                return false;
            }
        }
        return true;
    }

}
