package playground.leetcode;


public class FruitsIntoBasketsIII {

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        // if under 100 prev approach
        if (baskets.length == 0) {
            return 0;
        }
        int chunksSize = (int) Math.sqrt(baskets.length);
        int chunks = (baskets.length + chunksSize - 1) / chunksSize;
        int[] maxs = new int[chunks];

        for (int i = 0; i < baskets.length; i++) {
            maxs[i / chunksSize] = Math.max(maxs[i / chunksSize], baskets[i]);
        }
        int res = 0;
        for (int fruit : fruits) {
            int unset = 1;
            for (int chunckIndex = 0; chunckIndex < maxs.length; chunckIndex++) {
                if (fruit > maxs[chunckIndex]) {
                    continue;
                }
                maxs[chunckIndex] = 0;
                for (int i = 0; i < chunksSize; i++) {
                    int pos = chunckIndex * chunksSize + i;
                    if (pos >= baskets.length) {
                        break;
                    }
                    if (baskets[pos] >= fruit && unset == 1) {
                        unset = 0;
                        baskets[pos] = 0;
                    }
                    maxs[chunckIndex] = Math.max(maxs[chunckIndex], baskets[pos]);
                }
                if (unset == 0) {
                    break;
                }
            }
            res += unset;
        }
        return res;
    }

    public static void main(String[] args) {
        FruitsIntoBasketsIII x = new FruitsIntoBasketsIII();
        System.out.println(x.numOfUnplacedFruits(new int[]{4, 2, 5}, new int[]{3, 5, 4}));
        System.out.println(x.numOfUnplacedFruits(new int[]{3, 6, 1}, new int[]{6, 4, 7}));
    }

}
