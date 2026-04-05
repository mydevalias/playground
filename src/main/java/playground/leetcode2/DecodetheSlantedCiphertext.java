package playground.leetcode2;

public class DecodetheSlantedCiphertext {

    public String decodeCiphertext(String encodedText, int rows) {
        int columns = encodedText.length() / rows;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < columns; i++) {
            int ii = i;
            while (ii < encodedText.length()) {
                sb.append(encodedText.charAt(ii));
                ii = ii + columns+1;
            }
        }

        return  sb.toString().stripTrailing();
    }

}
