package playground.leetcode2;

public class WeightedWordMapping {

    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(String word:words){
            sb.append(toChar(word, weights));
        }
        return sb.toString();
    }

    private char toChar(String word, int[] weights) {
        int sum = 0;
        for(char c:word.toCharArray()){
            sum += weights[c-'a'];
        }
        return (char)('z' - sum % 26);
    }

}
