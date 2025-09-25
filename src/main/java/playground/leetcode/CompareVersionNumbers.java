package playground.leetcode;

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] first = version1.split("[.]");
        String[] second = version2.split("[.]");
        for (int i = 0; i < Math.max(first.length, second.length); i++) {
            String t1 = "0";
            if (i < first.length) {
                t1 = first[i];
            }
            String t2 = "0";
            if (i < second.length) {
                t2 = second[i];
            }
            int cmp = compareMinor(t1, t2);
            if(cmp == 0){
                continue;
            }
            return cmp;
        }

        return 0;
    }

    private int compareMinor(String t1, String t2) {
        long v1 = Long.parseLong(t1);
        long v2 = Long.parseLong(t2);
        return Long.compare(v1, v2);
    }

    public static void main(String[] args) {
        CompareVersionNumbers cvn = new CompareVersionNumbers();
        System.out.println(cvn.compareVersion("1.2", "1.10")==-1 );
        System.out.println(cvn.compareVersion("1.01",  "1.001")==0 );
        System.out.println(cvn.compareVersion("1.0",  "1.0.0.0")==0 );
    }
}
