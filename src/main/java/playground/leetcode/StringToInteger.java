package playground.leetcode;

public class StringToInteger {

    public int myAtoi(String s) {
        if (s==null ||s.isEmpty()){
            return 0;
        }
        s = s.strip();
        if (s==null ||s.isEmpty()){
            return 0;
        }
        int sign = 1;
        int start = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            start = 1;
        }
        if (s.charAt(0) == '+') {
            start = 1;
        }
        long res = 0;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);

            int val = c - '0';
            if (0 <= val && val <= 9) {
                res = res * 10 + val;
                if (res > Integer.MAX_VALUE) {
                    if(sign==-1){
                        return Integer.MIN_VALUE;
                    }
                    return Integer.MAX_VALUE ;
                }
            } else {
                break;
            }

        }
        return (int) res * sign;
    }

    public static void main(String[] args) {
        StringToInteger x = new StringToInteger();
        System.out.println(x.myAtoi("   +0 123"));
        System.out.println(x.myAtoi("42"));
        System.out.println(x.myAtoi("-042"));
        System.out.println(x.myAtoi("1337c0d3"));
        System.out.println(x.myAtoi("0-1"));
        System.out.println(x.myAtoi("words and 987"));
        System.out.println(x.myAtoi("-91283472332"));
    }

}
