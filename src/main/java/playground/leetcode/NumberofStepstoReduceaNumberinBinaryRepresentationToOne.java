package playground.leetcode;

public class NumberofStepstoReduceaNumberinBinaryRepresentationToOne {


    public int addOne(int[] number, int n) {
        for (int i = 0; i <= n - 1; i++) {
            if (number[i] == 0) {
                number[i] = 1;
                return n;
            }
            number[i] = 0;
        }
        number[n] = 1;
        return n + 1;
    }

    public int[] divideByTwo(int[] number, int n) {
        for (int i = 0; i < n - 1; i++) {
            number[i] = number[i + 1];
        }
        number[n - 1] = 0;
        return number;
    }

    public int numSteps(String s) {
        int n = s.length();
        int[] number = new int[n + 1];
        for (int i = 0; i < n; i++) {
            number[i] = s.charAt(n - 1 - i) - '0';
        }

        int res = 0;
        while (n > 1) {
            res++;
            if (number[0] == 1) {
                n = addOne(number, n);
            } else {
                divideByTwo(number, n);
                n--;
            }
        }
        return res;
    }


}
