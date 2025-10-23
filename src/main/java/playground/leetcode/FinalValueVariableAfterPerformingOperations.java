package playground.leetcode;

public class FinalValueVariableAfterPerformingOperations {

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(int i=0;i<operations.length;i++){
            if(operations[i].contains("x")){
                x++;
            }else{
                x--;
            }
        }
        return x;
    }

}
