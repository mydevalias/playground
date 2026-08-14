package playground.leetcode3;

import java.util.Map;
import java.util.TreeMap;

public class LongestSubstringofOneRepeatingCharacter {


    TreeMap<Integer, Integer> chunks = new TreeMap<>();
    ChunkLengths lengths = new ChunkLengths();
    char[] chars;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        chars = s.toCharArray();
        init();

        int[] result = new int[queryCharacters.length()];
        for (int i = 0; i < queryCharacters.length(); i++) {
            int index = queryIndices[i];
            char newChar = queryCharacters.charAt(i);

            if (chars[index] != newChar) {
                applyUpdate(index, newChar);
            }
            result[i] = lengths.max();
        }
        return result;
    }

    private void init() {
        int chunkStart = 0;
        for (int i = 1; i <= chars.length; i++) {
            boolean chunkEndsHere = (i == chars.length) || (chars[i] != chars[chunkStart]);
            if (chunkEndsHere) {
                recordChunk(chunkStart, i - chunkStart);
                chunkStart = i;
            }
        }
    }

    private void applyUpdate(int index, char newChar) {
        Chunk oldChunk = findChunkContaining(index);
        deleteChunck(oldChunk);
        chars[index] = newChar;

        if (index > oldChunk.start()) {
            recordChunk(oldChunk.start(), index - oldChunk.start());
        }
        if (index < oldChunk.end()) {
            recordChunk(index + 1, oldChunk.end() - index);
        }

        Chunk left = leftChunkIfMatches(index, newChar);
        Chunk right = rightChunkIfMatches(index, newChar);

        if (left == null && right == null) {
            recordChunk(index, 1);

        } else if (right != null && left == null) {
            deleteChunck(right);
            recordChunk(index, 1 + right.length());

        } else if (left != null && right == null) {
            deleteChunck(left);
            recordChunk(left.start(), left.length() + 1);

        } else {
            deleteChunck(left);
            deleteChunck(right);
            recordChunk(left.start(), left.length() + 1 + right.length());
        }
    }

    private Chunk leftChunkIfMatches(int index, char newChar) {
        if (index == 0 || chars[index - 1] != newChar) {
            return null;
        }
        Chunk chunk = findChunkContaining(index - 1);
        return chunk.end() == index - 1 ? chunk : null;
    }

    private Chunk rightChunkIfMatches(int index, char newChar) {
        if (index + 1 >= chars.length || chars[index + 1] != newChar) {
            return null;
        }
        Integer length = chunks.get(index + 1);
        return length == null ? null : new Chunk(index + 1, length);
    }

    private Chunk findChunkContaining(int index) {
        Map.Entry<Integer, Integer> entry = chunks.floorEntry(index);
        return new Chunk(entry.getKey(), entry.getValue());
    }

    private void recordChunk(int start, int length) {
        chunks.put(start, length);
        lengths.increase(length);
    }

    private void deleteChunck(Chunk chunk) {
        chunks.remove(chunk.start());
        lengths.decrease(chunk.length());
    }

    static class ChunkLengths {
        TreeMap<Integer, Integer> countsByLength = new TreeMap<>();

        int countLength(int length) {
            return countsByLength.getOrDefault(length, 0);
        }

        void increase(int length) {
            countsByLength.put(length, countsByLength.getOrDefault(length, 0) + 1);
        }

        void decrease(int length) {
            int remaining = countsByLength.get(length) - 1;
            if (remaining == 0) {
                countsByLength.remove(length);
            } else {
                countsByLength.put(length, remaining);
            }
        }

        int max() {
            return countsByLength.lastKey();
        }
    }

    private record Chunk(int start, int length) {
        int end() {
            return start + length - 1;
        }
    }


}